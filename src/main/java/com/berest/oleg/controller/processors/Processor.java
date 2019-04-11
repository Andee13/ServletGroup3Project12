package com.berest.oleg.controller.processors;

import com.berest.oleg.model.ProcessorResult;

import javax.servlet.http.HttpServletRequest;

public abstract class Processor {
    protected String actionToPerform;

    public boolean canProcess(String action) {
        return actionToPerform.equals(action);
    }

    public abstract ProcessorResult process(HttpServletRequest request);
}
