<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>测试taotao商城</title>
<link href="/js/kindeditor-4.1.10/themes/default/default.css" type="text/css" rel="stylesheet">
<script type="text/javascript" src="/js/jquery-easyui-1.4.1/jquery.min.js"></script>
<script type="text/javascript" charset="utf-8" src="/js/kindeditor-4.1.10/kindeditor-all-min.js"></script>
<script type="text/javascript" charset="utf-8" src="/js/kindeditor-4.1.10/lang/zh_CN.js"></script>
<body>
<!-- 	<form id="itemAddForm" action="">
		<table>
			<tr>
				<td>商品图片:</td>
				<td>
					<a href="javascript:void(0)" class="picFileUpload" id="upload">上传图片</a>
					<input type="hidden" name="image" />
				</td>
			</tr>
			<tr>
				<td>商品描述:</td>
				<td>
					<textarea style="width: 800px; height: 300px; visibility: hidden;"name="desc" id="descript"></textarea>
				</td>
			</tr>
			<tr>
				<td>提交：</td>
				<td>
					<input type="button" value="提交" id="sub"/>
				</td>
			</tr>
		</table>

	</form> -->
	<ul class="level-1 yes">
	  <li class="item-i">I</li>
	  <li class="item-ii">II
	    <ul class="level-2 yes">
	      <li class="item-a">A</li>
	      <li class="item-b">B
	        <ul class="level-3">
	          <li class="item-1">1</li>
	          <li class="item-2">2</li>
	          <li class="item-3">3</li>
	        </ul>
	      </li>
	      <li class="item-c">C</li>
	    </ul>
	  </li>
	  <li class="item-iii">III</li>
	</ul>
	<script type="text/javascript">
/* 	//var itemAddEditor ;
	//页面初始化完毕后执行此方法
	 var editor;
	$(function(){
		//itemAddEditor = KindEditor.create("#itemAddForm [name=desc]");
		
        KindEditor.ready(function(K) {
            editor = K.create('#itemAddForm [name=desc]',{
            	 uploadJson : '/pic/upload',
            	 filePostName : "uploadFile",
            	 dir : "image"
            });
           
        })
	});
	$("#sub").click(function(){
		editor.sync();
		var s = $("#descript").val();
		alert(s);
	}); */
	
	$("li.item-1").parentsUntil(".level-2")
	  .css("background-color", "red");

	$("li.item-2").parentsUntil( $("ul.level-1"), ".yes" )
	  .css("border", "3px solid blue");
	</script>
</body>
</html>