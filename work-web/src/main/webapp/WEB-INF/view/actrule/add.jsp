<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<form id="frm_actrule" method="post">
	<table cellpadding="4">
		<tr>
			<td>活动：</td>
			<td>
				<input class="easyui-textbox" type="text" name="actid" data-options="required:true"></input>
			</td>
		</tr>
		<tr>
			<td>对象类型：</td>
			<td><input class="easyui-textbox" type="text" name="objtype" data-options="required:false"></input></td>
		</tr>
		<tr>
			<td>活动对象：</td>
			<td><input class="easyui-textbox" type="text" name="objid" data-options="required:false"></input></td>
		</tr>
		<tr>
			<td>创建人：</td>
			<td><input class="easyui-textbox" type="text" name="creator" data-options="required:false"></input></td>
		</tr>
	 
	</table>
</form>
<script>
ACTRULEDIALOG.ok = function(){
	var actrule = BSS.form2json('#frm_actrule');
	BSS.dispatch({code:19010,data:[actrule]},function(){
		BSS.alert("添加成功");;
	},function(){});
}
</script>