package me.king.admin.persistence;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import me.king.admin.domain.Image;

public interface ImageMapper {
    /**
     * 此方法是由MyBatis Generator自动生成不要修改。
     * 这个方法对应于数据库表。 image
     *
     * @mbggenerated Mon Jan 16 17:09:38 CST 2017
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 此方法是由MyBatis Generator自动生成不要修改。
     * 这个方法对应于数据库表。 image
     *
     * @mbggenerated Mon Jan 16 17:09:38 CST 2017
     */
    int insert(Image record);

    /**
     * 此方法是由MyBatis Generator自动生成不要修改。
     * 这个方法对应于数据库表。 image
     *
     * @mbggenerated Mon Jan 16 17:09:38 CST 2017
     */
    int insertSelective(Image record);

    /**
     * 此方法是由MyBatis Generator自动生成不要修改。
     * 这个方法对应于数据库表。 image
     *
     * @mbggenerated Mon Jan 16 17:09:38 CST 2017
     */
    Image selectByPrimaryKey(Integer id);

    /**
     * 此方法是由MyBatis Generator自动生成不要修改。
     * 这个方法对应于数据库表。 image
     *
     * @mbggenerated Mon Jan 16 17:09:38 CST 2017
     */
    int updateByPrimaryKeySelective(Image record);

    /**
     * 此方法是由MyBatis Generator自动生成不要修改。
     * 这个方法对应于数据库表。 image
     *
     * @mbggenerated Mon Jan 16 17:09:38 CST 2017
     */
    int updateByPrimaryKey(Image record);
    
    List<Image> selectByCustomerId(Integer customerId);
    
    void deleteByCustomerId(Integer customerId);
    void deleteByCustomerIdIdAndTypes(@Param("customerId")Integer customerId,@Param("types")List<Integer> types);
    
    List<Image> selectByCustomerIdAndTypes(@Param("customerId")Integer customerId,@Param("types")List<Integer> types);
}