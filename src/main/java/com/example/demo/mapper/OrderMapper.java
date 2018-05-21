package com.example.demo.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * Created by huangmingjie on 2018/5/10.
 */
@Mapper
public interface OrderMapper {
    String findOrder(String orderNo);
}
