<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录——营销系统</title>
<link rel="stylesheet" type="text/css" href="js/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="js/easyui/themes/icon.css">
<link rel="stylesheet" type="text/css" href="css/login.css">
</head>
<body>
	<div id="login">  
        <h1>营销系统</h1>  
        <form method="post">  
            <input type="text" required="required" placeholder="用户名" name="uname"></input>  
            <input type="password" required="required" placeholder="密码" name="upass"></input>  
            <button class="but" type="button">登录</button>  
        </form>  
    </div>
<!-- javascript部分 -->
<script language="javascript" src="js/_b.js" charset="utf-8"></script>
<script language="javascript" src="js/jquery.min.js" charset="utf-8"></script>
<script language="javascript" src="js/easyui/jquery.easyui.min.js" charset="utf-8"></script>
<script>
$(function(){
	var $uname = $('#login input[name="uname"]');
	var $upass = $('#login input[name="upass"]');
	var $login = $('.but');
	$login.click(function(){
		if(BSS.Helper.isEmpty($uname.val())){
			BSS.warning('请输入用户名');
			return;
		}
		if(BSS.Helper.isEmpty($upass.val())){
			BSS.warning('请输入密码');
			return;
		}
		BSS.redirect('main');
	});
});
</script>
</body>
</html>