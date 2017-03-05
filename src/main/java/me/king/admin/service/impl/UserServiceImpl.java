package me.king.admin.service.impl;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import me.king.admin.domain.Role;
import me.king.admin.domain.User;
import me.king.admin.domain.UserRole;
import me.king.admin.persistence.RoleMapper;
import me.king.admin.persistence.UserMapper;
import me.king.admin.persistence.UserRoleMapper;
import me.king.admin.service.UserService;
import me.king.admin.util.ConfigProperties;
@Service
@Transactional
public class UserServiceImpl implements UserService {
	@Resource
	private UserMapper userDao;
	@Resource
	private RoleMapper roleDao;
	@Resource
	private UserRoleMapper userRoleDao;
	@Resource
	private ConfigProperties config;
	@Override
	public List<User> queryList(User user) {
		return userDao.selectSelective(user);
	}

	@Override
	public int queryCount(User user) {
		return userDao.selectSelectiveCount(user);
	}

	@Override
	public User detail(Long userId) {
		User user = userDao.selectByPrimaryKey(userId);
		if(user != null){
			setUserInfo(user);
		}
		return user;
	}
	@Override
	public User detail(String loginName) {
		User user = userDao.selectByLoginName(loginName);
		if(user != null){
			setUserInfo(user);
		}
		return user;
	}

	private void setUserInfo(User user) {
		List<Role> userRoleList = roleDao.selectByUserId(user.getId());
		user.setRoleList(userRoleList);
		if(StringUtils.hasText(user.getHeadImage())){
			StringBuffer fullUrl = new StringBuffer(config.getQiNiuLink());
			fullUrl.append(user.getHeadImage());
			user.setFullUrlHeadImage(fullUrl.toString());
		}
	}
	@Override
	public void delete(Long userId) {
		if(userDao.deleteByPrimaryKey(userId) > 0){
			userRoleDao.deleteByUserId(userId);
		}
	}

	@Override
	public void addOrUpdate(User user) {
		if(user.getId() == null){
			try {
				if(!StringUtils.hasText(user.getPassword())){
					user.setPassword("111111");
				}
				user.setPassword(DigestUtils.md5Hex(user.getPassword().getBytes("UTF-8")));
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			user.setCreateTime(new Date());
			userDao.insert(user);
		}else{
			if(StringUtils.hasText(user.getPassword())){
				try {
					user.setPassword(DigestUtils.md5Hex(user.getPassword().getBytes("UTF-8")));
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
			}
			userDao.updateByPrimaryKeySelective(user);
			userRoleDao.deleteByUserId(user.getId());
		}
		
		if(user.getRoleList() != null && !user.getRoleList().isEmpty()){
			for(Role role : user.getRoleList()){
				UserRole userRole = new UserRole(user.getId(), role.getId());
				userRoleDao.insert(userRole);
			}
		}
	}

	@Override
	public Boolean verifyLoginNameOnly(Long userId, String loginName) {
		if(userId != null){
			User user = userDao.selectByPrimaryKey(userId);
			if(user != null && user.getLoginName().equals(loginName)){
				return true;
			}
		}
		
		return userDao.selectByLoginName(loginName) == null;
	}

	@Override
	public void update(User user) {
		if(StringUtils.hasText(user.getPassword())){
			try {
				user.setPassword(DigestUtils.md5Hex(user.getPassword().getBytes("UTF-8")));
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		userDao.updateByPrimaryKeySelective(user);
	}
	
	
}
