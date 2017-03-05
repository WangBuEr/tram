package me.king.admin.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import me.king.admin.domain.Role;
import me.king.admin.domain.RoleResource;
import me.king.admin.persistence.RoleMapper;
import me.king.admin.persistence.RoleResourceMapper;
import me.king.admin.service.RoleService;
@Service
@Transactional
public class RoleServiceImpl implements RoleService {
	@Resource
	private RoleMapper roleDao;
	@Resource
	private RoleResourceMapper roleResourceDao;
	
	@Override
	public List<Role> queryList(Role role) {
		return roleDao.selectSelective(role);
	}

	@Override
	public int queryCount(Role role) {
		return roleDao.selectSelectiveCount(role);
	}

	@Override
	public void addOrUpdate(Role role) {
		if(role.getId() != null){
			roleDao.updateByPrimaryKeySelective(role);
		}else{
			roleDao.insert(role);
		}
	}

	@Override
	public void delete(Long id) {
		roleDao.deleteByPrimaryKey(id);
		roleResourceDao.deleteByRoleId(id);
	}

	@Override
	public void authorization(Long[] resList, Long roleId) {
		roleResourceDao.deleteByRoleId(roleId);
		if(resList != null){
			for(Long res : resList){
				RoleResource roleResource = new RoleResource(roleId, res);
				roleResourceDao.insert(roleResource);
			}
		}
	}

	@Override
	public List<RoleResource> queryRoleResource(Long roleId) {
		return roleResourceDao.selectByRoleId(roleId);
	}

	@Override
	public Role query(Long roleId) {
		return roleDao.selectByPrimaryKey(roleId);
	}
}
