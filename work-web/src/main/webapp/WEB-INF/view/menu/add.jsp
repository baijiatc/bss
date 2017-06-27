<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<form id="frm_menu" method="post">
	<table cellpadding="6">
		<tr>
			<td>菜单名称：</td>
			<td>
				<input class="easyui-textbox" type="text" name="menuname" data-options="required:true"></input>
			</td>
		</tr>
		<tr>
			<td>菜单URL：</td>
			<td><input class="easyui-textbox" type="text" name="url" data-options="required:false"></input></td>
		</tr>
		<tr>
			<td>上级菜单：</td>
			<td><input id="cbx_parentid" class="easyui-checkbox" type="text" name="parentid" data-options="required:false"></input></td>
		</tr>
		<tr>
			<td>菜单图标：</td>
			<td><input class="easyui-textbox" type="text" name="icon" data-options="required:false"></input></td>
		</tr>
		<tr>
			<td>菜单排序：</td>
			<td><input class="easyui-textbox" type="text" name="sort" data-options="required:false"></input></td>
		</tr>
		<tr>
			<td>状态：</td>
			<td><input  id="cbx_menust" class="easyui-textbox" type="text" name="menust" data-options="required:true"></input></td>
		</tr>
	</table> 
</form>
<script>
var menuStCombox = new BSS.Combox('#cbx_menust');
var parentidCombox=new BSS.Combox('#cbx_parentid');
menuStCombox.fromDict('DICT_MENUST',function(){
	MENUDIALOG.loadParentMenu('#cbx_parentid',function(){
		setOk();
	});
});
function setOk(){
	MENUDIALOG.ok = function(){
		var menu = BSS.form2json('#frm_menu');
		BSS.dispatch({code:21001,data:[menu],panelHeight:150},function(resp){
			if(resp.code == 0){
				BSS.info('保存成功');
			}else{
				BSS.warning(resp.message);
			}
		},function(resp){
			console.log(JSON.stringify(resp));
		});
	}
}
</script>