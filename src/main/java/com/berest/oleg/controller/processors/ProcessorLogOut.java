package com.berest.oleg.controller.processors;

import com.berest.oleg.model.ProcessorResult;

import javax.servlet.http.HttpServletRequest;

public class ProcessorLogOut extends Processor{

    public ProcessorLogOut(){
        actionToPerform="LogOut";
    }

    @Override
    public ProcessorResult process(HttpServletRequest request) {
        request.getSession().invalidate();
        return new ProcessorResult("ServletTemlate/webapp/pages/welcome.jsp", null, false);

    }
}
