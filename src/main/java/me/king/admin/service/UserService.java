package me.king.admin.service;

import java.util.List;

import me.king.admin.domain.User;
/**
 * 用户服务
 * @author BuEr
 *
 */
public interface UserService {
	/**
	 * 查询用户列表
	 * @param user
	 * @return
	 */
	List<User> queryList(User user);
	/**
	 * 查询用户总数
	 * @param user
	 * @return
	 */
	int queryCount(User user);
	/**
	 * 查询用户详情
	 * @param userId 用户id
	 * @return
	 */
	User detail(Long userId);
	/**
	 * 查询用户详情
	 * @param loginName 登录名
	 * @return
	 */
	User detail(String loginName);
	/**
	 * 删除用户
	 * @param userId
	 */
	void delete(Long userId);
	/**
	 * 新增或更新用户
	 * @param user
	 */
	void addOrUpdate(User user);
	/**
	 * 验证登录名唯一性
	 * @param userId
	 * @param loginName
	 * @return
	 */
	Boolean verifyLoginNameOnly(Long userId,String loginName);
	/**
	 * 更新用户信息
	 * @param user
	 */
	void update(User user);
}
