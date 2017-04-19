<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<form id="frm_prm" method="post">
	<table cellpadding="5">
		<tr>
			<td>参数名称：</td>
			<td><input class="easyui-textbox" type="text" name="paramname" data-options="required:true"></input></td>
		</tr>
		<tr>
			<td>参数描述：</td>
			<td><input class="easyui-textbox" type="text" name="paramdesc" data-options="required:false"></input></td>
		</tr>
		<tr>
			<td>参数类型：</td>
			<td><input class="easyui-textbox" type="text" name="paramtype" data-options="required:true"></input></td>
		</tr>
		<tr>
			<td>规格状态：</td>
			<td><input class="easyui-textbox" type="text" name="paramst" data-options="required:true"></input></td>
		</tr>
	</table>
</form>
<script>
PARMDIALOG.ok = function(){
	var prm = BSS.form2json('#frm_prm');
	BSS.dispatch({code:14007,data:[prm]},function(){
		BSS.alert();;
	},function(){});
}
</script>