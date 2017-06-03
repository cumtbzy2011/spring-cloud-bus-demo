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
@SpringBootApplication(exclude = {Application2.class})
public class Application1 {
    public static void main(String[] args){
        InputStream in = Application1.class.getClassLoader().getResourceAsStream("application1.yml");
        Resource resource = new InputStreamResource(in);
        YamlPropertiesFactoryBean yamlFactory = new YamlPropertiesFactoryBean();
        yamlFactory.setResources(resource);
        Properties properties = yamlFactory.getObject();
        SpringApplication app = new SpringApplication(Application1.class);
        app.setDefaultProperties(properties);
        app.run(args);
    }

    //发布事件:localhost:8080/bus/refresh

    //访问8080/refresh节点，指定destination=test2:8090，8080,8090服务都会响应一个refreshEvent
    //访问8080/refresh节点，指定destination=test1:8080，只有8080服务会响应一个refreshEvent
    //发布事件的服务自身一定会响应本事件，一般通过访问configserver发布refresh事件
}
