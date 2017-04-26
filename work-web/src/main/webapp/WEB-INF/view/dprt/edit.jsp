<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<form id="frm_deport" method="post">
	<table cellpadding="5">
		<tr>
			<td>部门名称：</td>
			<td>
				<input id="id_departname" class="easyui-textbox" type="text" name="departname" data-options="required:true"></input>
				<input id="id_departid" class="easyui-textbox" type="hidden" name="departid"></input>
			</td>
		</tr>
		<tr>
			<td>负责人：</td>
			<td><input id="id_leader" class="easyui-textbox" type="text" name="leader" data-options="required:false"></input></td>
		</tr>
		<tr>
			<td>上级部门：</td>
			<td><input id="id_parentid" class="easyui-textbox" type="text" name="parentid" data-options="required:false"></input></td>
		</tr>
		<tr>
			<td>地址：</td>
			<td><input id="id_address" class="easyui-textbox" type="text" name="address" data-options="required:false"></input></td>
		</tr>
		<tr>
			<td>联系电话：</td>
			<td><input id="id_telephone" class="easyui-textbox" type="text" name="telephone" data-options="required:false"></input></td>
		</tr>
		<tr>
			<td>部门状态：</td>
			<td><input id="cbx_departst" class="easyui-textbox" type="text" name="departst" data-options="required:true"></input></td>
		</tr>
	</table>
</form>
<script>
var genderCombox = new BSS.Combox('#cbx_departst');
genderCombox.fromDict('DICT_DEPARTST');

BSS.dispatch({code:11010,data:[{departid:'${departid}'}]},function(resp){
	BSS.json2form('#frm_deport',resp.data[0]);
});
DEPTDIALOG.ok = function(){
	var depart = BSS.form2json('#frm_deport');
	BSS.dispatch({code:11007,data:[depart]},function(){
		BSS.alert('保存成功！');
	},function(){});
}
</script>