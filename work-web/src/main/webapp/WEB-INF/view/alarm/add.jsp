<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<form id="frm_alarm" method="post">
	<table cellpadding="5">
		<tr>
			<td>预警分类：</td>
			<td>
				<input id="cbx_alarmtype" class="easyui-combobox" type="text" name="factcatid" data-options="required:true"></input>
			</td>
		</tr>
		<tr>
			<td>预警对象：</td>
			<td><input class="easyui-combobox" type="text" name="objid" data-options="required:true"></input></td>
		</tr>
		<tr>
			<td>因子：</td>
			<td><input id="cbx_factor" class="easyui-combobox" type="text" name="factorid" data-options="required:true"></input></td>
		</tr>
		<tr>
			<td>因子值：</td>
			<td><input class="easyui-textbox" type="text" name="factvalueid" data-options="required:true"></input></td>
		</tr>
		<tr>
			<td>因子值单位：</td>
			<td><input id="cbx_factunit" class="easyui-combobox" type="text" name="factunit" data-options="required:true"></input></td>
		</tr>
		<tr>
			<td>状态：</td>
			<td><input id="cbx_alarmst" class="easyui-combobox" type="text" name="alarmst" data-options="required:true"></input></td>
		</tr>
	</table>
</form>
<script>
var alarmTypeCombox = new BSS.Combox('#cbx_alarmtype');
alarmTypeCombox.fromDict('DICT_ALARMTYPE');
var factunitCombox = new BSS.Combox('#cbx_factunit');
factunitCombox.fromDict('DICT_FACTUNIT');
var alarmStCombox = new BSS.Combox('#cbx_alarmst');
alarmStCombox.fromDict('DICT_ALARMST');

ALARMDIALOG.loadFactor('#cbx_factor');
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