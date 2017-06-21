<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<form id="frm_idx" method="post">
	<table cellpadding="5">
		<tr>
			<td>指标代码：</td>
			<td>
				<input id="id_idxcode" class="easyui-textbox" type="text" name="idxcode" data-options="required:true"></input>
				<input id="id_id" class="easyui-textbox" type="hidden" name="id"></input>
			</td>
		</tr>
		<tr>
			<td>指标名称：</td>
			<td><input id="id_idxname" class="easyui-textbox" type="text" name="idxname" data-options="required:true"></input></td>
		</tr>
		<tr>
			<td>计算顺序：</td>
			<td><input id="id_idxorder" class="easyui-textbox" type="text" name="idxorder" data-options="required:true"></input></td>
		</tr>
		<tr>
			<td>指标类型：</td>
			<td><input id="id_idxtype" class="easyui-textbox" type="text" name="idxtype" data-options="required:true"></input></td>
		</tr>
		<tr>
			<td>适用范围：</td>
			<td><input id="id_idxscope" class="easyui-textbox" type="text" name="idxscope" data-options="required:false"></input></td>
		</tr>
		<tr>
			<td>计算公式：</td>
			<td><input id="id_idxformula" class="easyui-textbox" type="text" name="idxformula" data-options="required:false"></input></td>
		</tr>
		<tr>
			<td>是否显示：</td>
			<td><input id="cbx_isdisplay" class="easyui-textbox" type="text" name="isdisplay" data-options="required:true"></input></td>
		</tr>
		<tr>
			<td>生效日期：</td>
			<td><input id="id_validdt" class="easyui-textbox" type="text" name="validdt" data-options="formatter:dateFormatter,parser:liveparser,required:true"></input></td>
		</tr>
		<tr>
			<td>失效日期：</td>
			<td><input id="id_invaliddt" class="easyui-textbox" type="text" name="invaliddt" data-options="formatter:dateFormatter,parser:liveparser,required:true"></input></td>
		</tr>
		<tr>
			<td>创建人：</td>
			<td><input id="id_creator" class="easyui-textbox" type="text" name="creator" data-options="required:false"></input></td>
		</tr>
	</table>
</form>
<script>
var isdisplayCombox = new BSS.Combox('#cbx_isdisplay');
isdisplayCombox.fromDict('DICT_ISDISPLAY',function(){
	initIdxEidtPage();
});
$('#id_validdt').datebox({
    required:true
});
$('#id_invaliddt').datebox({
    required:true
});
function dateFormatter(date){
	var y = date.getFullYear();
	var m = date.getMonth()+1;
	var d = date.getDate();
	return y+(m<10?('0'+m):m)+(d<10?('0'+d):d);
}
function liveparser(s){
	s=''+s;
	if (!s) return new Date();
	var y = s.substring(0,4);
	var m =s.substring(4,6);
	var d = s.substring(6,8);
	if (!isNaN(y) && !isNaN(m) && !isNaN(d)){
		return new Date(y,m-1,d);
	} else {
		return new Date();
	}
}
function initIdxEidtPage(){
	BSS.dispatch({code:18010,data:[{id:'${id}'}]},function(resp){
		if(resp.code == 0){
			BSS.json2form('#frm_idx',resp.data[0]);
			
			IDXDIALOG.ok = function(){
				var idx = BSS.form2json('#frm_idx');
				BSS.dispatch({code:18003,data:[idx]},function(){
					BSS.alert('保存成功！');
				},function(){});
			};
		}else{
			IDXDIALOG.ok = function(){};
			BSS.warning(resp.message);
		}
	});
}
</script>