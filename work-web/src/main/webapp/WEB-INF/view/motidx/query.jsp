<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script>
var bizCombox = new BSS.Combox('#motidx_biztype');
	bizCombox.fromDict('DICT_BIZTYPE',function(){
		setOk()
});
function setOk(){
	MOTIDXQUERYDIALOG.ok = function(){
			var bizid=bizCombox.getValue();
			var idxname=$('#motidx_name').val()
			MOTIDXGRID.load({code:22007,data:[{idxname:idxname,biztype:bizid}]},function(resp){
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
			<td>指标名称</td>
			<td><input id="motidx_name" type="text" class="easyui-textbox" style="width:200px;"/></td>
		</tr>
		<tr>
			<td>业务类型</td>
			<td><input id="motidx_biztype" type="text" class="easyui-combobox" style="width:200px;"/></td>
		</tr>
	</table>
</form>