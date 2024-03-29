package com.nhnacademy.servlet;

import com.nhnacademy.domain.Student;
import com.nhnacademy.repository.StudentRepository;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class StudentRegisterController implements Command {

    @Override
    public String excute(HttpServletRequest req, HttpServletResponse resp) {

        StudentRepository studentRepository = (StudentRepository) req.getServletContext().getAttribute("studentRepository");

        Student student = new Student(
                req.getParameter("id"),
                req.getParameter("name"),
                req.getParameter("gender"),
                Integer.parseInt(req.getParameter("age"))
        );

        studentRepository.addStudent(student);

        return "redirect:/student/view.do?id=" + student.getId();
//        req.setAttribute("view", "redirect:/student/view.do?id=" + student.getId());
//        resp.sendRedirect("/student/view?id=" + student.getId());
    }
}
