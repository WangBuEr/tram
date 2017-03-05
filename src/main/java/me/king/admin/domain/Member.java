package me.king.admin.domain;

import java.util.Date;

public class Member {
    /**
     * id
     * 此字段是由MyBatis Generator自动生成，不要修改。
     *
     * @mbggenerated Wed Jan 04 16:26:51 CST 2017
     */
    private Integer id;

    /**
     * 
     * 此字段是由MyBatis Generator自动生成，不要修改。
     *
     * @mbggenerated Wed Jan 04 16:26:51 CST 2017
     */
    private String openId;

    /**
     * 
     * 此字段是由MyBatis Generator自动生成，不要修改。
     *
     * @mbggenerated Wed Jan 04 16:26:51 CST 2017
     */
    private String userName;

    /**
     * 邮箱
     * 此字段是由MyBatis Generator自动生成，不要修改。
     *
     * @mbggenerated Wed Jan 04 16:26:51 CST 2017
     */
    private String email;

    /**
     * 
     * 此字段是由MyBatis Generator自动生成，不要修改。
     *
     * @mbggenerated Wed Jan 04 16:26:51 CST 2017
     */
    private String password;

    /**
     * 头像
     * 此字段是由MyBatis Generator自动生成，不要修改。
     *
     * @mbggenerated Wed Jan 04 16:26:51 CST 2017
     */
    private String headImgUrl;

    /**
     * 昵称
     * 此字段是由MyBatis Generator自动生成，不要修改。
     *
     * @mbggenerated Wed Jan 04 16:26:51 CST 2017
     */
    private String nickname;

    /**
     * 姓名
     * 此字段是由MyBatis Generator自动生成，不要修改。
     *
     * @mbggenerated Wed Jan 04 16:26:51 CST 2017
     */
    private String personalName;

    /**
     * 身份证
     * 此字段是由MyBatis Generator自动生成，不要修改。
     *
     * @mbggenerated Wed Jan 04 16:26:51 CST 2017
     */
    private String identityCard;

    /**
     * 
     * 此字段是由MyBatis Generator自动生成，不要修改。
     *
     * @mbggenerated Wed Jan 04 16:26:51 CST 2017
     */
    private Integer phoneNumber;

    /**
     * 
     * 此字段是由MyBatis Generator自动生成，不要修改。
     *
     * @mbggenerated Wed Jan 04 16:26:51 CST 2017
     */
    private Integer roomTicket;

    /**
     * 金币
     * 此字段是由MyBatis Generator自动生成，不要修改。
     *
     * @mbggenerated Wed Jan 04 16:26:51 CST 2017
     */
    private Integer gold;

    /**
     * 积分
     * 此字段是由MyBatis Generator自动生成，不要修改。
     *
     * @mbggenerated Wed Jan 04 16:26:51 CST 2017
     */
    private Integer integral;

    /**
     * 开房次数
     * 此字段是由MyBatis Generator自动生成，不要修改。
     *
     * @mbggenerated Wed Jan 04 16:26:51 CST 2017
     */
    private Integer openRoom;

    /**
     * 对局数
     * 此字段是由MyBatis Generator自动生成，不要修改。
     *
     * @mbggenerated Wed Jan 04 16:26:51 CST 2017
     */
    private Integer playGame;

    /**
     * 胜率
     * 此字段是由MyBatis Generator自动生成，不要修改。
     *
     * @mbggenerated Wed Jan 04 16:26:51 CST 2017
     */
    private Integer winningProbability;

    /**
     * 注册时间
     * 此字段是由MyBatis Generator自动生成，不要修改。
     *
     * @mbggenerated Wed Jan 04 16:26:51 CST 2017
     */
    private Date registerTime;

    /**
     * 最后登录ip
     * 此字段是由MyBatis Generator自动生成，不要修改。
     *
     * @mbggenerated Wed Jan 04 16:26:51 CST 2017
     */
    private String lastLoginIp;

    /**
     * 最后登录时间
     * 此字段是由MyBatis Generator自动生成，不要修改。
     *
     * @mbggenerated Wed Jan 04 16:26:51 CST 2017
     */
    private Date lastlogintime;

    /**
     * 状态：1正常，0冻结
     * 此字段是由MyBatis Generator自动生成，不要修改。
     *
     * @mbggenerated Wed Jan 04 16:26:51 CST 2017
     */
    private Integer state;
    private int draw;
    private int start;
    private int length;
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getHeadImgUrl() {
        return headImgUrl;
    }

    public void setHeadImgUrl(String headImgUrl) {
        this.headImgUrl = headImgUrl;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPersonalName() {
        return personalName;
    }

    public void setPersonalName(String personalName) {
        this.personalName = personalName;
    }

    public String getIdentityCard() {
        return identityCard;
    }

    public void setIdentityCard(String identityCard) {
        this.identityCard = identityCard;
    }

    public Integer getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Integer phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Integer getRoomTicket() {
        return roomTicket;
    }

    public void setRoomTicket(Integer roomTicket) {
        this.roomTicket = roomTicket;
    }

    public Integer getGold() {
        return gold;
    }

    public void setGold(Integer gold) {
        this.gold = gold;
    }

    public Integer getIntegral() {
        return integral;
    }

    public void setIntegral(Integer integral) {
        this.integral = integral;
    }

    public Integer getOpenRoom() {
        return openRoom;
    }

    public void setOpenRoom(Integer openRoom) {
        this.openRoom = openRoom;
    }

    public Integer getPlayGame() {
        return playGame;
    }

    public void setPlayGame(Integer playGame) {
        this.playGame = playGame;
    }

    public Integer getWinningProbability() {
        return winningProbability;
    }

    public void setWinningProbability(Integer winningProbability) {
        this.winningProbability = winningProbability;
    }

    public Date getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(Date registerTime) {
        this.registerTime = registerTime;
    }

    public String getLastLoginIp() {
        return lastLoginIp;
    }

    public void setLastLoginIp(String lastLoginIp) {
        this.lastLoginIp = lastLoginIp;
    }

    public Date getLastlogintime() {
        return lastlogintime;
    }

    public void setLastlogintime(Date lastlogintime) {
        this.lastlogintime = lastlogintime;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

	public int getDraw() {
		return draw;
	}

	public void setDraw(int draw) {
		this.draw = draw;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}
    
    
}