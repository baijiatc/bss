<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<form id="frm_acty" method="post">
	<table cellpadding="8">
		<tr>
			<td>活动名称：</td>
			<td>
				<input class="easyui-textbox" type="text" name="actname" data-options="required:true"></input>
			</td>
		</tr>
		<tr>
			<td>活动类型：</td>
			<td><input class="easyui-textbox" type="text" name="acttype" data-options="required:false"></input></td>
		</tr>
		<tr>
			<td>活动类别：</td>
			<td><input class="easyui-textbox" type="text" name="actcat" data-options="required:false"></input></td>
		</tr>
		<tr>
			<td>开始时间：</td>
			<td><input class="easyui-textbox" type="text" name="begindt" data-options="required:false"></input></td>
		</tr>
		<tr>
			<td>结束时间：</td>
			<td><input class="easyui-textbox" type="text" name="enddt" data-options="required:false"></input></td>
		</tr>
		<tr>
			<td>活动详情：</td>
			<td><input class="easyui-textbox" type="text" name="actdesc" data-options="required:true"></input></td>
		</tr>
		<tr>
			<td>创建人：</td>
			<td><input class="easyui-textbox" type="text" name="creator" data-options="required:true"></input></td>
		</tr>
		<tr>
			<td>状态：</td>
			<td><input class="easyui-textbox" type="text" name="actst" data-options="required:true"></input></td>
		</tr>
	</table>
</form>
<script>
ACTYDIALOG.ok = function(){
	var acty = BSS.form2json('#frm_acty');
	BSS.dispatch({code:19001,data:[acty]},function(){
		BSS.alert();;
	},function(){});
}
</script>