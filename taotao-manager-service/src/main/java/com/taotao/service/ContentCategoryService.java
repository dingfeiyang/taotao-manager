package com.taotao.service;

import java.util.List;

import com.taotao.common.pojo.EUTreeNode;
import com.taotao.common.pojo.TaotaoResult;

public interface ContentCategoryService {

	List<EUTreeNode> getCategoryList(Long parentId);
	
	TaotaoResult inertContentCategory(Long parentId,String name);
	
	TaotaoResult deleteContentCategory(Long parent,Long id);
	
	TaotaoResult updateContentCategory(Long id,String name);
}
