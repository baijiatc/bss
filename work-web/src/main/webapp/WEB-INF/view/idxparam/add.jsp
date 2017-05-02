<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<form id="frm_idxparam" method="post">
	<table cellpadding="5">
		<tr>
			<td>参数代码：</td>
			<td>
				<input class="easyui-textbox" type="text" name="parmcode" data-options="required:true"></input>
			</td>
		</tr>
		<tr>
			<td>参数名称：</td>
			<td><input class="easyui-textbox" type="text" name="parmname" data-options="required:true"></input></td>
		</tr>
		<tr>
			<td>参数类型：</td>
			<td><input class="easyui-textbox" type="text" name="parmtype" data-options="required:true"></input></td>
		</tr>
		<tr>
			<td>默认值：</td>
			<td><input class="easyui-textbox" type="text" name="defaultvalue" data-options="required:true"></input></td>
		</tr>
		<tr>
			<td>创建人：</td>
			<td><input class="easyui-textbox" type="text" name="creator" data-options="required:false"></input></td>
		</tr>
	</table>
</form>
<script>
	IDXPARAMDIALOG.ok = function(){
		var idx = BSS.form2json('#frm_idxparam');
		BSS.dispatch({code:18004,data:[idx]},function(resp){
			if(resp.code == 0){
				BSS.info('保存成功');
			}else{
				BSS.warning(resp.message);
			}
		},function(resp){
			console.log(JSON.stringify(resp));
		});
	}
</script>