package me.king.admin.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import me.king.admin.domain.Resource;
import me.king.admin.persistence.ResourceMapper;
import me.king.admin.persistence.RoleResourceMapper;
import me.king.admin.persistence.UserMapper;
import me.king.admin.service.ResourceService;
@Service
@Transactional
public class ResourceServiceImpl implements ResourceService{
	@javax.annotation.Resource
	private ResourceMapper resourceDao;
	@javax.annotation.Resource
	private RoleResourceMapper roleResourceDao;
	@javax.annotation.Resource
	private UserMapper userDao;
	@Override
	public List<Resource> queryAll() {
		List<Resource> resList = resourceDao.selectAll();
		if(!resList.isEmpty()){
			//找出所有的根资源
			List<Resource> rootResList = getRootResource(resList);
			//把所有根资源移除
			resList.removeAll(rootResList);
			//构建资源树
			for(Resource res : rootResList){
				buildTree(res, resList);
			}
			return rootResList;
		}
		return Collections.emptyList();
	}

	@Override
	public void addOrUpdate(Resource res) {
		if(res.getId() == null){
			res.setCreateTime(new Date());
			resourceDao.insert(res);
		}else{
			resourceDao.updateByPrimaryKeySelective(res);
		}
	}

	@Override
	public Resource query(Long resId) {
		Resource res = resourceDao.selectByPrimaryKey(resId);
		if(res != null && res.getPid() != null){
			res.setParentResource(resourceDao.selectByPrimaryKey(res.getPid()));
		}
		return res;
	}

	@Override
	public void delete(Long resId) {
		if(resourceDao.deleteByPrimaryKey(resId) > 0){
			//删除角色资源的绑定
			roleResourceDao.deleteByResourceId(resId);
			resourceDao.updatePidToNullByPid(resId);
		}
	}
	private List<Resource> getRootResource(List<Resource> resList) {
		List<Resource> rootResList = new ArrayList<>();
		for(Resource res : resList){
			if(res.getPid() == null){
				rootResList.add(res);
			}
		}
		return rootResList;
	}
	private void buildTree(Resource parentRes,List<Resource> srcTreeList){
		List<Resource> childrenList = getChildrenRes(parentRes, srcTreeList);
		if(!childrenList.isEmpty()){
			for(Resource res : childrenList) {
				List<Resource> subOrgList = parentRes.getSubResList();
				if(subOrgList == null){
					subOrgList = new ArrayList<>();
					parentRes.setSubResList(subOrgList);
				}
				subOrgList.add(res);
				buildTree(res, srcTreeList);
			}
		}
	}
	
	
	private List<Resource> getChildrenRes(Resource parentRes,List<Resource> resList) {
		List<Resource> childrenList = new ArrayList<>();
		for(Resource res : resList){
			if(res.getPid().equals(parentRes.getId())){
				childrenList.add(res);
			}
		}
		return childrenList;
	}
}
