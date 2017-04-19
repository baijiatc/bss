<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<form id="frm_actrule" method="post">
	<table cellpadding="4">
			<tr>
			<td>活动：</td>
			<td>
				<input id="id_actid" class="easyui-textbox" type="text" name="actid" data-options="required:true"></input>
			    <input id="id_id" class="easyui-textbox" type="hidden" name="id" data-options="required:true"></input>
			</td>
		</tr>
		<tr>
			<td>对象类型：</td>
			<td><input  id="id_objtype" class="easyui-textbox" type="text" name="objtype" data-options="required:false"></input></td>
		</tr>
		<tr>
			<td>活动对象：</td>
			<td><input  id="id_objid" class="easyui-textbox" type="text" name="objid" data-options="required:false"></input></td>
		</tr>
			<tr>
			<td>创建人：</td>
			<td><input  id="id_objid" class="easyui-textbox" type="text" name="creator" data-options="required:false"></input></td>
		</tr>
	 
	</table>
</form>
<script>
BSS.dispatch({code:19014,data:[{id:'${id}'}]},function(resp){
	BSS.json2form('#frm_actrule',resp.data[0]);
});
ACTRULEDIALOG.ok = function(){
	var actrule = BSS.form2json('#frm_actrule');
	BSS.dispatch({code:19011,data:[actrule]},function(){
		BSS.alert('保存成功！');
	},function(){});	
}
</script>