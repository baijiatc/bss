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
			<td><input id="cbx_isdisplay" class="easyui-textbox" type="text" name="isdisplay" data-options="required:true"></input></td>
		</tr>
		<tr>
			<td>生效日期：</td>
			<td><input id="cbx_validdt" class="easyui-textbox" type="text" name="validdt" data-options="formatter:dateFormatter,parser:myparser,required:true"></input></td>
		</tr>
		<tr>
			<td>失效日期：</td>
			<td><input id="cbx_invaliddt" class="easyui-textbox" type="text" name="invaliddt" data-options="formatter:dateFormatter,parser:myparser,required:true"></input></td>
		</tr>
		<tr>
			<td>创建人：</td>
			<td><input class="easyui-textbox" type="text" name="creator" data-options="required:false"></input></td>
		</tr>
	</table>
</form>
<script>
var isdisplayCombox = new BSS.Combox('#cbx_isdisplay');
isdisplayCombox.fromDict('DICT_ISDISPLAY',function(){
	setOk();
});
$('#cbx_validdt').datebox({
    required:true
});
$('#cbx_invaliddt').datebox({
    required:true
});
function dateFormatter(date){
	var y = date.getFullYear();
	var m = date.getMonth()+1;
	var d = date.getDate();
	return y+(m<10?('0'+m):m)+(d<10?('0'+d):d);
}
function myparser(s){
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
function setOk(){
	IDXDIALOG.ok = function(){
		var idx = BSS.form2json('#frm_idx');
		BSS.dispatch({code:18001,data:[idx]},function(resp){
			if(resp.code == 0){
				BSS.info('保存成功');
			}else{
				BSS.warning(resp.message);
			}
		},function(resp){
			console.log(JSON.stringify(resp));
		});
	}
}
</script>