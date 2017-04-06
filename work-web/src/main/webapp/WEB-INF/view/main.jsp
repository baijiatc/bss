<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login Page</title>
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
}
</style>
<link rel="stylesheet" type="text/css" href="js/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="js/easyui/themes/icon.css">
</head>
<body>
	<div id="div_container" align="center" style="width:auto;">
		<div id="div_header" data-options="region:'north'" style="width:auto;height:80px;">
			<img src="images/banner.jpg" width="100%" height="78px">
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
	BSS.include('#div_left','main/left');
	BSS.include('#div_center','main/center');
});
</script>
</body>
</html>