package me.king.admin.persistence;

import java.util.List;

import me.king.admin.domain.Resource;

public interface ResourceMapper {
    /**
     * 此方法是由MyBatis Generator自动生成不要修改。
     * 这个方法对应于数据库表。 resource
     *
     * @mbggenerated Mon Feb 13 15:57:53 CST 2017
     */
    int deleteByPrimaryKey(Long id);

    /**
     * 此方法是由MyBatis Generator自动生成不要修改。
     * 这个方法对应于数据库表。 resource
     *
     * @mbggenerated Mon Feb 13 15:57:53 CST 2017
     */
    int insert(Resource record);

    /**
     * 此方法是由MyBatis Generator自动生成不要修改。
     * 这个方法对应于数据库表。 resource
     *
     * @mbggenerated Mon Feb 13 15:57:53 CST 2017
     */
    int insertSelective(Resource record);

    /**
     * 此方法是由MyBatis Generator自动生成不要修改。
     * 这个方法对应于数据库表。 resource
     *
     * @mbggenerated Mon Feb 13 15:57:53 CST 2017
     */
    Resource selectByPrimaryKey(Long id);

    /**
     * 此方法是由MyBatis Generator自动生成不要修改。
     * 这个方法对应于数据库表。 resource
     *
     * @mbggenerated Mon Feb 13 15:57:53 CST 2017
     */
    int updateByPrimaryKeySelective(Resource record);

    /**
     * 此方法是由MyBatis Generator自动生成不要修改。
     * 这个方法对应于数据库表。 resource
     *
     * @mbggenerated Mon Feb 13 15:57:53 CST 2017
     */
    int updateByPrimaryKey(Resource record);
    
//    biz begin
    List<Resource> selectAll();
    int updatePidToNullByPid(Long pid);
//    Liz end
}