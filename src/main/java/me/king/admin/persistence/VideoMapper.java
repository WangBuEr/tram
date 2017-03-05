package me.king.admin.persistence;

import java.util.List;

import me.king.admin.domain.Video;

public interface VideoMapper {
    /**
     * 此方法是由MyBatis Generator自动生成不要修改。
     * 这个方法对应于数据库表。 video
     *
     * @mbggenerated Tue Jan 17 13:54:21 CST 2017
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 此方法是由MyBatis Generator自动生成不要修改。
     * 这个方法对应于数据库表。 video
     *
     * @mbggenerated Tue Jan 17 13:54:21 CST 2017
     */
    int insert(Video record);

    /**
     * 此方法是由MyBatis Generator自动生成不要修改。
     * 这个方法对应于数据库表。 video
     *
     * @mbggenerated Tue Jan 17 13:54:21 CST 2017
     */
    int insertSelective(Video record);

    /**
     * 此方法是由MyBatis Generator自动生成不要修改。
     * 这个方法对应于数据库表。 video
     *
     * @mbggenerated Tue Jan 17 13:54:21 CST 2017
     */
    Video selectByPrimaryKey(Integer id);

    /**
     * 此方法是由MyBatis Generator自动生成不要修改。
     * 这个方法对应于数据库表。 video
     *
     * @mbggenerated Tue Jan 17 13:54:21 CST 2017
     */
    int updateByPrimaryKeySelective(Video record);

    /**
     * 此方法是由MyBatis Generator自动生成不要修改。
     * 这个方法对应于数据库表。 video
     *
     * @mbggenerated Tue Jan 17 13:54:21 CST 2017
     */
    int updateByPrimaryKey(Video record);
    
    List<Video> selectByCustomerId(Integer customerId);
    
    void deleteByCustomerId(Integer customerId);
}