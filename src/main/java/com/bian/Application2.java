package com.bian;

import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;

import java.io.InputStream;
import java.util.Properties;

/**
 * Created by Mr.Bi on 2017/6/2.
 */
@SpringBootApplication(exclude = {Application1.class})
public class Application2 {
    public static void main(String[] args){
        InputStream in = Application2.class.getClassLoader().getResourceAsStream("application2.yml");
        Resource resource = new InputStreamResource(in);
        YamlPropertiesFactoryBean yamlFactory = new YamlPropertiesFactoryBean();
        yamlFactory.setResources(resource);
        Properties properties = yamlFactory.getObject();
        SpringApplication app = new SpringApplication(Application2.class);
        app.setDefaultProperties(properties);
        app.run(args);
    }
}
