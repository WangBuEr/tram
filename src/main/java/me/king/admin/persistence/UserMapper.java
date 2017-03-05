package me.king.admin.persistence;

import java.util.List;

import me.king.admin.domain.User;

public interface UserMapper {
    /**
     * 此方法是由MyBatis Generator自动生成不要修改。
     * 这个方法对应于数据库表。 user
     *
     * @mbggenerated Mon Feb 13 15:57:53 CST 2017
     */
    int deleteByPrimaryKey(Long id);

    /**
     * 此方法是由MyBatis Generator自动生成不要修改。
     * 这个方法对应于数据库表。 user
     *
     * @mbggenerated Mon Feb 13 15:57:53 CST 2017
     */
    int insert(User record);

    /**
     * 此方法是由MyBatis Generator自动生成不要修改。
     * 这个方法对应于数据库表。 user
     *
     * @mbggenerated Mon Feb 13 15:57:53 CST 2017
     */
    int insertSelective(User record);

    /**
     * 此方法是由MyBatis Generator自动生成不要修改。
     * 这个方法对应于数据库表。 user
     *
     * @mbggenerated Mon Feb 13 15:57:53 CST 2017
     */
    User selectByPrimaryKey(Long id);

    /**
     * 此方法是由MyBatis Generator自动生成不要修改。
     * 这个方法对应于数据库表。 user
     *
     * @mbggenerated Mon Feb 13 15:57:53 CST 2017
     */
    int updateByPrimaryKeySelective(User record);

    /**
     * 此方法是由MyBatis Generator自动生成不要修改。
     * 这个方法对应于数据库表。 user
     *
     * @mbggenerated Mon Feb 13 15:57:53 CST 2017
     */
    int updateByPrimaryKey(User record);
    
//    biz begin
    int deleteByOrgId(Long orgId);
    List<User> selectSelective(User user);
    int selectSelectiveCount(User user);
    User selectByLoginName(String loginName);
//    biz end
}