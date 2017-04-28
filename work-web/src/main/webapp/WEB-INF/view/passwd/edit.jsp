<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<form id="passwdedit" method="post">   
	<table cellpadding="5">   
		<tr>   
		<th>新密码</th>   
			<td> 
				<input id="id_passwd" name="passwd" type="password" class="easyui-textbox" required="true" missingMessage="请填写新密码" />  
				<input id="id_staffid" class="easyui-textbox" type="hidden" name="staffid"></input>
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
		if(resp.code == 0){
			BSS.json2form('#passwdedit',resp.data[0]);
			
			PASSDIALOG.ok = function(){
				if($("#id_passwd").val()!==$("#id_repasswd").val()){
					BSS.warning('两次输入的密码不一致请重新修改！');
					return;
				}
				if($("#id_passwd").val() =='' || $("#id_repasswd").val() ==''){
					BSS.warning('密码不能为空请重新设置！');
					return;
				}
					var passwd = $("#id_passwd").val();
				    var staffid = $("#id_staffid").val();
				    var passwdedits = {passwd:""+passwd+"",staffid:""+staffid+""};
				BSS.dispatch({code:11004,data:[passwdedits]},function(){
					BSS.alert('重置成功！');
				},function(){});
			};
		}else{
			PASSDIALOG.ok = function(){};
			BSS.warning(resp.message);
		}
	});
</script>