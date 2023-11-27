package com.ohgiraffers.redirect.section02.otherservlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/redirect")
public class RedirectServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("이 서블릿으로 redirect 성공!");
        String test = (String) req.getAttribute("test");

        StringBuilder redirectText = new StringBuilder();
        redirectText.append("<!doctype html>\n")
                .append("<head>\n")
                .append("</head>\n")
                .append("<body>\n")
                .append("<h1>이 서블릿으로 redirect 성공!</h1>")
                .append("<h1> test의 값은 " + test + "</h1>")
                .append("</body>\n")
                .append("</html>\n");

        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter out = resp.getWriter();
        out.print(redirectText);
        out.flush();
        out.close();

        /*
        * redirect 하면 url 이 재작성 되어 새로고침 할 때 redirect 된 페이지에 대한 요청을 반복한다.
        * 즉, 이전 요청에 포함된 정보는 남아있지 않고 url 이 변경되는 것이redirect의 특징이다.
        * http 요청은 요청시 잠시 connection을 맺고 응답시에도 잠시 connection을 맺으며 요청 단위당 request 개체는 한개만
        * 생성된가. 따라서 첫 요청시 의 리퀘스트와 현재 리다이렉트된 페이지의 리퀘스트는
        * redirect를 쓰면 이전 서블릿의 값을 공유해서 사용할 수 없게 된다.
        *
        * */
    }
}
