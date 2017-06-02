package com.bian.event.custom;

import org.springframework.cloud.bus.event.RemoteApplicationEvent;

/**
 * Created by Mr.Bi on 2017/6/2.
 */
public class MyRemoteEvent extends RemoteApplicationEvent {
    private final String message;

    public MyRemoteEvent(String message) {
        super();
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
