package com.taotao.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taotao.common.pojo.EUTreeNode;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.mapper.TbContentCategoryMapper;
import com.taotao.pojo.TbContentCategory;
import com.taotao.pojo.TbContentCategoryExample;
import com.taotao.pojo.TbContentCategoryExample.Criteria;
import com.taotao.service.ContentCategoryService;

@Service
public class ContentCategoryServiceImpl implements ContentCategoryService {

	@Autowired
	private TbContentCategoryMapper contentCategoryMapper;
	
	@Override
	public List<EUTreeNode> getCategoryList(Long parentId) {
		//根据parentId查询节点列表
		TbContentCategoryExample example = new TbContentCategoryExample();
		Criteria cri = example.createCriteria();
		cri.andParentIdEqualTo(parentId);
		
		//执行查询
		List<TbContentCategory> list = contentCategoryMapper.selectByExample(example);
		
		List<EUTreeNode> resultList = new ArrayList<EUTreeNode>();
		for(TbContentCategory category : list){
			EUTreeNode node = new EUTreeNode();
			node.setId(category.getId());
			node.setText(category.getName());
			node.setState(category.getIsParent()?"closed":"open");
			
			resultList.add(node);
		}
		
		return resultList;
	}

	@Override
	public TaotaoResult inertContentCategory(Long parentId, String name) {
		//创建一个pojo
		TbContentCategory category = new TbContentCategory();
		category.setName(name);
		//1:正常，2：删除
		category.setStatus(1);
		category.setParentId(parentId);
		category.setCreated(new Date());
		category.setIsParent(false);
		category.setSortOrder(1);
		category.setUpdated(new Date());
		
		//添加纪录
		contentCategoryMapper.insert(category);
		
		//查看父节点的isParentId是否为true,如果不是true改为true
		TbContentCategory parentCat = contentCategoryMapper.selectByPrimaryKey(parentId);
		//判断是否为true
		if(!parentCat.getIsParent()){
			parentCat.setIsParent(true);
			//更新父节点
			contentCategoryMapper.updateByPrimaryKey(parentCat);
		}
		
		//返回节点
		return TaotaoResult.ok(category);
	}

	@Override
	public TaotaoResult deleteContentCategory(Long parentId, Long id) {
		
		//查询父节点
		TbContentCategory category = contentCategoryMapper.selectByPrimaryKey(id);
		TbContentCategory parentCat = contentCategoryMapper.selectByPrimaryKey(category.getId());
		//删除当前节点
		contentCategoryMapper.deleteByPrimaryKey(id);
		

		//查询该父节点是否有子节点
		TbContentCategoryExample categoryExample = new TbContentCategoryExample();
		Criteria cri = categoryExample.createCriteria();
		cri.andParentIdEqualTo(category.getParentId());
		List<TbContentCategory> list = contentCategoryMapper.selectByExample(categoryExample);
		if(list.size() == 0){
			parentCat.setIsParent(false);
			//更新父节点
			contentCategoryMapper.updateByPrimaryKey(parentCat);
		}
		
		return TaotaoResult.ok();
	}

	@Override
	public TaotaoResult updateContentCategory(Long id, String name) {
		TbContentCategory category = contentCategoryMapper.selectByPrimaryKey(id);
		category.setName(name);
		contentCategoryMapper.updateByPrimaryKey(category);
		
		return TaotaoResult.ok();
	}

}
