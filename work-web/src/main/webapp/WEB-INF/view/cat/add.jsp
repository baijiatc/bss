<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<form id="frm_cat" method="post">
	<table cellpadding="4">
		<tr>
			<td>分类名称：</td>
			<td>
				<input class="easyui-textbox" type="text" name="catname" data-options="required:true"></input>
			</td>
		</tr>
		<tr>
			<td>上级分类：</td>
			<td><input class="easyui-textbox" type="text" name="parentid" data-options="required:false"></input></td>
		</tr>
		<tr>
			<td>分类logo：</td>
			<td><input class="easyui-textbox" type="text" name="catlogo" data-options="required:false"></input></td>
		</tr>
		<tr>
			<td>状态：</td>
			<td><input class="easyui-textbox" type="text" name="catst" data-options="required:true"></input></td>
		</tr>
	</table>
</form>
<script>
CATDIALOG.ok = function(){
	var cat = BSS.form2json('#frm_cat');
	BSS.dispatch({code:14004,data:[cat]},function(){
		BSS.alert("添加成功");;
	},function(){});
}
</script>