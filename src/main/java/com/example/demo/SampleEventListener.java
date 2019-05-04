package com.example.demo;

import com.example.demo.model.DemoEventModel1;
import com.example.demo.model.DemoEventModel2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class SampleEventListener {


    @Async
    @EventListener()
    public void handleEventType1(DemoEventModel1 demoEventModel1) {
        log.info("======================================================");
        log.info("handleTestReflectionModelEvent invoked !!!!");
        log.info("DemoEventModel1 : {}", demoEventModel1);
        log.info("======================================================");

        throw new RuntimeException("test.out.shit");
    }

    @Async
    @EventListener()
    public void handleEventType2(DemoEventModel2 demoEventModel2) {
        log.info("======================================================");
        log.info("handleTestReflectionModelEvent invoked !!!!");
        log.info("DemoEventModel2 : {}", demoEventModel2);
        log.info("======================================================");
    }


}
