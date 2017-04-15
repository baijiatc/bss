<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<form id="rpasswdedit" method="post">   
	<table cellpadding="5">  
		<tr>   
			<th>旧密码</th>   
			<td> 
				<input id="id_opasswd" name="opasswd" type="password" class="easyui-textbox" required="true" missingMessage="请填写旧密码" />  
				<input id="id_staffid" class="easyui-textbox" type="hidden" name="staffid"></input>
				<input id="id_passwd" name="passwd" class="easyui-textbox" type="hidden"/> 
			</td>   
		</tr>  
		<tr>   
			<th>新密码</th>   
			<td> 
				<input id="id_npasswd" name="npasswd" type="password" class="easyui-textbox" required="true" missingMessage="请填写新密码" />  
			</td>   
		</tr>   
		<tr>  
			 <th>重复</th>   
			 <td>  
			 	<input id="id_repasswd" name="repasswd" type="password" class="easyui-textbox" required="true" missingMessage="请再次填写新密码" validType="eqPassword['#modifyPwdForm input[name=passwd]']" />  
			 </td>   
		</tr>   
	 </table>   
 </form> 
<script>
BSS.dispatch({code:11009,data:[{staffid:'${staffid}'}]},function(resp){
	BSS.json2form('#rpasswdedit',resp.data[0]);
});
RPASSDIALOG.ok = function(){
	if($("#id_opasswd").val()!==$("#id_passwd").val()){
		BSS.warning('旧密码输入错误请重新输入！');
		return;
	}
	if($("#id_npasswd").val()!==$("#id_repasswd").val()){
		BSS.warning('两次输入的密码不一致请重新修改！');
		return;
	}
	if($("#id_npasswd").val() =='' || $("#id_repasswd").val() ==''){
		BSS.warning('密码不能为空请重新设置！');
		return;
	}
		var passwd = $("#id_npasswd").val();
	    var staffid = $("#id_staffid").val();
	    var passwdedits = {passwd:""+passwd+"",staffid:""+staffid+""};
	BSS.dispatch({code:11004,data:[passwdedits]},function(){
		BSS.alert('修改成功，即将退出登录！');
		setTimeout(function () { BSS.redirect('login.html');}, 5000);
	},function(){});
}
</script>