<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<form id="frm_api" method="post">
	<table cellpadding="5">
		<tr>
			<td>业务编码：</td>
			<td>
				<input class="easyui-textbox" type="text" name="code" data-options="required:true"></input>
			</td>
		</tr>
		<tr>
			<td>业务名称：</td>
			<td>
				<input class="easyui-textbox" type="text" name="apiname" data-options="required:true"></input>
			</td>
		</tr>
		<tr>
			<td>URL：</td>
			<td>
				<input class="easyui-textbox" type="text" name="apiurl" data-options="required:true"></input>
			</td>
		</tr>
		<tr>
			<td>返回类型：</td>
			<td>
				<input class="easyui-textbox" type="text" name="retype" data-options="required:true" value="json"></input>
			</td>
		</tr>
		<tr>
			<td>状态：</td>
			<td><input class="easyui-textbox" type="text" name="apist" data-options="required:true"></input></td>
		</tr>
	</table>
</form>