package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true,value = { "source" })
public class DemoEventModel1 extends AbstractEventModel{
    private String field1;
    private String field2;
    private String field3;

    public DemoEventModel1() {
        super();
    }

    public DemoEventModel1(Object source) {
        super(source);
    }
}
