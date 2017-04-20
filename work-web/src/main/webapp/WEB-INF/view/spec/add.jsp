<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<form id="frm_spec" method="post">
	<table cellpadding="5">
		<tr>
			<td>规格名称：</td>
			<td><input class="easyui-textbox" type="text" name="specname" data-options="required:true"></input></td>
		</tr>
		<tr>
			<td>规格值说明：</td>
			<td><input class="easyui-textbox" type="text" name="specdesc" data-options="required:false"></input></td>
		</tr>
		<tr>
			<td>规格类型：</td>
			<td><input class="easyui-textbox" type="text" name="spectype" data-options="required:true"></input></td>
		</tr>
		<tr>
			<td>规格状态：</td>
			<td><input class="easyui-textbox" type="text" name="specst" data-options="required:true"></input></td>
		</tr>
	</table>
</form>
<script>
SPECDIALOG.ok = function(){
	var prm = BSS.form2json('#frm_spec');
	BSS.dispatch({code:14010,data:[prm]},function(){
		BSS.alert();;
	},function(){});
}
</script>