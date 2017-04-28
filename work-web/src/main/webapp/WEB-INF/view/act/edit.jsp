<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<form id="frm_acty" method="post">
	<table cellpadding="8">
		<tr>
			<td>活动名称：</td>
			<td>
				<input  id="id_actname" class="easyui-textbox" type="text" name="actname" data-options="required:true"></input>
				<input  id="id_id"  class="easyui-textbox" type="text" name="id" data-options="required:true"></input>
			</td>
		</tr>
		<tr>
			<td>活动类型：</td>
			<td><input id="cbx_acttype"  class="easyui-textbox" type="text" name="acttype" data-options="required:false"></input></td>
		</tr>
		<tr>
			<td>活动类别：</td>
			<td><input  id="cbx_actcat" class="easyui-textbox" type="text" name="actcat" data-options="required:false"></input></td>
		</tr>
		<tr>
			<td>开始时间：</td>
			<td><input  id="id_begindt" class="easyui-textbox" type="text" name="begindt" data-options="required:false"></input></td>
		</tr>
		<tr>
			<td>结束时间：</td>
			<td><input  id="id_enddt" class="easyui-textbox" type="text" name="enddt" data-options="required:false"></input></td>
		</tr>
		<tr>
			<td>活动详情：</td>
			<td><input id="id_actdesc"  class="easyui-textbox" type="text" name="actdesc" data-options="required:true"></input></td>
		</tr>
		<tr>
			<td>创建人：</td>
			<td><input  id="id_creator" class="easyui-textbox" type="text" name="creator" data-options="required:true"></input></td>
		</tr>
		<tr>
			<td>状态：</td>
			<td><input id="cbx_actst"  class="easyui-textbox" type="text" name="actst" data-options="required:true"></input></td>
		</tr>
	</table>
</form>
<script>
var acttypeCombox = new BSS.Combox('#cbx_acttype');
acttypeCombox.fromDict('DICT_ACTTYPE',function(){
	initActEditPage();}); 


var actcatCombox = new BSS.Combox('#cbx_actcat');
actcatCombox.fromDict('DICT_ACTCAT',function(){
	initActEditPage();}); 


var actstCombox = new BSS.Combox('#cbx_actst');
actstCombox.fromDict('DICT_ACTST',function(){
	initActEditPage();}); 

function initActEditPage(){
BSS.dispatch({code:19090,data:[{id:'${id}'}]},function(resp){
	if(resp.code == 0){
		BSS.json2form('#frm_acty',resp.data[0]);
		
		ACTYDIALOGROLEDIALOG.ok = function(){
			var acty = BSS.form2json('#frm_acty');
			BSS.dispatch({code:20008,data:[acty]},function(){
				BSS.alert('保存成功！');
			},function(){});
		};
	}else{
		ACTYDIALOG.ok = function(){};
		BSS.warning(resp.message);
	}
})
};
</script>