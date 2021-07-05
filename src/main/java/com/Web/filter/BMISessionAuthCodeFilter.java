package com.web.filter;

import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter(urlPatterns = {"/controller/bmi_session"})
public class BMISessionAuthCodeFilter extends HttpFilter {

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        
        if (req.getMethod().equalsIgnoreCase("get")) { // 當get方法時取用
            chain.doFilter(req, res);
        } else if (req.getMethod().equalsIgnoreCase("post")) {// 當post方法時才取用Session
            // 驗證授權碼
            String code = req.getParameter("code");
            HttpSession session = req.getSession();
            Object authCode = session.getAttribute("authCode"); //轉物件防止null產生
            if (authCode != null && code.equals(authCode.toString())) {
                session.setAttribute("authCode", null); //比較成功時轉為空值須F5才能重置
                chain.doFilter(req, res);
            } else {
                session.invalidate();                                            //錯誤刪除(F5)
                res.getWriter().print(code + " == " + authCode);
            }
        }
    }

}