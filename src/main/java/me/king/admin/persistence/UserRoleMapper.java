package me.king.admin.persistence;

import me.king.admin.domain.UserRole;

public interface UserRoleMapper {
    /**
     * 此方法是由MyBatis Generator自动生成不要修改。
     * 这个方法对应于数据库表。 user_role
     *
     * @mbggenerated Mon Feb 13 15:57:53 CST 2017
     */
    int deleteByPrimaryKey(Long id);

    /**
     * 此方法是由MyBatis Generator自动生成不要修改。
     * 这个方法对应于数据库表。 user_role
     *
     * @mbggenerated Mon Feb 13 15:57:53 CST 2017
     */
    int insert(UserRole record);

    /**
     * 此方法是由MyBatis Generator自动生成不要修改。
     * 这个方法对应于数据库表。 user_role
     *
     * @mbggenerated Mon Feb 13 15:57:53 CST 2017
     */
    int insertSelective(UserRole record);

    /**
     * 此方法是由MyBatis Generator自动生成不要修改。
     * 这个方法对应于数据库表。 user_role
     *
     * @mbggenerated Mon Feb 13 15:57:54 CST 2017
     */
    UserRole selectByPrimaryKey(Long id);

    /**
     * 此方法是由MyBatis Generator自动生成不要修改。
     * 这个方法对应于数据库表。 user_role
     *
     * @mbggenerated Mon Feb 13 15:57:54 CST 2017
     */
    int updateByPrimaryKeySelective(UserRole record);

    /**
     * 此方法是由MyBatis Generator自动生成不要修改。
     * 这个方法对应于数据库表。 user_role
     *
     * @mbggenerated Mon Feb 13 15:57:54 CST 2017
     */
    int updateByPrimaryKey(UserRole record);
    
//    biz begin
    int deleteByUserId(Long userId);
//    biz end
}