package com.taotao.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.common.pojo.EUDataGriResult;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.common.util.IDUtils;
import com.taotao.mapper.TbItemDescMapper;
import com.taotao.mapper.TbItemMapper;
import com.taotao.mapper.TbItemParamItemMapper;
import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbItemDesc;
import com.taotao.pojo.TbItemExample;
import com.taotao.pojo.TbItemExample.Criteria;
import com.taotao.pojo.TbItemParamItem;
import com.taotao.service.ItemService;
/**
 *商品管理Service 
 *
 */
@Service
public class ItemServiceImpl implements ItemService{

	@Autowired
	private TbItemMapper itemMapper;
	
	@Autowired
	private TbItemDescMapper itemDescMapper;
	
	@Autowired
	private TbItemParamItemMapper itemParamItemMapper;
	
	/*
	 * 跟据商品id查询商品信息
	 */
	@Override
	public TbItem getItemById(long itemId) {
		//TbItem item = itemMapper.selectByPrimaryKey(itemId);
		
		TbItemExample example = new TbItemExample();
		//添加查询条件
		Criteria criteria = example.createCriteria();
		criteria.andIdEqualTo(itemId);
		List<TbItem> list = itemMapper.selectByExample(example);
		if(list != null && list.size() >0){
			TbItem item = list.get(0);
			return item;
		}
		return null;
	}
	/*
	 * 商品列表查询
	 */
	@Override
	public EUDataGriResult getItemList(int page, int rows) {
		//查询商量列表
		TbItemExample example = new TbItemExample();
		
		//分页处理
		PageHelper.startPage(page, rows);
		List<TbItem> list = itemMapper.selectByExample(example);
		
		//创建一个返回值对象
		EUDataGriResult result = new EUDataGriResult();
		result.setRows(list);
		PageInfo<TbItem> pageinfo = new PageInfo<TbItem>(list);
		result.setTotal(pageinfo.getTotal());
		return result;
	}
	
	@Override
	public TaotaoResult createItem(TbItem item,String desc,String itemParams) throws Exception {
		//把从前段获取的Item补全
		//生成商品Id
		Long itemId = IDUtils.genItemId();
		item.setId(itemId);
		//商品的状态， 1-正常 ，2-下架，3-删除
		item.setStatus((byte)1);
		item.setCreated(new Date());
		item.setUpdated(new Date());
		
		TaotaoResult result = this.insertItemDesc(itemId, desc);
		TaotaoResult result1 = this.insertItemParamsItem(itemId, itemParams);
		if(result.getStatus() != 200 || result1.getStatus() != 200){
			throw new Exception();
		}
		
		itemMapper.insert(item);
		return TaotaoResult.ok();
	}
	
	/**
	 * 添加商品描述
	 */
	private TaotaoResult insertItemDesc(Long itemId,String desc){
		TbItemDesc itemDesc = new TbItemDesc();
		itemDesc.setItemId(itemId);
		itemDesc.setItemDesc(desc);
		itemDesc.setCreated(new Date());
		itemDesc.setUpdated(new Date());

		itemDescMapper.insert(itemDesc);
		
		return TaotaoResult.ok();
	}
	
	/**
	 * 添加商品规格参数
	 */

	private TaotaoResult insertItemParamsItem(Long itemId,String itemParams){
		TbItemParamItem itemParamItem = new TbItemParamItem();
		itemParamItem.setCreated(new Date());
		itemParamItem.setItemId(itemId);
		itemParamItem.setParamData(itemParams);
		itemParamItem.setUpdated(new Date());
		
		itemParamItemMapper.insert(itemParamItem);
		
		return TaotaoResult.ok();
	}
	
}
