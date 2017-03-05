package me.king.admin.service;

import java.util.List;

import me.king.admin.domain.Resource;

/**
 * 资源服务
 * @author BuEr
 *
 */
public interface ResourceService {
	/**
	 * 查询资源
	 * @return
	 */
	List<Resource> queryAll();
	/**
	 * 增加或更新资源
	 * @param org
	 */
	void addOrUpdate(Resource res);
	/**
	 * 查询资源信息
	 * @param resId 资源id
	 * @return 资源信息
	 */
	Resource query(Long resId);
	/**
	 * 删除资源
	 * @param resId 资源id
	 */ 
	void delete(Long resId);
}
