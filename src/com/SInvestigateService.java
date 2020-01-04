package com.service;

import java.util.List;

import com.entity.S_Investigate;

public interface SInvestigateService {
	/**
	 * 添加勘查信息
	 * @param obj勘查信息数据实体
	 * @return 1成功 0失败
	 */
	public int addSInvestigateService(S_Investigate obj);
	
	/**
	 * 根据勘查意见模糊查询信息
	 * @param chk_option
	 * @return 返回信息集合
	 */
	public List<S_Investigate>  findSInvService(String chk_option);
	
	/**
	 * 根据ID删除数据信息
	 * @param id
	 * @return 1成功 0失败
	 */
	public int delSInvesService(int id);
	
	/**
	 * 根据ID查询数据(点击修改按扭时首先查询出数据)
	 * @param id
	 * @return
	 */
	public S_Investigate  findSInvByIdService(int id);
	
	/**
	 * 修改信息(点击修改页面的保存按扭将信息更新到数据库)
	 * @param obj
	 * @return
	 */
	public int updSInvService(S_Investigate obj);
}
