package com.bian.publisher.custom;

import com.bian.event.custom.MyRemoteEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.bus.endpoint.AbstractBusEndpoint;
import org.springframework.cloud.bus.endpoint.BusEndpoint;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Mr.Bi on 2017/6/2.
 */
@Component
public class MyRemoteEventPublisher extends AbstractBusEndpoint {

    @Autowired
    public MyRemoteEventPublisher(ApplicationContext context, BusEndpoint busEndpoint) {
        super(context, context.getId(), busEndpoint);
    }

    //最终url:bus/myEvent
    @RequestMapping(value = "myEvent", method = RequestMethod.POST)
    @ResponseBody
    public void publish(@RequestParam(name = "message", required = false) String message) {
        MyRemoteEvent myRemoteEvent = new MyRemoteEvent(message);
        System.out.println("publish myRemoteEvent!");
        super.publish(myRemoteEvent);
    }
}
