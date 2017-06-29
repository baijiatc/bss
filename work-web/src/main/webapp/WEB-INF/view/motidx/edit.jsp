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
			<td><input id="cbx_tblid" class="easyui-textbox" type="text" name="tblid" data-options="required:false"></input></td>
		</tr>
		<tr>
			<td>数据源列：</td>
			<td><input id="cbx_colid" class="easyui-textbox" type="text" name="colid" data-options="required:false"></input></td>
		</tr>
		<tr>
			<td>业务类型：</td>
			<td><input id="cbx_biztype" class="easyui-textbox" type="text" name="biztype" data-options="required:true"></input></td>
		</tr>
	</table>
</form>
<script>
var tblCombox = new BSS.Combox('#cbx_tblid');
var colCombox = new BSS.Combox('#cbx_colid');
var bizCombox = new BSS.Combox('#cbx_biztype');
bizCombox.fromDict('DICT_BIZTYPE',function(){
	MOTIDXDIALOG.loadTblName('#cbx_tblid',function(){
		MOTIDXDIALOG.loadColName('#cbx_colid',function(){
			initIdxEidtPage()
		});
	});
});
function initIdxEidtPage(){
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
}
</script>