package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true,value = { "source" })
public class DemoEventModel1 {
    private String field1;
    private String field2;
    private String field3;

    /**
     * Create a new ApplicationEvent.
     *
     * @param source the object on which the event initially occurred (never {@code null})
     */
    public DemoEventModel1(Object source) {
//        super(source);
    }

    public DemoEventModel1() {
//        super(new Object());
    }
}
