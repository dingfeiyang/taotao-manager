package com.taotao.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.taotao.common.pojo.TaotaoResult;
import com.taotao.common.util.JsonUtils;

public class TestJson {
	public static void main(String[] args) {
		User u = new User();
		u.setCode("suc");
		u.setMsg("");
		
		Data d = new Data();
		List<String> cate = new ArrayList<String>();
		cate.add("ELeMe");
		cate.add("Eleme Xingxuan");
		cate.add("MeiTuan");
		d.setCate(cate);
		
		List<String> legend = new ArrayList<String>();
		legend.add("ELeMe");
		legend.add("Eleme Xingxuan");
		legend.add("MeiTuan");
		d.setLegend(legend);
		
		List<Sex> sList1 = new ArrayList<Sex>();
		Sex s11 = new Sex();
		s11.setSales(29662210.15980951);
		s11.setYearmonth("201805");
		Sex s12 = new Sex();
		s12.setSales(36389093.08366665);
		s12.setYearmonth("201806");
		Sex s13 = new Sex();
		s13.setSales(100494466.27999997);
		s13.setYearmonth("201807");
		Sex s14 = new Sex();
		s14.setSales(35450748.69123647);
		s14.setYearmonth("201808");
		Sex s15 = new Sex();
		s15.setSales(38458923.7504365);
		s15.setYearmonth("201809");
		sList1.add(s11);
		sList1.add(s12);
		sList1.add(s13);
		sList1.add(s14);
		sList1.add(s15);
		
		List<Sex> sList2 = new ArrayList<Sex>();
		Sex s21 = new Sex();
		s21.setSales(13761288.789999997);
		s21.setYearmonth("201805");
		Sex s22 = new Sex();
		s22.setSales(12069327.3);
		s22.setYearmonth("201806");
		Sex s23 = new Sex();
		s23.setSales(3574098.6100000003);
		s23.setYearmonth("201807");
		Sex s24 = new Sex();
		s24.setSales(3990207.82);
		s24.setYearmonth("201808");
		Sex s25 = new Sex();
		s25.setSales(3403036.750000001);
		s25.setYearmonth("201809");
		sList2.add(s21);
		sList2.add(s22);
		sList2.add(s23);
		sList2.add(s24);
		sList2.add(s25);
		
		
		List<Sex> sList3 = new ArrayList<Sex>();
		Sex s31 = new Sex();
		s31.setSales(15756308.224126982);
		s31.setYearmonth("201805");
		Sex s32 = new Sex();
		s32.setSales(15801158.09960317);
		s32.setYearmonth("201806");
		Sex s33 = new Sex();
		s33.setSales(35814045.31);
		s33.setYearmonth("201807");
		Sex s34 = new Sex();
		s34.setSales(18696867.416507937);
		s34.setYearmonth("201808");
		Sex s35 = new Sex();
		s35.setSales(18251913.706031743);
		s35.setYearmonth("201809");
		sList3.add(s31);
		sList3.add(s32);
		sList3.add(s33);
		sList3.add(s34);
		sList3.add(s35);
		
		Map<String, List<Sex>> data = new HashMap<String, List<Sex>>();
		data.put("ELeMe", sList1);
		data.put("Eleme Xingxuan", sList2);
		data.put("MeiTuan", sList3);
		d.setData(data);
		u.setData(d);
		
		String json = JsonUtils.objectToJson(u);
		System.out.println(json);
		
		
		
		
		
	}
}
