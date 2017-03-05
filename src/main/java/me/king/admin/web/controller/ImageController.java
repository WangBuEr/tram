package me.king.admin.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("image")
public class ImageController {
	@RequestMapping("delete")
	@ResponseBody
	public String delete(){
		return "";
	}
}
