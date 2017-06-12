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
			<td><input id="cbx_acttype" class="easyui-combobox" type="text" name="acttype" data-options="required:false"></input></td>
		</tr>
		<tr>
			<td>活动类别：</td>
			<td><input id="cbx_actcat" class="easyui-combobox" type="text" name="actcat" data-options="required:false"></input></td>
		</tr>
		<tr>
			<td>开始时间：</td>
			<td><input class="easyui-datebox"   type="text" name="begindt" data-options="formatter:myformatter,parser:myparser,required:false"></input></td>
		</tr>
		<tr>
			<td>结束时间：</td>
			<td><input class="easyui-datebox" type="text" name="enddt" data-options="formatter:myformatter,parser:myparser,required:false"></input></td>
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
			<td><input id="cbx_actst" class="easyui-combobox" type="text" name="actst" data-options="required:true"></input></td>
		</tr>
	</table>
</form>  
<script>
var acttypeCombox = new BSS.Combox('#cbx_acttype');
acttypeCombox.fromDict('DICT_ACTTYPE',function(){
var actcatCombox = new BSS.Combox('#cbx_actcat');
actcatCombox.fromDict('DICT_ACTCAT',function(){
var actstCombox = new BSS.Combox('#cbx_actst');
actstCombox.fromDict('DICT_ACTST',function(){
	

	setOk();
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


function setOk(){
	ACTYDIALOG.ok = function(){
		var act = BSS.form2json('#frm_acty');
		BSS.dispatch({code:19001,data:[act]},function(resp){
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