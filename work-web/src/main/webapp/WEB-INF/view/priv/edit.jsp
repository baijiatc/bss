<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<form id="frm_priv" method="post">
	<table cellpadding="5">
		<tr>
			<td>权限名称：</td>
			<td>
				<input id="id_privname" class="easyui-textbox" type="text" name="privname" data-options="required:true"></input>
				<input id="id_privid" class="easyui-textbox" type="hidden" name="privid"></input>
			</td>
		</tr>
		<tr>
			<td>权限分类：</td>
			<td><input id="id_privtype" class="easyui-textbox" type="text" name="privtype" data-options="required:true"></input></td>
		</tr>
		<tr>
			<td>权限类别：</td>
			<td><input id="id_privcat" class="easyui-textbox" type="text" name="privcat" data-options="required:true"></input></td>
		</tr>
		<tr>
			<td>权限状态：</td>
			<td><input id="id_privst" class="easyui-textbox" type="text" name="privst" data-options="required:true"></input></td>
		</tr>
		<tr>
			<td>权限描述：</td>
			<td><input id="id_privdesc" class="easyui-textbox" type="text" name="privdesc" data-options="multiline:true" style="height:60px"></input></td>
		</tr>
	</table>
</form>
<script>
BSS.dispatch({code:20002,data:[{privid:'${privid}'}]},function(resp){
	BSS.json2form('#frm_priv',resp.data[0]);
});
PRIVDIALOG.ok = function(){
	var priv = BSS.form2json('#frm_priv');
	BSS.dispatch({code:20004,data:[priv]},function(){
		BSS.alert('保存成功！');
	},function(){});
}
</script>