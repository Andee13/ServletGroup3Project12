package com.berest.oleg.controller;

import com.berest.oleg.controller.processors.Processor;
import com.berest.oleg.controller.processors.ProcessorLogOut;
import com.berest.oleg.controller.processors.ProcessorMainPage;
import com.berest.oleg.controller.processors.ProcessorShowAllStudents;
import com.berest.oleg.model.ProcessorResult;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class DispatcherServlet extends HttpServlet {

    public List<Processor> listOfProcessors = new ArrayList<>();

    @Override
    public void init() throws ServletException {
        super.init();
        listOfProcessors.add(new ProcessorMainPage());
        listOfProcessors.add(new ProcessorShowAllStudents());
        listOfProcessors.add(new ProcessorLogOut());
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        process(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        process(request,response);
    }

    private void process (HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String action = request.getParameter("action");
//        response.setContentType("text/html;charset=UTF-8");
//        PrintWriter out = response.getWriter();
//        try {
//            out.println("<html>");
//            out.println("<body>");
//            out.println("<p>Hello, world<p>");
//            out.println("<p>action:" + action + "<p>");
//
//        } finally {
//            out.println("</body>");
//            out.println("</html>");
//        }
        for(Processor processor : listOfProcessors){
            if(processor.canProcess(action)){
                ProcessorResult result = processor.process(request);
                if(result.getIncludedPage() != null){
                    request.getSession().setAttribute("includedPage", result.getIncludedPage());
                }
                if(result.isForward()){
                    RequestDispatcher rd = request.getRequestDispatcher(result.getUrl());
                    rd.forward(request, response);
                } else {
                    response.sendRedirect(result.getUrl());
                }


            }
        }

    }
}
