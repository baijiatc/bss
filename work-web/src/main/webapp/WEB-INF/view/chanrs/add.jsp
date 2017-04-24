<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<form id="frm_chanrs" method="post">
	<table cellpadding="5">
		<tr>
			<td>渠道名称：</td>
			<td>
				<input class="easyui-textbox" type="text" name="objid" data-options="required:true"></input>
			</td>
		</tr>
		<tr>
			<td>员工名称：</td>
			<td><input class="easyui-textbox" type="text" name="staffid" data-options="required:true"></input></td>
		</tr>
		<tr>
			<td>关系类型：</td>
			<td><input class="easyui-textbox" type="text" name="cstype" data-options="required:true"></input></td>
		</tr>
		<tr>
			<td>对象类型：</td>
			<td><input id="cbx_objtype" class="easyui-textbox" type="text" name="objtype" data-options="required:true"></input></td>
		</tr>
		<tr>
			<td>创建时间：</td>
			<td><input class="easyui-textbox" type="text" name="createtime" data-options="required:true"></input></td>
		</tr>
	</table>
</form>
<script>
var objTypeCombox = new BSS.Combox('#cbx_objtype');
objTypeCombox.fromDict('DICT_OBJTYPE');

SUPPRSDIALOG.ok = function(){
	var supp = BSS.form2json('#frm_chanrs');
	BSS.dispatch({code:13004,data:[supp]},function(){
		BSS.alert();;
	},function(){});
}
</script>