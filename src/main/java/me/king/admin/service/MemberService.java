package me.king.admin.service;

import java.util.List;

import me.king.admin.domain.Member;

public interface MemberService {
	List<Member> query(Member queryParam);
	int queryCount(Member queryParam);
}
