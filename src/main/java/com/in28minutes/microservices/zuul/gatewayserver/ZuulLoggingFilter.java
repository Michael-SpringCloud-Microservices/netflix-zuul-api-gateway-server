/**
 * 
 */
package com.in28minutes.microservices.zuul.gatewayserver;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

/**
 * @author 109726
 *
 */
@Component
public class ZuulLoggingFilter extends ZuulFilter{

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Override
	/**
	 * setting the flag whether the filer has to work on request(s) or not
	 */	
	public boolean shouldFilter() {
		return true;
	}

	@Override
	/**
	 * The logic to be executed once the request is intercepted
	 */
	public Object run() throws ZuulException {
		HttpServletRequest request = RequestContext.getCurrentContext().getRequest();
        logger.info("request -> {} request uri -> {}", request, request.getRequestURI());
		return null;
	}

	@Override
	/**
	 * When the request has to be filtered i.e. before execution or after execution or on error occurrence
	 * pre - before executing the request
	 * post - after executing the request
	 * error - on error occurrence of execution of any request 
	 */			
	public String filterType() {
		return "pre";
	}

	@Override
	/**
	 * setting the filter order
	 */
	public int filterOrder() {
		return 1;
	}

}
