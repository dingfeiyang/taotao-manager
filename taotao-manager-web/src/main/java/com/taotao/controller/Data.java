package com.taotao.controller;

import java.util.List;
import java.util.Map;

public class Data {
	private List<String> cate;
	private Map<String, List<Sex>> data;
	private List<String> legend;
	public List<String> getCate() {
		return cate;
	}
	public void setCate(List<String> cate) {
		this.cate = cate;
	}
	public Map<String, List<Sex>> getData() {
		return data;
	}
	public void setData(Map<String, List<Sex>> data) {
		this.data = data;
	}
	public List<String> getLegend() {
		return legend;
	}
	public void setLegend(List<String> legend) {
		this.legend = legend;
	}
}
