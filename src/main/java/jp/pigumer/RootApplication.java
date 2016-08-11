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
package jp.pigumer;

import jp.pigumer.interceptor.LoggingAdvisor;
import jp.pigumer.interceptor.LoggingInterceptor;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
@EnableAutoConfiguration
@SpringBootConfiguration
public class RootApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(RootApplication.class, args);
    }
    
    @Bean
    DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator() {
    	return new DefaultAdvisorAutoProxyCreator();
    }
    
    @Bean
    LoggingAdvisor loggingAdvisor() {
    	return new LoggingAdvisor();
    }
    
    @Bean
    LoggingInterceptor loggingInterceptor() {
    	return new LoggingInterceptor();
    }
}
