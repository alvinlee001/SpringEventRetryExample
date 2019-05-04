package com.example.demo.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ClassUtils;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;

@Slf4j
@Configuration
@EnableAsync
public class AsyncConfig implements AsyncConfigurer {

    @Autowired
    ApplicationEventPublisher applicationEventPublisher;

    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return (ex, method, params) -> {
            log.error("method, "+method.getName()+" has an error",ex);
            log.info("getAsyncUncaughtExceptionHandler() called");
            log.info("params: {}", params);
            ObjectMapper mapper = new ObjectMapper();
            String json = null;
            try{
                json = mapper.writeValueAsString(params[0]);
            }catch(Exception e) {
                log.error("mapper write failed...", e);
            }
            String className = ClassUtils.getCanonicalName(params[0]);
            log.info("JSON: {}. CLASSNMAE: {}", json, className);

            this.recreateEvent( json, className);
        };

    }

    private void recreateEvent(String json, String classname){
        ObjectMapper mapper = new ObjectMapper();
        try {
            Object recreaatedEvent = mapper.readValue(json, ClassUtils.getClass(classname));
            Thread.sleep(5000);
            this.applicationEventPublisher.publishEvent(recreaatedEvent);
        } catch (Exception e) {
            log.error("Error during recreateEvent()", e);
        }
    }

}
