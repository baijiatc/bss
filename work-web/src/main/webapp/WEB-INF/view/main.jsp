<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ page import="cn.bjtc.common.ApplicationDataManager" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>主界面——<%=ApplicationDataManager.getSysParamByCode("APP_NAME") %></title>
<style>
body{
	background-color:#FFFFFF;
}
ul{
	list-style:none;
}
#div_left ul li{
	padding:5px;
}
#div_left ul li:hover{
	background-color:#FFE48D
}
a{
	text-decoration: none;
	color:#000;
}
</style>
<link rel="stylesheet" type="text/css" href="js/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="js/easyui/themes/insdep/icon.css">
</head>
<body>
	<div id="div_container" align="center" style="width:auto;">
		<div id="div_header" data-options="region:'north'" style="vertical-align:bottom;width:auto;height:80px;background:url(images/banner.jpg) no-repeat;background-size:100% 78px;">
			<a href="javascript:void(0)" style="float:right;margin-top:50px;color:gray;" id="lnk_usercenter" class="easyui-menubutton" data-options="menu:'#lnk_usersubcenter'">你好：${_current_user_name }</a>
			<div id="lnk_usersubcenter" style="width:150px;">
				<div id="div_staffcenter" data-options="iconCls:'icon-blank'">个人中心</div>
				<div class="menu-sep"></div>
				<div id="div_logout" data-options="iconCls:'icon-blank'">退出</div>
			</div>
		</div>
		<div id="div_footer" data-options="region:'south'" style="width:auto;height:40px;"></div>
		<div id="div_left" data-options="region:'west'" style="width:180px;">
			<!-- left -->
		</div>
		<div id="div_center" data-options="region:'center'" style="width:auto">
			<!-- center -->
		</div>
	</div>
<!-- javascript部分 -->
<script language="javascript" src="js/jquery.min.js" charset="utf-8"></script>
<script language="javascript" src="js/_b.js" charset="utf-8"></script>
<script language="javascript" src="js/easyui/jquery.easyui.min.js" charset="utf-8"></script>
<script language="javascript" src="js/easyui/locale/easyui-lang-zh_CN.js" charset="utf-8"></script>
<script language="javascript" src="js/easyui-tree-extend.js" charset="utf-8"></script>
<script>
$(function(){
	var layout = new BSS.Layout('#div_container');
	layout.layout();
	BSS.include('#div_left','main/left.html');
	BSS.include('#div_center','main/center.html');
	$('#div_staffcenter').click(function(){
		var url = 'staff/${_current_user.uid}/profile.html'
		var title = $(this).text();
		BSS.showView(url,function(html){
			MAINTAB.add(title,html);
		});
	});
	$('#div_logout').click(function(){
		BSS.dispatch({code:10002},function(){
			BSS.redirect('login.html');
		},function(){});
	});
});
BSS.Combox.prototype.fromDict=function(type,callback){
	var $this = this;
	BSS.dispatch({code:21017,data:[{type:type}]},function(resp){
		if(resp.code == 0){
			var datas = resp.data;
			var options = {valueField:'value',textField:'label',data:datas};
			$this.init(options);
			callback = callback || new Function();
		}else{
			BSS.warning(resp.message);
		}
	},function(resp){
		console.log(JSON.stringify(resp));
	});
};
BSS.formatTime = function(val,row){
	if(val <= 0){return '-';}
	var valDate = new Date(val);
	return BSS.DateTime.format(valDate);
}
</script>
</body>
</html>