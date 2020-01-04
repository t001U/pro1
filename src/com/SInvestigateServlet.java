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
		
		//1���  2��ѯ  3ɾ��  4��ѯһ������ 5�޸�
		int opr = Integer.parseInt(request.getParameter("opr"));
		//����ҵ������
		SInvestigateService objService=new SInvestigateServiceImpl();
		
		if(opr==1){
			
			//��ȡҳ�������
			String rpt_name=request.getParameter("rpt_name");
			String rpt_type=request.getParameter("rpt_type");
			String rpt_usage=request.getParameter("rpt_usage");
			String rpt_ym=request.getParameter("rpt_ym");
			String make_time=request.getParameter("make_time");
			String status_code=request.getParameter("status_code");
			//��װ����
			S_Investigate objInv=new S_Investigate();
			objInv.setRpt_name(rpt_name);
			objInv.setRpt_type(rpt_type);
			objInv.setRpt_usage(rpt_usage);
			objInv.setRpt_ym(rpt_ym);
			objInv.setMake_time(make_time);
			objInv.setStatus_code(status_code);
			
			//����ҵ��㱣�淽��
			int count=objService.addSInvestigateService(objInv);
			out.print(count);
		}else if(opr==2){
			//��ȡҳ�洫����������
			String chk_option=request.getParameter("bbb");
			//���ò�ѯ����
			List<S_Investigate> list=objService.findSInvService(chk_option);
			//�����ݷ��͵�ҳ��
			request.setAttribute("list", list);
			request.getRequestDispatcher("find.jsp")
						.forward(request, response);
		}else if(opr==3){
			//��ȡҳ�洫����������
			int id=Integer.parseInt(request.getParameter("id"));
			//����ҵ���ɾ������
			int count=objService.delSInvesService(id);
			System.out.print(count);
			//��������͵�ҳ��
			out.print(count);
		}else if(opr==4){//�޸�ʱ����ID��ѯ������
			//��ȡҳ�洫����������
			int id=Integer.parseInt(request.getParameter("id"));
			//����ҵ����ѯһ�����ݵķ���
			S_Investigate s=objService.findSInvByIdService(id);
			Object obj=JSON.toJSON(s);
			System.out.print("a: "+obj.toString());
			out.print(obj);
		}else if(opr==5){//����޸�ҳ��ı��水Ť��������	 
			 //��ȡҳ�������
			String setRpt_no=request.getParameter("setRpt_no");
			String rpt_name=request.getParameter("rpt_name");
			String rpt_type=request.getParameter("rpt_type");
			String rpt_usage=request.getParameter("rpt_usage");
			String rpt_ym=request.getParameter("rpt_ym");
			String make_time=request.getParameter("make_time");
			String status_code=request.getParameter("status_code");
			//��װ����
			S_Investigate objInv=new S_Investigate();
			objInv.setRpt_no(Integer.parseInt(setRpt_no));
			objInv.setRpt_name(rpt_name);
			objInv.setRpt_type(rpt_type);
			objInv.setRpt_usage(rpt_usage);
			objInv.setRpt_ym(rpt_ym);
			objInv.setMake_time(make_time);
			objInv.setStatus_code(status_code);
			
			//����ҵ���������ݷ���
			int count=objService.updSInvService(objInv);
			out.print(count);
		}
		out.flush();
			
	}

}
