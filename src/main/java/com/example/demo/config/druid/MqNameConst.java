package com.wepiao.config.mq;

/**
 * Created by ping zi on 17/1/11.
 */
public interface MqNameConst {

    String BIS_MOVIE_SCHEDULE = "bisMovieSchedule"; //排期修改通知的队列
    String BIS_MOVIE_SCHEDULE_MQ_EXCHANGE = "bisMovieSchedule-redis-exchange"; //exchange队列

}
