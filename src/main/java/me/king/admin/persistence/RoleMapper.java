package me.king.admin.persistence;

import java.util.List;

import me.king.admin.domain.Role;

public interface RoleMapper {
    /**
     * 此方法是由MyBatis Generator自动生成不要修改。
     * 这个方法对应于数据库表。 role
     *
     * @mbggenerated Mon Feb 13 15:57:53 CST 2017
     */
    int deleteByPrimaryKey(Long id);

    /**
     * 此方法是由MyBatis Generator自动生成不要修改。
     * 这个方法对应于数据库表。 role
     *
     * @mbggenerated Mon Feb 13 15:57:53 CST 2017
     */
    int insert(Role record);

    /**
     * 此方法是由MyBatis Generator自动生成不要修改。
     * 这个方法对应于数据库表。 role
     *
     * @mbggenerated Mon Feb 13 15:57:53 CST 2017
     */
    int insertSelective(Role record);

    /**
     * 此方法是由MyBatis Generator自动生成不要修改。
     * 这个方法对应于数据库表。 role
     *
     * @mbggenerated Mon Feb 13 15:57:53 CST 2017
     */
    Role selectByPrimaryKey(Long id);

    /**
     * 此方法是由MyBatis Generator自动生成不要修改。
     * 这个方法对应于数据库表。 role
     *
     * @mbggenerated Mon Feb 13 15:57:53 CST 2017
     */
    int updateByPrimaryKeySelective(Role record);

    /**
     * 此方法是由MyBatis Generator自动生成不要修改。
     * 这个方法对应于数据库表。 role
     *
     * @mbggenerated Mon Feb 13 15:57:53 CST 2017
     */
    int updateByPrimaryKey(Role record);
    
    List<Role> selectSelective(Role role);
    
    int selectSelectiveCount(Role role);
    
    List<Role> selectByUserId(Long userId);
}