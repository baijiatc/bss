<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<form id="frm_cat" method="post">
	<table cellpadding="5">
				<tr>
			<td>分类名称：</td>
			<td>
				<input id="id_catname" class="easyui-textbox" type="text" name="catname" data-options="required:true"></input>
			    <input id="id_id" class="easyui-textbox" type="hidden" name="id" data-options="required:true"></input>
			</td>
		</tr>
		<tr>
			<td>上级分类：</td>
			<td><input id="id_parentid"  class="easyui-textbox" type="text" name="parentid" data-options="required:false"></input></td>
		</tr>
		<tr>
			<td>分类logo：</td>
			<td><input  id="id_catlogo" class="easyui-textbox" type="text" name="catlogo" data-options="required:false"></input></td>
		</tr>
		<tr>
			<td>状态：</td>
			<td><input  id="id_catst" class="easyui-textbox" type="text" name="catst" data-options="required:true"></input></td>
		</tr>
	</table>
</form>
<script>
BSS.dispatch({code:14091,data:[{id:'${id}'}]},function(resp){
	BSS.json2form('#frm_cat',resp.data[0]);
});
CATDIALOG.ok = function(){
	var cat = BSS.form2json('#frm_cat');
	BSS.dispatch({code:14005,data:[cat]},function(){
		BSS.alert('保存成功！');
	},function(){});	
}
</script>