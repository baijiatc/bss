<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<form id="frm_api" method="post">
	<table cellpadding="5">
		<tr>
			<td>业务编码：</td>
			<td>
				<input id="id_code" class="easyui-textbox" type="text" name="code" data-options="required:true"></input>
				<input id="id_apiid" class="easyui-textbox" type="hidden" name="apiid"></input>
			</td>
		</tr>
		<tr>
			<td>业务名称：</td>
			<td>
				<input id="id_apiname" class="easyui-textbox" type="text" name="apiname" data-options="required:true"></input>
			</td>
		</tr>
		<tr>
			<td>URL：</td>
			<td>
				<input id="id_apiurl" class="easyui-textbox" type="text" name="apiurl" data-options="required:true"></input>
			</td>
		</tr>
		<tr>
			<td>返回类型：</td>
			<td>
				<input id="id_retype" class="easyui-textbox" type="text" name="retype" data-options="required:true"></input>
			</td>
		</tr>
		<tr>
			<td>状态：</td>
			<td><input id="id_apist" class="easyui-textbox" type="text" name="apist" data-options="required:true"></input></td>
		</tr>
	</table>
</form>
<script>
BSS.dispatch({code:21011,data:[{apiid:'${apiid}'}]},function(resp){
	BSS.json2form('#frm_api',resp.data[0]);
});
</script>