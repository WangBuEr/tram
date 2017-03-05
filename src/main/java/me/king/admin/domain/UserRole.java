package me.king.admin.domain;

public class UserRole {
    /**
     * 主键id
     * 此字段是由MyBatis Generator自动生成，不要修改。
     *
     * @mbggenerated Mon Feb 13 15:57:53 CST 2017
     */
    private Long id;

    /**
     * 用户id
     * 此字段是由MyBatis Generator自动生成，不要修改。
     *
     * @mbggenerated Mon Feb 13 15:57:53 CST 2017
     */
    private Long userId;

    /**
     * 角色id
     * 此字段是由MyBatis Generator自动生成，不要修改。
     *
     * @mbggenerated Mon Feb 13 15:57:53 CST 2017
     */
    private Long roleId;
    
    public UserRole() {
		super();
	}

	public UserRole(Long userId, Long roleId) {
		super();
		this.userId = userId;
		this.roleId = roleId;
	}

	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }
}