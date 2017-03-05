package me.king.admin.web.controller;


import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import me.king.admin.service.MemberService;
import me.king.admin.web.vo.DataTablesRsp;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import me.king.admin.domain.Member;

@Controller
@RequestMapping("member")
public class MemberController {
	@Resource
	private MemberService memberService;
	@RequestMapping("search")
	public ModelAndView search(){
		ModelAndView result = new ModelAndView();
		result.setViewName("member/search");
		return result;
	}
	@RequestMapping("query")
	@ResponseBody
	public DataTablesRsp<Member> query(Member queryParam){
		DataTablesRsp<Member> result = new DataTablesRsp<>(queryParam.getDraw());
		List<Member> datas =  memberService.query(queryParam);
		int count =  memberService.queryCount(queryParam);
		result.setData(datas);
		result.setRecordsTotal(count);
		result.setRecordsFiltered(count);
		return result;
	}
}
