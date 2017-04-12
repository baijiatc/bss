<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<form id="frm_idx" method="post">
	<table cellpadding="5">
		<tr>
			<td>指标代码：</td>
			<td>
				<input class="easyui-textbox" type="text" name="idxcode" data-options="required:true"></input>
			</td>
		</tr>
		<tr>
			<td>指标名称：</td>
			<td><input class="easyui-textbox" type="text" name="idxname" data-options="required:true"></input></td>
		</tr>
		<tr>
			<td>计算顺序：</td>
			<td><input class="easyui-textbox" type="text" name="idxorder" data-options="required:true"></input></td>
		</tr>
		<tr>
			<td>指标类型：</td>
			<td><input class="easyui-textbox" type="text" name="idxtype" data-options="required:true"></input></td>
		</tr>
		<tr>
			<td>适用范围：</td>
			<td><input class="easyui-textbox" type="text" name="idxscope" data-options="required:false"></input></td>
		</tr>
		<tr>
			<td>计算公式：</td>
			<td><input class="easyui-textbox" type="text" name="idxformula" data-options="required:false"></input></td>
		</tr>
		<tr>
			<td>是否显示：</td>
			<td><input class="easyui-textbox" type="text" name="isdisplay" data-options="required:true"></input></td>
		</tr>
		<tr>
			<td>生效日期：</td>
			<td><input class="easyui-textbox" type="text" name="validdt" data-options="required:true"></input></td>
		</tr>
		<tr>
			<td>失效日期：</td>
			<td><input class="easyui-textbox" type="text" name="invaliddt" data-options="required:true"></input></td>
		</tr>
		<tr>
			<td>创建人：</td>
			<td><input class="easyui-textbox" type="text" name="creator" data-options="required:false"></input></td>
		</tr>
	</table>
</form>
<script>
IDXDIALOG.ok = function(){
	var idx = BSS.form2json('#frm_idx');
	BSS.dispatch({code:18001,data:[idx]},function(){
		BSS.alert();;
	},function(){});
}
</script>