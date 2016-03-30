/*
 * Copyright 2016 Pigumer Group Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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
