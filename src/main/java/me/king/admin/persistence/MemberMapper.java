package me.king.admin.persistence;

import java.util.List;

import me.king.admin.domain.Member;

public interface MemberMapper {
    /**
     * 此方法是由MyBatis Generator自动生成不要修改。
     * 这个方法对应于数据库表。 member
     *
     * @mbggenerated Wed Jan 04 16:26:51 CST 2017
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 此方法是由MyBatis Generator自动生成不要修改。
     * 这个方法对应于数据库表。 member
     *
     * @mbggenerated Wed Jan 04 16:26:51 CST 2017
     */
    int insert(Member record);

    /**
     * 此方法是由MyBatis Generator自动生成不要修改。
     * 这个方法对应于数据库表。 member
     *
     * @mbggenerated Wed Jan 04 16:26:51 CST 2017
     */
    int insertSelective(Member record);

    /**
     * 此方法是由MyBatis Generator自动生成不要修改。
     * 这个方法对应于数据库表。 member
     *
     * @mbggenerated Wed Jan 04 16:26:51 CST 2017
     */
    Member selectByPrimaryKey(Integer id);

    /**
     * 此方法是由MyBatis Generator自动生成不要修改。
     * 这个方法对应于数据库表。 member
     *
     * @mbggenerated Wed Jan 04 16:26:51 CST 2017
     */
    int updateByPrimaryKeySelective(Member record);

    /**
     * 此方法是由MyBatis Generator自动生成不要修改。
     * 这个方法对应于数据库表。 member
     *
     * @mbggenerated Wed Jan 04 16:26:51 CST 2017
     */
    int updateByPrimaryKey(Member record);
    
    List<Member> selectSelective(Member queryParam);
    int selectSelectiveCount(Member queryParam);
}