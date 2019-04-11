package com.berest.oleg.controller.processors;

import com.berest.oleg.model.ProcessorResult;

import javax.servlet.http.HttpServletRequest;

public class ProcessorMainPage extends Processor {

    public ProcessorMainPage () {
        actionToPerform = "MainPage";
    }

    @Override
    public ProcessorResult process(HttpServletRequest request) {
        String username = request.getParameter("username");
        request.getSession().setAttribute("username", username);


        return new ProcessorResult("/pages/Template.jsp", null, true);
    }
}
