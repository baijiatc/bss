<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<form id="frm_actparam" method="post">
	<table cellpadding="4">
		<tr>
			<td>活动名称：</td>
			<td>
				<input class="easyui-textbox" type="text" name="actid" data-options="required:true"></input>
			</td>
		</tr>
		<tr>
			<td>参数类型：</td>
			<td><input class="easyui-textbox" type="text" name="paramtype" data-options="required:false"></input></td>
		</tr>
		<tr>
			<td>参数值：</td>
			<td><input class="easyui-textbox" type="text" name="paramvalue" data-options="required:false"></input></td>
		</tr>
		<tr>
			<td>创建人：</td>
			<td><input class="easyui-textbox" type="text" name="creator" data-options="required:true"></input></td>
		</tr>
	</table>
</form>
<script>
ACTPARAMDIALOG.ok = function(){
	var actparam = BSS.form2json('#frm_actparam');
	BSS.dispatch({code:19004,data:[actparam]},function(){
		BSS.alert("添加成功");;
	},function(){});
}
</script>