package com.Web.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/controller/bmi_session_invalid")
public class BMI1SessionInvalidServlet extends HttpServlet {
protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
     HttpSession session = req.getSession(false);
     PrintWriter out = resp.getWriter();
     out.println("Session invalid , session id:"+session.getId());
     session.invalidate(); //程式執行完才會啟動
    }
}