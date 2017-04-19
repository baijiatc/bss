<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<form id="frm_role" method="post">
	<table cellpadding="5">
		<tr>
			<td>角色名称：</td>
			<td>
				<input id="id_rolename" class="easyui-textbox" type="text" name="rolename" data-options="required:true"></input>
				<input id="id_roleid" class="easyui-textbox" type="hidden" name="roleid"></input>
			</td>
		</tr>
		<tr>
			<td>角色状态：</td>
			<td><input id="cbx_rolest" class="easyui-combobox" type="text" name="rolest" data-options="required:true"></input></td>
		</tr>
	</table>
</form>
<script>
var roleStCombox = new BSS.Combox('#cbx_rolest');
roleStCombox.fromDict('DICT_ROLEST');

BSS.dispatch({code:20006,data:[{roleid:'${roleid}'}]},function(resp){
	BSS.json2form('#frm_role',resp.data[0]);
});
ROLEDIALOG.ok = function(){
	var role = BSS.form2json('#frm_role');
	BSS.dispatch({code:20008,data:[role]},function(){
		BSS.alert('保存成功！');
	},function(){});
}
</script>