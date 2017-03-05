package me.king.admin.domain;

import java.util.Date;
import java.util.List;

public class User extends BaseQuery {
    /**
     * 主键id
     * 此字段是由MyBatis Generator自动生成，不要修改。
     *
     * @mbggenerated Mon Feb 13 15:57:53 CST 2017
     */
    private Long id;

    /**
     * 登陆名
     * 此字段是由MyBatis Generator自动生成，不要修改。
     *
     * @mbggenerated Mon Feb 13 15:57:53 CST 2017
     */
    private String loginName;

    /**
     * 头像
     * 此字段是由MyBatis Generator自动生成，不要修改。
     *
     * @mbggenerated Mon Feb 13 15:57:53 CST 2017
     */
    private String headImage;

    /**
     * 用户名
     * 此字段是由MyBatis Generator自动生成，不要修改。
     *
     * @mbggenerated Mon Feb 13 15:57:53 CST 2017
     */
    private String name;

    /**
     * 密码
     * 此字段是由MyBatis Generator自动生成，不要修改。
     *
     * @mbggenerated Mon Feb 13 15:57:53 CST 2017
     */
    private String password;

    /**
     * 性别
     * 此字段是由MyBatis Generator自动生成，不要修改。
     *
     * @mbggenerated Mon Feb 13 15:57:53 CST 2017
     */
    private Byte sex;

    /**
     * 年龄
     * 此字段是由MyBatis Generator自动生成，不要修改。
     *
     * @mbggenerated Mon Feb 13 15:57:53 CST 2017
     */
    private Byte age;

    /**
     * 手机号
     * 此字段是由MyBatis Generator自动生成，不要修改。
     *
     * @mbggenerated Mon Feb 13 15:57:53 CST 2017
     */
    private String phone;

    /**
     * 用户类别
     * 此字段是由MyBatis Generator自动生成，不要修改。
     *
     * @mbggenerated Mon Feb 13 15:57:53 CST 2017
     */
    private Byte userType;

    /**
     * 用户状态
     * 此字段是由MyBatis Generator自动生成，不要修改。
     *
     * @mbggenerated Mon Feb 13 15:57:53 CST 2017
     */
    private Byte status;

    /**
     * 所属机构
     * 此字段是由MyBatis Generator自动生成，不要修改。
     *
     * @mbggenerated Mon Feb 13 15:57:53 CST 2017
     */
    private Integer organizationId;

    /**
     * 创建时间
     * 此字段是由MyBatis Generator自动生成，不要修改。
     *
     * @mbggenerated Mon Feb 13 15:57:53 CST 2017
     */
    private Date createTime;
    private Organization organization;
    private List<Role> roleList;
    private String fullUrlHeadImage;
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getHeadImage() {
        return headImage;
    }

    public void setHeadImage(String headImage) {
        this.headImage = headImage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Byte getSex() {
        return sex;
    }

    public void setSex(Byte sex) {
        this.sex = sex;
    }

    public Byte getAge() {
        return age;
    }

    public void setAge(Byte age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Byte getUserType() {
        return userType;
    }

    public void setUserType(Byte userType) {
        this.userType = userType;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Integer getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(Integer organizationId) {
        this.organizationId = organizationId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public List<Role> getRoleList() {
		return roleList;
	}

    public void setRoleList(List<Role> roleList) {
		this.roleList = roleList;
	}

	public Organization getOrganization() {
		return organization;
	}

	public void setOrganization(Organization organization) {
		this.organization = organization;
	}

	public String getFullUrlHeadImage() {
		return fullUrlHeadImage;
	}

	public void setFullUrlHeadImage(String fullUrlHeadImage) {
		this.fullUrlHeadImage = fullUrlHeadImage;
	}
    
}