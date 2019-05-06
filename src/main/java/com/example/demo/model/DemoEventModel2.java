package com.example.demo.model;

import lombok.Data;

@Data
public class DemoEventModel2 extends AbstractEventModel {
    private String fieldA;
    private String fieldB;
    private String fieldC;

    public DemoEventModel2(Object source) {
        super(source);
    }

    public DemoEventModel2() {
        super();
    }
}
