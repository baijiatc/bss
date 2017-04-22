<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<form id="frm_alarm" method="post">
	<table cellpadding="5">
		<tr>
			<td>预警类别：</td>
			<td>
				<input class="easyui-combobox" type="text" name="factcatid" data-options="required:true"></input>
				<input class="easyui-textbox" type="hidden" name="alarmid" data-options="required:true"></input>
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

BSS.dispatch({code:15006,data:[{alarmid:'${alarmid}'}]},function(resp){
	if(resp.code == 0){
		BSS.json2form('#frm_alarm',resp.data[0]);
		
		ALARMDIALOG.ok = function(){
			var alarm = BSS.form2json('#frm_alarm');
			BSS.dispatch({code:15005,data:[alarm]},function(){
				BSS.alert('保存成功！');
			},function(){});
		};
	}else{
		ALARMDIALOG.ok = function(){};
		BSS.warning(resp.message);
	}
});
</script>