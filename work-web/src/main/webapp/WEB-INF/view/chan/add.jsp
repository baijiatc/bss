<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<form id="frm_chanadd" method="post">
	<table cellpadding="5">
		<tr>
			<td>渠道名称：</td>
			<td>
				<input class="easyui-textbox" type="text" name="channame" data-options="required:true"></input>
			</td>
		</tr>
		<tr>
			<td>渠道分类：</td>
			<td>
				<input class="easyui-textbox" type="text" name="chantype" data-options="required:true"></input>
			</td>
		</tr>
		<tr>
			<td>联系人：</td>
			<td>
				<input class="easyui-textbox" type="text" name="contact" data-options="required:true"></input>
			</td>
		</tr>
		<tr>
			<td>手机：</td>
			<td>
				<input class="easyui-textbox" type="text" name="mobile" data-options="required:true"></input>
			</td>
		</tr>
		<tr>
			<td>省市区：</td>
			<td>
				<input class="easyui-textbox" type="text" style="width:18%" name="province"></input>
				<input class="easyui-textbox" type="text" style="width:18%" name="city"></input>
				<input class="easyui-textbox" type="text" style="width:18%" name="district"></input>
			</td>
		</tr>
		<tr>
			<td>地址：</td>
			<td>
				<input class="easyui-textbox" type="text" name="address" data-options="required:true"></input>
			</td>
		</tr>
		<tr>
			<td>上级渠道：</td>
			<td>
				<input class="easyui-textbox" type="text" name="parentid"></input>
			</td>
		</tr>
		<tr>
			<td>渠道状态：</td>
			<td>
				<input class="easyui-textbox" type="text" name="chanst" data-options="required:true"></input>
			</td>
		</tr>
	</table>
</form>