<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<form id="frm_supprs" method="post">
	<table cellpadding="5">
		<tr>
			<td>客户名称：</td>
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
			<td><input  class="easyui-textbox" type="text" name="createtime" data-options="required:true"></input></td>
		</tr>
	</table>
</form>
<script>
var objCombox = new BSS.Combox('#cbx_objtype');
objCombox.fromDict('DICT_OBJTYPE',function(){
	setOk();
});

function setOk(){
	SUPPRSDIALOG.ok = function(){
		var supp = BSS.form2json('#frm_supprs');
		BSS.dispatch({code:13004,data:[supp]},function(){
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