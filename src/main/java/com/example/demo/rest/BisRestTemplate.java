package com.example.demo.rest;

import lombok.Cleanup;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.StreamUtils;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPInputStream;

@Component
@Slf4j
public class BisRestTemplate {
    
    private final String DEF_ENCODING_UTF_8 = "UTF-8";
    
    @Autowired
    private RestTemplate restTemplate;
    
    public String get(String url, Map<String, String> headerMap, Map<String, String> reqMap) {
        ResponseEntity<byte[]> response =
                httpGet(url, headerMap, reqMap, byte[].class, restTemplate);
        return getHttpResponseContent(response);
    }
    
    private ResponseEntity<byte[]> httpGet(String url, Map<String, String> headerMap, Map<String, String> reqMap,
                                           Class<byte[]> responseType, RestTemplate restTemplate) {
        ResponseEntity<byte[]> responseEntity = null;
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url);
        try {
            if (reqMap != null) {
                reqMap.entrySet().forEach(e -> builder.queryParam(e.getKey(), e.getValue()));
            }
            HttpHeaders headers = new HttpHeaders();
            if (headerMap != null) {
                for (Map.Entry<String, String> entry : headerMap.entrySet()) {
                    headers.set(entry.getKey(), entry.getValue());
                }
            }
            HttpEntity entity = new HttpEntity<>(headers);
            responseEntity = restTemplate
                    .exchange(builder.build().encode().toUri(), HttpMethod.GET, entity, responseType);
        } catch (Exception e) {
            log.error("get error", e);
            throw e;
        }
        return responseEntity;
    }
    
    public String getHttpResponseContent(ResponseEntity<byte[]> httpResponse) {
        if (httpResponse != null) {
            List<String> encodings = httpResponse.getHeaders().get("Content-Encoding");
            List<String> contentTypes = httpResponse.getHeaders().get("Content-Type");
            String charset = DEF_ENCODING_UTF_8;
            // application/json;odata=minimalmetadata;streaming=true;charset=utf-8
            if (contentTypes != null) {
                for (String contentType : contentTypes) {
                    if (contentType.contains("charset")) {
                        String[] types = contentType.split(";");
                        for (String type : types) {
                            String[] kv = type.split("=");
                            if ("charset".equals(kv[0])) {
                                charset = kv[1];
                                break;
                            }
                        }
                    }
                }
            }
            try {
                if (encodings != null && encodings.stream().anyMatch(e -> e.equalsIgnoreCase("gzip"))) {
                    @Cleanup
                    GZIPInputStream gis = new GZIPInputStream(new ByteArrayInputStream(httpResponse.getBody()));
                    try {
                        return StreamUtils.copyToString(gis, Charset.forName(charset));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else {
                    return httpResponse.getBody() != null ? new String(httpResponse.getBody(), charset)
                            : "";
                }
            } catch (Exception e) {
                log.error("getHttpResponseContent error", e);
            }
        }
        return "";
    }
    
}
