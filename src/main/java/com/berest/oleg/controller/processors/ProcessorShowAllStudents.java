package com.berest.oleg.controller.processors;

import com.berest.oleg.model.ProcessorResult;
import com.berest.oleg.model.Student;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

public class ProcessorShowAllStudents extends Processor {

    public ProcessorShowAllStudents () {
        actionToPerform = "showAllStudets";
    }

    @Override
    public ProcessorResult process(HttpServletRequest request) {
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student(1, "Kate"));
        studentList.add(new Student(2, "Pavel"));
        request.getSession().setAttribute("studentList", studentList);
        return new ProcessorResult("pages/Template.jsp", "", true);
    }
}
