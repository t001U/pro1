package com.service;

import java.util.List;

import com.entity.S_Investigate;

public interface SInvestigateService {
	/**
	 * ��ӿ�����Ϣ
	 * @param obj������Ϣ����ʵ��
	 * @return 1�ɹ� 0ʧ��
	 */
	public int addSInvestigateService(S_Investigate obj);
	
	/**
	 * ���ݿ������ģ����ѯ��Ϣ
	 * @param chk_option
	 * @return ������Ϣ����
	 */
	public List<S_Investigate>  findSInvService(String chk_option);
	
	/**
	 * ����IDɾ��������Ϣ
	 * @param id
	 * @return 1�ɹ� 0ʧ��
	 */
	public int delSInvesService(int id);
	
	/**
	 * ����ID��ѯ����(����޸İ�Ťʱ���Ȳ�ѯ������)
	 * @param id
	 * @return
	 */
	public S_Investigate  findSInvByIdService(int id);
	
	/**
	 * �޸���Ϣ(����޸�ҳ��ı��水Ť����Ϣ���µ����ݿ�)
	 * @param obj
	 * @return
	 */
	public int updSInvService(S_Investigate obj);
}
