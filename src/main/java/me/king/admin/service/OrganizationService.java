package me.king.admin.service;

import java.util.List;

import me.king.admin.domain.Organization;
/**
 * 组织服务
 * @author BuEr
 *
 */
public interface OrganizationService {
	/**
	 * 查询所有组织
	 * @return
	 */
	List<Organization> queryAll();
	/**
	 * 增加或更新组织信息
	 * @param org
	 */
	void addOrUpdate(Organization org);
	/**
	 * 查询组织信息
	 * @param orgId 组织id
	 * @return 组织信息
	 */
	Organization query(Long orgId);
	/**
	 * 删除部门id
	 * @param orgId
	 */
	void delete(Long orgId);
}
