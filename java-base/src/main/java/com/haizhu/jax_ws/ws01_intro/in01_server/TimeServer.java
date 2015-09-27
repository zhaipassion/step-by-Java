package com.haizhu.jax_ws.ws01_intro.in01_server;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

/**
 * 服务接口类SEI
 * 
 * @author HZ
 */
@WebService
@SOAPBinding(style = Style.RPC)
public interface TimeServer {
	@WebMethod
	String getTimeAsString();

	@WebMethod
	long getTimeAsElapsed();
}