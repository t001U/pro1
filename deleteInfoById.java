package com.Word_Test.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.Word_Test.ServiceImpl.frinancingproductDaoImpl;
import com.Word_Test.dao.FrinancingproductDao;
import com.Word_Test.dao.Impl.FrinancingproductDaoImpl;
import com.Word_Test.dao.entity.Frinancingproduct;
import com.Word_Test.Service.frinancingproductDao;
/**
 * 查询所有理财产品信息控制器
 * @author Administrator
 *
 */
public class deleteInfoById extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		frinancingproductDaoImpl dao = new frinancingproductDaoImpl();
		String id = req.getParameter("id");
		PrintWriter out = resp.getWriter();
		int result = dao.deleteInfoById(id);
		if(result>0) {
		out.print("y");
		out.flush();
		resp.sendRedirect("js/deleteInfoById.js");
		}else {
		out.print("n");
		out.flush();
		resp.sendRedirect("js/deleteInfoById.js");
		}
	}
}
