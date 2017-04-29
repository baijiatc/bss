<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<form id="frm_idxrate" method="post">
	<table cellpadding="5">
		<tr>
			<td>参数：</td>
			<td>
				<input class="easyui-textbox" type="text" name="parmid" data-options="required:true"></input>
			</td>
		</tr>
		<tr>
			<td>适用店铺：</td>
			<td><input class="easyui-textbox" type="text" name="forshop" data-options="required:true"></input></td>
		</tr>
		<tr>
			<td>使用品类：</td>
			<td><input class="easyui-textbox" type="text" name="forcat" data-options="required:true"></input></td>
		</tr>
		<tr>
			<td>使用对象：</td>
			<td><input class="easyui-textbox" type="text" name="forobj" data-options="required:true"></input></td>
		</tr>
		<tr>
			<td>参数值：</td>
			<td><input class="easyui-textbox" type="text" name="parmvalue" data-options="required:true"></input></td>
		</tr>
		<tr>
			<td>创建人：</td>
			<td><input class="easyui-textbox" type="text" name="creator" data-options="required:true"></input></td>
		</tr>
	</table>
</form>
<script>
	IDXRATEDIALOG.ok = function(){
		var idxrate = BSS.form2json('#frm_idxrate');
		BSS.dispatch({code:18007,data:[idxrate]},function(resp){
			if(resp.code == 0){
				BSS.info('保存成功');
			}else{
				BSS.warning(resp.message);
			}
		},function(resp){
			console.log(JSON.stringify(resp));
		});
	}
</script>