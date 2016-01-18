package jp.pigumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan
@EnableAutoConfiguration
@Configuration
public class RootApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(RootApplication.class, args);
    }
}
