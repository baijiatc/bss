<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<form id="frm_motidx" method="post">
	<table cellpadding="5">
		<tr>
			<td>指标名称：</td>
			<td>
				<input id="id_idxname" class="easyui-textbox" type="text" name="idxname" data-options="required:true"></input></input>
				<input id="id_id" class="easyui-textbox" type="hidden" name="id"></input>
			</td>
		</tr>
		<tr>
			<td>数据源表：</td>
			<td><input id="id_tblid" class="easyui-textbox" type="text" name="tblid" data-options="required:false"></input></td>
		</tr>
		<tr>
			<td>数据源列：</td>
			<td><input id="id_colid" class="easyui-textbox" type="text" name="colid" data-options="required:false"></input></td>
		</tr>
		<tr>
			<td>业务类型：</td>
			<td><input id="id_biztype" class="easyui-textbox" type="text" name="biztype" data-options="required:true"></input></td>
		</tr>
	</table>
</form>
<script>
// function initIdxEidtPage(){
	BSS.dispatch({code:22006,data:[{id:'${id}'}]},function(resp){
		if(resp.code == 0){
			BSS.json2form('#frm_motidx',resp.data[0]);
			
			MOTIDXDIALOG.ok = function(){
				var idx = BSS.form2json('#frm_motidx');
				BSS.dispatch({code:22008,data:[idx]},function(){
					BSS.alert('保存成功！');
				},function(){});
			};
		}else{
			MOTIDXDIALOG.ok = function(){};
			BSS.warning(resp.message);
		}
	});
// }
</script>