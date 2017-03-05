package me.king.admin.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import me.king.admin.domain.Organization;
import me.king.admin.persistence.OrganizationMapper;
import me.king.admin.persistence.UserMapper;
import me.king.admin.service.OrganizationService;
@Service
@Transactional
public class OrganizationServiceImpl implements OrganizationService {
	@Resource
	private OrganizationMapper organizationDao;
	@Resource
	private UserMapper userDao;
	@Override
	public List<Organization> queryAll() {
		List<Organization> orgList = organizationDao.selectAll();
		if(!orgList.isEmpty()){
			//找出所有的根组织
			List<Organization> rootOrgList = getRootOrganization(orgList);
			//把所有跟组织移除
			orgList.removeAll(rootOrgList);
			//构建组织树
			for(Organization org : rootOrgList){
				buildTree(org, orgList);
			}
			return rootOrgList;
		}
		return Collections.emptyList();
	}
	
	@Override
	public void addOrUpdate(Organization org) {
		if(org.getId() != null){
			organizationDao.updateByPrimaryKeySelective(org);
		}else{
			org.setCreateTime(new Date());
			organizationDao.insert(org);
		}
	}
	@Override
	public Organization query(Long orgId) {
		Organization org = organizationDao.selectByPrimaryKey(orgId);
		if(org != null && org.getPid() != null){
			org.setParentOrg(organizationDao.selectByPrimaryKey(org.getPid()));
		}
		return org;
	}
	@Override
	public void delete(Long orgId) {
		if(organizationDao.deleteByPrimaryKey(orgId) > 0){
			organizationDao.updatePidToNullByPid(orgId);
			userDao.deleteByOrgId(orgId);
		}
	}
	private void buildTree(Organization parentOrg,List<Organization> srcTreeList){
		List<Organization> childrenList = getChildrenOrganization(parentOrg, srcTreeList);
		if(!childrenList.isEmpty()){
			for(Organization childrenOrg : childrenList) {
				List<Organization> subOrgList = parentOrg.getSubOrgList();
				if(subOrgList == null){
					subOrgList = new ArrayList<>();
					parentOrg.setSubOrgList(subOrgList);
				}
				subOrgList.add(childrenOrg);
				buildTree(childrenOrg, srcTreeList);
			}
		}
	}
	private List<Organization> getRootOrganization(List<Organization> orgList) {
		List<Organization> rootOrgList = new ArrayList<>();
		for(Organization org : orgList){
			if(org.getPid() == null){
				rootOrgList.add(org);
			}
		}
		return rootOrgList;
	}
	
	private List<Organization> getChildrenOrganization(Organization parentOrg,List<Organization> orgList) {
		List<Organization> childrenList = new ArrayList<>();
		for(Organization org : orgList){
			if(org.getPid().equals(parentOrg.getId())){
				childrenList.add(org);
			}
		}
		return childrenList;
	}

}
