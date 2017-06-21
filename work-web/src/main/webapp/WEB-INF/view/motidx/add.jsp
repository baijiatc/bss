<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<form id="frm_motidx" method="post">
	<table cellpadding="5">
		<tr>
			<td>指标名称：</td>
			<td><input class="easyui-textbox" type="text" name="idxname" data-options="required:true"></input></td>
		</tr>
		<tr>
			<td>数据源表：</td>
			<td><input class="easyui-textbox" type="text" name="tblid" data-options="required:false"></input></td>
		</tr>
		<tr>
			<td>数据源列：</td>
			<td><input class="easyui-textbox" type="text" name="colid" data-options="required:false"></input></td>
		</tr>
		<tr>
			<td>业务类型：</td>
			<td><input class="easyui-textbox" type="text" name="biztype" data-options="required:true"></input></td>
		</tr>
	</table>
</form>
<script>

// function setOk(){
	MOTIDXDIALOG.ok = function(){
		var idx = BSS.form2json('#frm_motidx');
		BSS.dispatch({code:22005,data:[idx]},function(resp){
			if(resp.code == 0){
				BSS.info('保存成功');
			}else{
				BSS.warning(resp.message);
			}
		},function(resp){
			console.log(JSON.stringify(resp));
		});
	}
// }
</script>