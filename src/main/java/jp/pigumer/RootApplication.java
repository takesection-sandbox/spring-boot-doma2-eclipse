package jp.pigumer;

import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.sqlite.JDBC;

@ComponentScan
@EnableAutoConfiguration
@Configuration
public class RootApplication {
    
    @Bean
    public DataSource getDataSource() {
        BasicDataSource ds = new BasicDataSource();
        ds.setDriverClassName(JDBC.class.getName());
        ds.setUrl("jdbc:sqlite:database.db");
        return ds;
    }
    
    public static void main(String[] args) {
        SpringApplication.run(RootApplication.class, args);
    }
}
