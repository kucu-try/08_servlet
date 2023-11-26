package com.ohgiraffers.mvc.employee.controller;

import com.ohgiraffers.mvc.employee.dto.EmpDeleteDTO;
import com.ohgiraffers.mvc.employee.dto.EmpUpdateDTO;
import com.ohgiraffers.mvc.employee.service.EmpService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/employees2")
public class DeleteEmpServlet extends HttpServlet {
   private EmpService empService;

   @Override
   public void init() throws ServletException {
      empService = new EmpService();
   }
   @Override
   protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      req.setCharacterEncoding("UTF-8");
      EmpDeleteDTO delete = new EmpDeleteDTO();


      delete.setEmpId(req.getParameter("empId"));


      int result = empService.delete(delete);
      String path;
      if (result > 0) {
         path = "/WEB-INF/views/common/successPage.jsp";
         req.setAttribute("message", "직원 삭제 성공");
      }else {
         path = "/WEB-INF/views/common/errorPage.jsp";
         req.setAttribute("message" , "직원 삭제 실패");
      }
      req.getRequestDispatcher(path).forward(req,resp);
   }

   @Override
   public void destroy() {
      empService = null;
   }


}
