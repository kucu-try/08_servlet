package com.ohgiraffers.section01;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

@WebFilter("/first/*")
public class FirstFilter implements Filter {

    public FirstFilter() {
        System.out.println("first Filter 인스턴스 생성");
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("firstFilter init 생성");
    }

    @Override
    public void destroy() {
        System.out.println("filter destory 호출");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("Filter do Filter 호출 ");

        chain.doFilter(request, response);

        System.out.println("servlet 수행완료");
    }
}
