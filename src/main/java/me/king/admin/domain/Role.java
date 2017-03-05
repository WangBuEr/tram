package me.king.admin.domain;

public class Role extends BaseQuery{
    /**
     * 主键id
     * 此字段是由MyBatis Generator自动生成，不要修改。
     *
     * @mbggenerated Mon Feb 13 15:57:53 CST 2017
     */
    private Long id;

    /**
     * 角色名
     * 此字段是由MyBatis Generator自动生成，不要修改。
     *
     * @mbggenerated Mon Feb 13 15:57:53 CST 2017
     */
    private String name;

    /**
     * 排序号
     * 此字段是由MyBatis Generator自动生成，不要修改。
     *
     * @mbggenerated Mon Feb 13 15:57:53 CST 2017
     */
    private Byte seq;

    /**
     * 简介
     * 此字段是由MyBatis Generator自动生成，不要修改。
     *
     * @mbggenerated Mon Feb 13 15:57:53 CST 2017
     */
    private String description;

    /**
     * 状态
     * 此字段是由MyBatis Generator自动生成，不要修改。
     *
     * @mbggenerated Mon Feb 13 15:57:53 CST 2017
     */
    private Byte status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Byte getSeq() {
        return seq;
    }

    public void setSeq(Byte seq) {
        this.seq = seq;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }
}