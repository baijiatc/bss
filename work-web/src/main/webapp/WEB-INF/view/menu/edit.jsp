<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<form id="frm_menu" method="post">
	<table cellpadding="6">
		<tr>
			<td>菜单名称：</td>
			<td>
				<input  id="id_menuname" class="easyui-textbox" type="text" name="menuname" data-options="required:true"></input>
			    <input  id="id_menuid" class="easyui-textbox" type="hidden" name="menuid" data-options="required:true"></input>
			</td>
		</tr>
		<tr>
			<td>菜单URL：</td>
			<td><input id="id_url"  class="easyui-textbox" type="text" name="url" data-options="required:false"></input></td>
		</tr>
		<tr>
			<td>父级菜单：</td>
			<td><input id="id_parentid"  class="easyui-textbox" type="text" name="parentid" data-options="required:false"></input></td>
		</tr>
		<tr>
			<td>菜单图标：</td>
			<td><input id="id_icon"  class="easyui-textbox" type="text" name="icon" data-options="required:false"></input></td>
		</tr>
		<tr>
			<td>菜单排序：</td>
			<td><input id="id_sort"  class="easyui-textbox" type="text" name="sort" data-options="required:false"></input></td>
		</tr>
		<tr>
			<td>状态：</td>
			<td><input id="id_menust"  class="easyui-textbox" type="text" name="menust" data-options="required:true"></input></td>
		</tr>
	</table>
</form>
<script>
BSS.dispatch({code:21091,data:[{menuid:'${menuid}'}]},function(resp){
	BSS.json2form('#frm_menu',resp.data[0]);
});
MENUDIALOG.ok = function(){
	var menu = BSS.form2json('#frm_menu');
	BSS.dispatch({code:21002,data:[menu]},function(){
		BSS.alert('保存成功！');
	},function(){});
}
</script>