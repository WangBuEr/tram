package me.king.admin.persistence;

import java.util.List;

import me.king.admin.domain.RoleResource;

public interface RoleResourceMapper {
    /**
     * 此方法是由MyBatis Generator自动生成不要修改。
     * 这个方法对应于数据库表。 role_resource
     *
     * @mbggenerated Mon Feb 13 15:57:53 CST 2017
     */
    int deleteByPrimaryKey(Long id);

    /**
     * 此方法是由MyBatis Generator自动生成不要修改。
     * 这个方法对应于数据库表。 role_resource
     *
     * @mbggenerated Mon Feb 13 15:57:53 CST 2017
     */
    int insert(RoleResource record);

    /**
     * 此方法是由MyBatis Generator自动生成不要修改。
     * 这个方法对应于数据库表。 role_resource
     *
     * @mbggenerated Mon Feb 13 15:57:53 CST 2017
     */
    int insertSelective(RoleResource record);

    /**
     * 此方法是由MyBatis Generator自动生成不要修改。
     * 这个方法对应于数据库表。 role_resource
     *
     * @mbggenerated Mon Feb 13 15:57:53 CST 2017
     */
    RoleResource selectByPrimaryKey(Long id);

    /**
     * 此方法是由MyBatis Generator自动生成不要修改。
     * 这个方法对应于数据库表。 role_resource
     *
     * @mbggenerated Mon Feb 13 15:57:53 CST 2017
     */
    int updateByPrimaryKeySelective(RoleResource record);

    /**
     * 此方法是由MyBatis Generator自动生成不要修改。
     * 这个方法对应于数据库表。 role_resource
     *
     * @mbggenerated Mon Feb 13 15:57:53 CST 2017
     */
    int updateByPrimaryKey(RoleResource record);
    
//    biz begin
    int deleteByRoleId(Long roleId);
    int deleteByResourceId(Long resId);
    List<RoleResource> selectByRoleId(Long roleId);
//    biz end
}