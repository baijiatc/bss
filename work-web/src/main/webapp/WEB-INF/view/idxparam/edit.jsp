<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<form id="frm_idxparam" method="post">
	<table cellpadding="5">
		<tr>
			<td>参数代码：</td>
			<td>
				<input id="id_parmcode" class="easyui-textbox" type="text" name="parmcode" data-options="required:true"></input>
				<input id="id_id" class="easyui-textbox" type="hidden" name="id"></input>
			</td>
		</tr>
		<tr>
			<td>参数名称：</td>
			<td><input id="id_parmname" class="easyui-textbox" type="text" name="parmname" data-options="required:true"></input></td>
		</tr>
		<tr>
			<td>参数类型：</td>
			<td><input id="id_parmtype" class="easyui-textbox" type="text" name="parmtype" data-options="required:true"></input></td>
		</tr>
		<tr>
			<td>默认值：</td>
			<td><input id="id_defaultvalue" class="easyui-textbox" type="text" name="defaultvalue" data-options="required:true"></input></td>
		</tr>
		<tr>
			<td>创建人：</td>
			<td><input id="id_creator" class="easyui-textbox" type="text" name="creator" data-options="required:false"></input></td>
		</tr>
	</table>
</form>
<script>
BSS.dispatch({code:18011,data:[{id:'${id}'}]},function(resp){
	BSS.json2form('#frm_idxparam',resp.data[0]);
});
IDXPARAMDIALOG.ok = function(){
	var idxparam = BSS.form2json('#frm_idxparam');
	BSS.dispatch({code:18005,data:[idxparam]},function(){
		BSS.alert('保存成功！');
	},function(){});
}
</script>