package com.bian.listener.custom;

import com.bian.event.custom.MyRemoteEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * Created by Mr.Bi on 2017/6/2.
 */
@Component
public class MyRemoteEventListener {

    @EventListener
    public void onMy(MyRemoteEvent event) {
        System.out.println("listen myRemoteEvent: " + event.getMessage());
    }
}
