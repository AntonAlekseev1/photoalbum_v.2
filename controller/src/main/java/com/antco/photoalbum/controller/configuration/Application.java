package com.antco.photoalbum.controller.configuration;

import com.antco.photoalbum.dao.configuration.DaoConfiguration;
import com.antco.photoalbum.service.ServiceConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@EnableConfigurationProperties
@ComponentScan({ "com.antco.photoalbum.controller"})
@Import({DaoConfiguration.class, ServiceConfiguration.class})
public class Application  {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
