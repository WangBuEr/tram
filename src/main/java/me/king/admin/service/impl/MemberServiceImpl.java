package me.king.admin.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import me.king.admin.domain.Member;
import me.king.admin.persistence.MemberMapper;
import me.king.admin.service.MemberService;
@Service
public class MemberServiceImpl implements MemberService {
	@Resource
	private MemberMapper memberMapper;
	@Override
	public List<Member> query(Member queryParam) {
		return memberMapper.selectSelective(queryParam);
	}

	@Override
	public int queryCount(Member queryParam) {
		return memberMapper.selectSelectiveCount(queryParam);
	}

}
