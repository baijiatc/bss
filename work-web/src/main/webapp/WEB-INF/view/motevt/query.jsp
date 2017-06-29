<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script>
var bizCombox = new BSS.Combox('#motevt_biztype');
var statsCombox = new BSS.Combox('#motevt_stats');
	bizCombox.fromDict('DICT_BIZTYPE',function(){
		statsCombox.fromDict('DICT_EVTSTATS',function(){
		setOk()
	});
});
function setOk(){
	MOTEVTQUERYDIALOG.ok = function(){
			var biztype=bizCombox.getValue();
			var evtstats=statsCombox.getValue();
			var evtname=$('#motevt_name').val()
			MOTEVTGRID.load({code:22013,data:[{evtname:evtname,biztype:biztype,evtstats:evtstats}]},function(resp){
				if(resp.code == 0){
					BSS.info('查询成功');
				}else{
					BSS.warning(resp.message);
				}
			},function(resp){
				console.log(JSON.stringify(resp));
			});
		}
}
</script>
<form>
	<table style="text-align:center">
		<tr>
			<td>事件名称</td>
			<td><input id="motevt_name" type="text" class="easyui-textbox" style="width:200px;"/></td>
		</tr>
		<tr>
			<td>业务类型</td>
			<td><input id="motevt_biztype" type="text" class="easyui-combobox" style="width:200px;"/></td>
		</tr>
		<tr>
			<td >事件状态</td>
			<td><input id="motevt_stats" type="text" class="easyui-combobox" style="width:200px;"/></td>
		</tr>
	</table>
</form>