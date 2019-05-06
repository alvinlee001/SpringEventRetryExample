/*
 * Copyright © 2018 iFAST Corporation Ltd (“iFAST Corp”)
 *
 * iFAST Corp (or any other iFAST entity as authorized by iFAST Corp) grants permission to you, to have access to the above source codes (the “Source Codes”).
 *
 * You may not use the Source Codes except in compliance with the agreement and/or instruction of iFAST Corp (or any other iFAST entity as authorized by iFAST Corp). Except as agreed in writing or required by applicable law, the Source Codes are given on an "as is" basis, without warranties of any kind, either express or implied including, without limitation, any warranties regarding the contents or accuracy of the Source Codes.
 *
 * Except to the extent required by applicable law, in no event will iFAST Corp (or any other iFAST entity as authorized by iFAST Corp) be liable to you on any legal theory for any special, incidental, consequential, punitive or exemplary damages arising out of the use of the Source Codes, even if iFAST Corp (or any other iFAST entity as authorized by iFAST Corp) has been advised of the possibility of such damages.
 *
 */

package com.example.demo.model;

import lombok.Data;
import org.springframework.context.ApplicationEvent;

import java.util.UUID;

@Data
public abstract class AbstractEventModel extends ApplicationEvent {

    private String id = UUID.randomUUID().toString();

    /**
     * Create a new ApplicationEvent.
     *
     * @param source the object on which the event initially occurred (never {@code null})
     */
    public AbstractEventModel(Object source) {
        super(source);
    }

    public AbstractEventModel() {
        super("SYSTEM");
    }
}
