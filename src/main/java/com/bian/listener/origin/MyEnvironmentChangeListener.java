package com.bian.listener.origin;

import org.springframework.cloud.bus.event.EnvironmentChangeListener;
import org.springframework.cloud.bus.event.EnvironmentChangeRemoteApplicationEvent;
import org.springframework.stereotype.Component;

/**
 * Created by Mr.Bi on 2017/6/2.
 * 监听原生事件：environment Change event - 会动态更新spring环境属性，
 * 和Refresh event不同：这个事件可以动态指定键值对，用来更新context属性，
 * 而refreshevent只是单纯的刷新配置文件，不能动态指定值
 */
@Component
public class MyEnvironmentChangeListener extends EnvironmentChangeListener {
    @Override
    public void onApplicationEvent(EnvironmentChangeRemoteApplicationEvent event) {
        System.out.println("this is my environmentchangeevent listener!");
    }
}
