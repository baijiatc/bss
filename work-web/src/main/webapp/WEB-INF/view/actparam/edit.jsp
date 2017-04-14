<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<form id="frm_actparam" method="post">
	<table cellpadding="5">
		<tr>
			<td>活动名称：</td>
			<td>
				<input  id="id_actid" class="easyui-textbox" type="text" name="actid" data-options="required:true"></input>
				<input  id="id_id"  class="easyui-textbox" type="hidden" name="id" data-options="required:true"></input>
			</td>
		</tr>
	<tr>
			<td>参数类型：</td>
			<td><input id="id_paramtype"  class="easyui-textbox" type="text" name="paramtype" data-options="required:false"></input></td>
		</tr>
		<tr>
			<td>参数值：</td>
			<td><input id="id_paramvalue"  class="easyui-textbox" type="text" name="paramvalue" data-options="required:false"></input></td>
		</tr>
		<tr>
			<td>创建人：</td>
			<td><input  id="id_creator"  class="easyui-textbox" type="text" name="creator" data-options="required:true"></input></td>
		</tr>
	</table>
</form>
<script>
BSS.dispatch({code:19091,data:[{id:'${id}'}]},function(resp){
	BSS.json2form('#frm_actparam',resp.data[0]);
});
ACTPARAMDIALOG.ok = function(){
	var actparam = BSS.form2json('#frm_actparam');
	BSS.dispatch({code:19005,data:[actparam]},function(){
		BSS.alert('保存成功！');
	},function(){});	
}
</script>