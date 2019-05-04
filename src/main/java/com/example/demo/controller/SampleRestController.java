package com.example.demo.controller;

import com.example.demo.model.DemoEventModel1;
import com.example.demo.model.DemoEventModel2;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ClassUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class SampleRestController {

    @Autowired
    ApplicationEventPublisher applicationEventPublisher;

    @GetMapping("publishEvent1")
    public String publishEvent() {
        this.runClassNameDeserializaitonSnippet1();
        return "done";
    }

    @GetMapping("publishEvent2")
    public String publishEvent2() {
        this.runClassNameDeserializaitonSnippet2();
        return "done";
    }

    private void runClassNameDeserializaitonSnippet1() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT);
        try{
            String json = mapper.writeValueAsString(initSampleEvent1());
            log.info("JSON value: {}", json);
            Object obj =  mapper.readValue(json, ClassUtils.getClass("com.example.demo.model.DemoEventModel1"));
            log.info("obj value: {}", obj);
            applicationEventPublisher.publishEvent(obj);
        } catch (Exception e) {
            log.error("fucked up", e);
        }
    }

    private void runClassNameDeserializaitonSnippet2() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT);
        try{
            String json = mapper.writeValueAsString(initSampleEvent2());
            log.info("JSON value: {}", json);
            Object obj =  mapper.readValue(json, ClassUtils.getClass("com.example.demo.model.DemoEventModel2"));
            log.info("obj value: {}", obj);
            applicationEventPublisher.publishEvent(obj);
        } catch (Exception e) {
            log.error("fucked up", e);
        }
    }

    private DemoEventModel2 initSampleEvent2() {
        DemoEventModel2 modelA = new DemoEventModel2();
        modelA.setFieldA("A");
        modelA.setFieldB("B");
        modelA.setFieldC("C");
        return modelA;
    }

    private DemoEventModel1 initSampleEvent1() {
        DemoEventModel1 modelA = new DemoEventModel1(this);
        modelA.setField1("1");
        modelA.setField2("2");
        modelA.setField3("3");
        return modelA;
    }

}
