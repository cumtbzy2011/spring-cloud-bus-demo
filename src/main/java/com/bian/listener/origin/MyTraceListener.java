package com.bian.listener.origin;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.cloud.bus.event.AckRemoteApplicationEvent;
import org.springframework.cloud.bus.event.SentApplicationEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * Created by Mr.Bi on 2017/6/2.
 */
@Component
@ConditionalOnProperty(value = "spring.cloud.bus.trace.enabled", matchIfMissing = false)
public class MyTraceListener {

    //此事件表示某个事件的消息已经被接收
    @EventListener
    public void onAck(AckRemoteApplicationEvent event) {
        System.out.println("this is my ackEvent listener!");
    }

    //此事件表示一个远程事件消息已经被正常发送
    @EventListener
    public void onSend(SentApplicationEvent event) {
        System.out.println("this is my sentEvent listener!");
    }
}
