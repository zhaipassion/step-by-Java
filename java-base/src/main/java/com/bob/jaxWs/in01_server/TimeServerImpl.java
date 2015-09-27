package com.bob.jaxWs.in01_server;

import java.text.DateFormat;
import java.util.Date;
import javax.jws.WebService;

/**
 * 服务实现类SIB
 *
 * @author Bob
 */
@WebService(endpointInterface = "myweb.service.TimeServer")
public class TimeServerImpl implements TimeServer {
    /**
     * 返回从1970年1月1日0点0时0分起的毫秒数
     */
    public long getTimeAsElapsed() {
        return new Date().getTime();
    }

    /**
     * 返回如“2009-12-21”格式的日期
     */
    public String getTimeAsString() {
        Date date = new Date();
        DateFormat df = DateFormat.getDateInstance();
        return df.format(date);
    }
}