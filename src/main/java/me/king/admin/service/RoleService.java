package me.king.admin.service;

import java.util.List;

import me.king.admin.domain.Role;
import me.king.admin.domain.RoleResource;

/**
 * 角色服务
 * @author BuEr
 *
 */
public interface RoleService {
	/**
	 * 查询角色列表
	 * @param role
	 * @return
	 */
	List<Role> queryList(Role role);
	/**
	 * 查询角色总数
	 * @param role
	 * @return
	 */
	int queryCount(Role role);
	/**
	 * 新增或更新角色信息
	 * @param role
	 */
	void addOrUpdate(Role role);
	/**
	 * 删除角色信息
	 * @param id
	 */
	void delete(Long id);
	/**
	 * 
	 * 授权
	 * @param resList 资源列表
	 * @param roleId 角色id
	 */
	void authorization(Long[] resList,Long roleId);
	/**
	 * 查询角色所拥有的资源
	 * @param roleId
	 * @return 角色所拥有的资源
	 */
	List<RoleResource> queryRoleResource(Long roleId);
	/**
	 * 查询角色信息
	 * @param roleId
	 * @return 角色信息
	 */
	Role query(Long roleId);
}
