package com.taotao.service;

import com.taotao.common.pojo.EUDataGriResult;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.pojo.TbItemParam;

public interface ItemParamService {

	EUDataGriResult getItemParamItemList(int page,int rows);
	
	TaotaoResult getItemParamByCid(Long cid);
	
	TaotaoResult insertItemParam(TbItemParam itemParam);

}
