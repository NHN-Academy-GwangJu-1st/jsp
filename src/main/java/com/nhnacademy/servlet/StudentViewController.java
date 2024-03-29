package com.nhnacademy.servlet;

import com.nhnacademy.domain.Student;
import com.nhnacademy.repository.StudentRepository;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

public class StudentViewController implements Command {

    @Override
    public String excute(HttpServletRequest req, HttpServletResponse resp) {
        ServletContext servletContext = req.getServletContext();


        StudentRepository studentRepository = (StudentRepository) servletContext.getAttribute("studentRepository");

        String id = req.getParameter("id");

        Student student = studentRepository.get(id);
        if (Objects.isNull(student)) {
//            resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return "/404.jsp";
        } else {
            req.setAttribute("student", student);

            return "/studentView.jsp";
//            req.setAttribute("view", "/studentView.jsp");
//            RequestDispatcher rd = req.getRequestDispatcher("/studentView.jsp");
//            rd.forward(req, resp);
        }
    }
}
