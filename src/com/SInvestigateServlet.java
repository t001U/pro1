package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.entity.S_Investigate;
import com.service.SInvestigateService;
import com.service.impl.SInvestigateServiceImpl;

public class SInvestigateServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			this.doPost(request, response);
		
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//http://localhost:8080/investigate/add.jsp
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		//1添加  2查询  3删除  4查询一条数据 5修改
		int opr = Integer.parseInt(request.getParameter("opr"));
		//创建业务层对象
		SInvestigateService objService=new SInvestigateServiceImpl();
		
		if(opr==1){
			
			//获取页面的数据
			String rpt_name=request.getParameter("rpt_name");
			String rpt_type=request.getParameter("rpt_type");
			String rpt_usage=request.getParameter("rpt_usage");
			String rpt_ym=request.getParameter("rpt_ym");
			String make_time=request.getParameter("make_time");
			String status_code=request.getParameter("status_code");
			//封装数据
			S_Investigate objInv=new S_Investigate();
			objInv.setRpt_name(rpt_name);
			objInv.setRpt_type(rpt_type);
			objInv.setRpt_usage(rpt_usage);
			objInv.setRpt_ym(rpt_ym);
			objInv.setMake_time(make_time);
			objInv.setStatus_code(status_code);
			
			//调用业务层保存方法
			int count=objService.addSInvestigateService(objInv);
			out.print(count);
		}else if(opr==2){
			//获取页面传过来的条件
			String chk_option=request.getParameter("bbb");
			//调用查询方法
			List<S_Investigate> list=objService.findSInvService(chk_option);
			//将数据发送到页面
			request.setAttribute("list", list);
			request.getRequestDispatcher("find.jsp")
						.forward(request, response);
		}else if(opr==3){
			//获取页面传过来的条件
			int id=Integer.parseInt(request.getParameter("id"));
			//调用业务层删除方法
			int count=objService.delSInvesService(id);
			System.out.print(count);
			//将结果发送到页面
			out.print(count);
		}else if(opr==4){//修改时根据ID查询出数据
			//获取页面传过来的条件
			int id=Integer.parseInt(request.getParameter("id"));
			//调用业务层查询一条数据的方法
			S_Investigate s=objService.findSInvByIdService(id);
			Object obj=JSON.toJSON(s);
			System.out.print("a: "+obj.toString());
			out.print(obj);
		}else if(opr==5){//点击修改页面的保存按扭更新数据	 
			 //获取页面的数据
			String setRpt_no=request.getParameter("setRpt_no");
			String rpt_name=request.getParameter("rpt_name");
			String rpt_type=request.getParameter("rpt_type");
			String rpt_usage=request.getParameter("rpt_usage");
			String rpt_ym=request.getParameter("rpt_ym");
			String make_time=request.getParameter("make_time");
			String status_code=request.getParameter("status_code");
			//封装数据
			S_Investigate objInv=new S_Investigate();
			objInv.setRpt_no(Integer.parseInt(setRpt_no));
			objInv.setRpt_name(rpt_name);
			objInv.setRpt_type(rpt_type);
			objInv.setRpt_usage(rpt_usage);
			objInv.setRpt_ym(rpt_ym);
			objInv.setMake_time(make_time);
			objInv.setStatus_code(status_code);
			
			//调用业务层更新数据方法
			int count=objService.updSInvService(objInv);
			out.print(count);
		}
		out.flush();
			
	}

}
