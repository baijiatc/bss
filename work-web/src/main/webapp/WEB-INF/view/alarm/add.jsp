<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<form id="frm_alarm" method="post">
	<table cellpadding="5">
		<tr>
			<td>预警类别：</td>
			<td>
				<input class="easyui-combobox" type="text" name="factcatid" data-options="required:true"></input>
			</td>
		</tr>
		<tr>
			<td>预警对象：</td>
			<td><input class="easyui-combobox" type="text" name="objid" data-options="required:true"></input></td>
		</tr>
		<tr>
			<td>因子：</td>
			<td><input class="easyui-combobox" type="text" name="factorid" data-options="required:true"></input></td>
		</tr>
		<tr>
			<td>因子值：</td>
			<td><input class="easyui-textbox" type="text" name="factvalueid" data-options="required:true"></input></td>
		</tr>
		<tr>
			<td>状态：</td>
			<td><input class="easyui-combobox" type="text" name="alarmst" data-options="required:true"></input></td>
		</tr>
	</table>
</form>
<script>
var alarmStCombox = new BSS.Combox('#cbx_alarmst');
alarmStCombox.fromDict('DICT_ALARMST');

ALARMDIALOG.ok = function(){
	var alarm = BSS.form2json('#frm_alarm');
	BSS.dispatch({code:15003,data:[alarm]},function(resp){
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