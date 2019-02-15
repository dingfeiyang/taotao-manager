package com.taotao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.common.pojo.EUDataGriResult;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.pojo.TbItemParam;
import com.taotao.service.ItemParamService;

@Controller
public class ItemParamController {

	@Autowired
	private ItemParamService itemParamService;
	
	@RequestMapping("/item/param/list")
	@ResponseBody
	public EUDataGriResult getItemParamItemList(Integer page, Integer rows){
		return itemParamService.getItemParamItemList(page, rows);
	}
	
	/**
	 * 商品模板管理参数
	 */
	@RequestMapping("/item/param/query/itemcatid/{itemid}")
	@ResponseBody
	public TaotaoResult getItemParamByCid(@PathVariable Long itemid){
		return itemParamService.getItemParamByCid(itemid);
	}
	
	/**
	 * 增加商品管理参数
	 */
	@RequestMapping("/item/param/save/{cid}")
	@ResponseBody
	public TaotaoResult insertItemParam(@PathVariable Long cid,String paramData){
		TbItemParam itemParam = new TbItemParam();
		itemParam.setItemCatId(cid);
		itemParam.setParamData(paramData);
		
		return itemParamService.insertItemParam(itemParam);
	}
}
