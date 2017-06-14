<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<form id="frm_acty" method="post">
	<table cellpadding="8">
		<tr>
			<td>活动名称：</td>
			<td>
				<input  id="id_actname" class="easyui-textbox" type="text" name="actname" data-options="required:true"></input>
				<input  id="id_id"  class="easyui-textbox" type="hidden" name="id" data-options="required:true"></input>
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
			<td><input  id="id_begindt" class="easyui-datebox" type="text" name="begindt" data-options="formatter:myformatter,parser:myparser,required:false"></input></td>
		</tr>
		<tr>
			<td>结束时间：</td>
			<td><input  id="id_enddt" class="easyui-datebox" type="text" name="enddt" data-options="formatter:myformatter,parser:myparser,required:false"></input></td>
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
var actcatCombox = new BSS.Combox('#cbx_actcat');
var actstCombox = new BSS.Combox('#cbx_actst');
acttypeCombox.fromDict('DICT_ACTTYPE',function(){

actcatCombox.fromDict('DICT_ACTCAT',function(){
 
actstCombox.fromDict('DICT_ACTST',function(){
	initActEditPage();
	});  
}); 
});


function myformatter(date){
		var y = date.getFullYear();
			var m = date.getMonth()+1;
			var d = date.getDate();
			return y+(m<10?('0'+m):m)+(d<10?('0'+d):d);
		}


	function myparser(s){
		s=''+s;
		if (!s) return new Date();
		var y = s.substring(0,4);
		var m =s.substring(4,6);
		var d = s.substring(6,8);
	 
		if (!isNaN(y) && !isNaN( m) && !isNaN(d) ){
			return new Date(y,m-1,d );
		} else {
			return new Date();
		}
	}



function initActEditPage(){
BSS.dispatch({code:19090,data:[{id:'${id}'}]},function(resp){
	if(resp.code == 0){
		BSS.json2form('#frm_acty',resp.data[0]);
		
		ACTYDIALOG.ok = function(){
			var acty = BSS.form2json('#frm_acty');
			BSS.dispatch({code:19002,data:[acty]},function(){
				BSS.alert('保存成功！');
			},function(){});
		};
	}  
});
};
</script>