package com.mafrpt.Dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mafrpt.Dao.BaseDao;
import com.mafrpt.Dao.mafrptDao;
import com.mafrpt.entity.Mafrpt;

public class mafrptDaoImol extends BaseDao implements mafrptDao {
		
	Connection conn = null;
	PreparedStatement psmt = null;
	ResultSet rs = null;
	/**
	 * 
	 */
	@Override
	public List<Mafrpt> getSeleName(String rpt_name) {
		List<Mafrpt> list = new ArrayList<Mafrpt>();
		try {
			conn = this.getConnection();
			String sql = "SELECT * FROM `m_af_rpt` ";
			if(rpt_name != null &&! "".equals(rpt_name)) {
				sql = sql + " WHERE rpt_name like CONCAT('%',?,'%')";
				psmt = conn.prepareStatement(sql);
				psmt.setString(1, rpt_name);
			}else {
				psmt = conn.prepareStatement(sql);
			}
			System.out.print("chaxun:"+psmt.toString());
			rs = psmt.executeQuery();
			while (rs.next()) {
				Mafrpt m = new Mafrpt();
				m.setRpt_no(rs.getInt("rpt_no"));
				m.setRpt_name(rs.getString("rpt_name"));
				m.setRpt_type(rs.getString("rpt_type"));
				m.setRpt_usage(rs.getString("rpt_usage"));
				m.setRpt_ym(rs.getString("rpt_ym"));
				m.setMake_time(rs.getString("make_time"));
				m.setStatus_code(rs.getString("status_code"));
				list.add(m);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			this.closeAll(conn, psmt, rs);
		}
		return list;
	}	
	
	/**
	 * 新增
	 */
	@Override
	public int addmafrpt(Mafrpt maf) {
		String sql = "INSERT INTO `m_af_rpt`(`rpt_name`,`rpt_type`,`rpt_usage`,`rpt_ym`,`make_time`,`status_code`)VALUES(?,?,?,?,?,?)";
		Object [] params = {maf.getRpt_name(),maf.getRpt_type(),maf.getRpt_usage(),maf.getRpt_ym(),maf.getMake_time(),maf.getStatus_code()};
		int count = this.executeUpdate(sql, params);
		return count;
	}

	@Override
	public int demafrpt(int rpt_id) {
		String sql = "DELETE FROM `m_af_rpt` WHERE `rpt_no` = ?";
		Object [] params = {rpt_id};
		int count = this.executeUpdate(sql, params);
		return count;
	}
	
	/**
	 * 根据ID查询
	 */
	@Override
	public List<Mafrpt> SeById(int id) {
		List<Mafrpt> list = new ArrayList<Mafrpt>();
		try {
			conn = this.getConnection();
			String sql = "SELECT * FROM `m_af_rpt` WHERE `rpt_no` = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, id);
			rs = psmt.executeQuery();
			while (rs.next()) {
				Mafrpt m = new Mafrpt();
				m.setRpt_no(rs.getInt("rpt_no"));
				m.setRpt_name(rs.getString("rpt_name"));
				m.setRpt_type(rs.getString("rpt_type"));
				m.setRpt_usage(rs.getString("rpt_usage"));
				m.setRpt_ym(rs.getString("rpt_ym"));
				m.setMake_time(rs.getString("make_time"));
				m.setStatus_code(rs.getString("status_code"));
				list.add(m);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			this.closeAll(conn, psmt, rs);
		}
		return list;
	}
	
	/**
	 * 修改
	 */
	@Override
	public int upmafrpt(Mafrpt m) {
		String sql = "UPDATE `m_af_rpt` SET `rpt_name`=?,`rpt_type`=?,`rpt_usage`=?,`rpt_ym`=?,`make_time`=?,`status_code`=? WHERE `rpt_no` = ?";
		Object [] params = {m.getRpt_name(),m.getRpt_type(),m.getRpt_usage(),m.getRpt_ym(),m.getMake_time(),m.getStatus_code(),m.getRpt_no()};
		return this.executeUpdate(sql, params);
	}

}
