package com.dao.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.dao.BaseDao;
import com.dao.SInvestigateDao;
import com.entity.S_Investigate;

public class SInvestigateDaoImpl extends BaseDao 
						implements SInvestigateDao {
	@Override //添加
	public int addSInvestigate(S_Investigate obj) {
		//1 SQL语句
		String sql="INSERT INTO `m_af_rpt` (`rpt_name`,`rpt_type`, `rpt_usage`, `rpt_ym`,`make_time`,`status_code`) VALUES (?,?,?,?,?,?)";
		//2 赋值
		Object[] param={obj.getRpt_name(),obj.getRpt_type(),obj.getRpt_usage(),obj.getRpt_ym(),obj.getMake_time(),obj.getStatus_code()};
		//3 执行sql
		int count=this.exceuteUpdate(sql, param);
		//4 返回结果
		return count;
	}

	@Override
	public List<S_Investigate> findSInv(String rpt_name) {
		//声明提取数据对象
		ResultSet rs=null;
		//创建集合对象
		List<S_Investigate> list=new ArrayList<S_Investigate>();
		String sql="select * from m_af_rpt where 1=1";
		if(rpt_name!=null && !"".equals(rpt_name)){
			sql=sql+" and rpt_name like CONCAT('%',?,'%')";
			Object[] param={rpt_name};
			rs=this.executeQuery(sql, param);
		}else{
			rs=this.executeQuery(sql, null);
		}
		try{
			if(rs!=null){
				while(rs.next()){
					S_Investigate s=new S_Investigate();
					s.setRpt_no(rs.getInt("setRpt_no"));
					s.setRpt_name(rs.getString("setRpt_name"));
					s.setRpt_type(rs.getString("setRpt_type"));
					s.setRpt_usage(rs.getString("setRpt_usage"));
					s.setRpt_ym(rs.getString("setRpt_ym"));
					s.setMake_time(rs.getString("setMake_time"));
					s.setStatus_code(rs.getString("setStatus_code"));
					list.add(s);
				}
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
		finally{
			//关闭
			this.closeAll(conn, null, rs);
		}
		return list;
	}

	@Override
	public int delSInvestigateId(int id) {
		//1 SQL语句
		String sql="delete from m_af_rpt where rpt_no=?";
		//2 赋值
		Object[] param={id};
		//3 执行sql
		int count=this.exceuteUpdate(sql, param);
		//4 返回结果
		return count;
	}

	@Override
	public S_Investigate findSInvById(int id) {
		ResultSet rsa=null;
		S_Investigate s=new S_Investigate();
		String sql="select * from m_af_rpt where chk_id=?";
		Object[] param={id};
		rsa=this.executeQuery(sql, param);
		try{
			if(rsa!=null){
				while(rsa.next()){
					s.setRpt_no(rs.getInt("setRpt_no"));
					s.setRpt_name(rs.getString("setRpt_name"));
					s.setRpt_type(rs.getString("setRpt_type"));
					s.setRpt_usage(rs.getString("setRpt_usage"));
					s.setRpt_ym(rs.getString("setRpt_ym"));
					s.setMake_time(rs.getString("setMake_time"));
					s.setStatus_code(rs.getString("setStatus_code"));
				}
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			this.closeAll(conn, null, rsa);
		}
		return s;
	}

	@Override
	public int updSInvestigate(S_Investigate obj) {
		//1 SQL语句
				String sql="update `promaf` set `rpt_name`=?,`chk_name`=?, `rpt_type`=?, `rpt_usage`=?, `rpt_ym`=?, `make_time`=?, `status_code`=? where rpt_no=?";
				//2 赋值
				Object[] param={obj.getRpt_name(),obj.getRpt_type(),obj.getRpt_usage(),obj.getRpt_ym(),obj.getMake_time(),obj.getStatus_code()};
				//3 执行sql
				int count=this.exceuteUpdate(sql, param);
				//4 返回结果
				return count;
	}

}
