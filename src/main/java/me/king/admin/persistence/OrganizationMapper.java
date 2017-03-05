package me.king.admin.persistence;

import java.util.List;

import me.king.admin.domain.Organization;

public interface OrganizationMapper {
    /**
     * 此方法是由MyBatis Generator自动生成不要修改。
     * 这个方法对应于数据库表。 organization
     *
     * @mbggenerated Mon Feb 13 15:57:53 CST 2017
     */
    int deleteByPrimaryKey(Long id);

    /**
     * 此方法是由MyBatis Generator自动生成不要修改。
     * 这个方法对应于数据库表。 organization
     *
     * @mbggenerated Mon Feb 13 15:57:53 CST 2017
     */
    int insert(Organization record);

    /**
     * 此方法是由MyBatis Generator自动生成不要修改。
     * 这个方法对应于数据库表。 organization
     *
     * @mbggenerated Mon Feb 13 15:57:53 CST 2017
     */
    int insertSelective(Organization record);

    /**
     * 此方法是由MyBatis Generator自动生成不要修改。
     * 这个方法对应于数据库表。 organization
     *
     * @mbggenerated Mon Feb 13 15:57:53 CST 2017
     */
    Organization selectByPrimaryKey(Long id);

    /**
     * 此方法是由MyBatis Generator自动生成不要修改。
     * 这个方法对应于数据库表。 organization
     *
     * @mbggenerated Mon Feb 13 15:57:53 CST 2017
     */
    int updateByPrimaryKeySelective(Organization record);

    /**
     * 此方法是由MyBatis Generator自动生成不要修改。
     * 这个方法对应于数据库表。 organization
     *
     * @mbggenerated Mon Feb 13 15:57:53 CST 2017
     */
    int updateByPrimaryKey(Organization record);
    
    List<Organization> selectAll();
    
    int updatePidToNullByPid(Long pid);
}