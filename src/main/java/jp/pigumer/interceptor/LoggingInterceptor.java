package jp.pigumer.interceptor;

import javax.servlet.http.HttpServletRequest;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class LoggingInterceptor implements MethodInterceptor {

	private static final Logger LOG = LoggerFactory.getLogger(LoggingInterceptor.class);

	@Autowired
	ObjectFactory<HttpServletRequest> requestFactory;
	
	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		HttpServletRequest request = requestFactory.getObject();
		
		LOG.info(String.format("start: %s %s", request.getRequestURI(), invocation.getMethod()));
		
		try {
			return invocation.proceed();
		} finally {
			LOG.info(String.format("end: %s %s", request.getRequestURI(), invocation.getMethod()));
		}
	}

}
