package com.taotao.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.common.pojo.EUTreeNode;
import com.taotao.service.ItemCatService;

@Controller
@RequestMapping("/item/cat")
public class ItemCatController {

	@Autowired
	private ItemCatService itemCatService;
	
	/**
	 *获取新增商品的选择类目 
	 */
	@RequestMapping("/list")
	@ResponseBody
	private List<EUTreeNode> getCayList(@RequestParam(value="id",defaultValue="0")long parentId){
		List<EUTreeNode> list = itemCatService.getCatList(parentId);
		return list;
	}
	
	/**
	 *自己测试 
	 */
	@RequestMapping("/test")
	public String test(){
		return "test";
	}
	
}
