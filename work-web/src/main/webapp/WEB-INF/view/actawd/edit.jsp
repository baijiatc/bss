<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<form id="frm_actawd" method="post">
	<table cellpadding="3">
			<tr>
			<td>活动名称：</td>
			<td>
				<input id="id_actid" class="easyui-textbox" type="text" name="actid" data-options="required:true"></input>
			    <input id="id_id" class="easyui-textbox" type="hidden" name="id" data-options="required:true"></input>
			</td>
		</tr>
		<tr>
			<td>奖励类型：</td>
			<td><input  id="id_awardtype" class="easyui-textbox" type="text" name="awardtype" data-options="required:false"></input></td>
		</tr>
		<tr>
			<td>奖励对象：</td>
			<td><input  id="id_awobj" class="easyui-textbox" type="text" name="awobj" data-options="required:false"></input></td>
		</tr>
	 
	</table>
</form>
<script>
BSS.dispatch({code:19013,data:[{id:'${id}'}]},function(resp){
	BSS.json2form('#frm_actawd',resp.data[0]);
});
ACTWARDDIALOG.ok = function(){
	var actawd = BSS.form2json('#frm_actawd');
	BSS.dispatch({code:19008,data:[actawd]},function(){
		BSS.alert('保存成功！');
	},function(){});	
}
</script>