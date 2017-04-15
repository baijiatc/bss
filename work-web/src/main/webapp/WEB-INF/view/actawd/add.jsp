<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<form id="frm_actawd" method="post">
	<table cellpadding="3">
		<tr>
			<td>活动名称：</td>
			<td>
				<input class="easyui-textbox" type="text" name="actid" data-options="required:true"></input>
			</td>
		</tr>
		<tr>
			<td>奖励类型：</td>
			<td><input class="easyui-textbox" type="text" name="awardtype" data-options="required:false"></input></td>
		</tr>
		<tr>
			<td>奖励对象：</td>
			<td><input class="easyui-textbox" type="text" name="awobj" data-options="required:false"></input></td>
		</tr>
	 
	</table>
</form>
<script>
ACTWARDDIALOG.ok = function(){
	var actawd = BSS.form2json('#frm_actawd');
	BSS.dispatch({code:19007,data:[actawd]},function(){
		BSS.alert("添加成功");;
	},function(){});
}
</script>