<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>主界面——营销系统</title>
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
			<a href="javascript:void(0)" style="float:right;margin-top:50px;color:gray;" id="lnk_usercenter" class="easyui-menubutton" data-options="menu:'#lnk_usersubcenter'">你好：${loginuser }</a>
			<div id="lnk_usersubcenter" style="width:150px;">
				<div data-options="iconCls:'icon-blank'">用户中心</div>
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
<script>
$(function(){
	var layout = new BSS.Layout('#div_container');
	layout.layout();
	BSS.include('#div_left','main/left.html');
	BSS.include('#div_center','main/center.html');
	$('#div_logout').click(function(){
		BSS.dispatch({code:10002},function(){
			BSS.redirect('login.html');
		},function(){});
	});
});
</script>
</body>
</html>