<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<form id="frm_role" method="post">
	<table cellpadding="5">
		<tr>
			<td>角色名称：</td>
			<td>
				<input class="easyui-textbox" type="text" name="rolename" data-options="required:true"></input>
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

ROLEDIALOG.ok = function(){
	var role = BSS.form2json('#frm_role');
	BSS.dispatch({code:20005,data:[role]},function(){
		BSS.alert();
	},function(){});
}
</script>