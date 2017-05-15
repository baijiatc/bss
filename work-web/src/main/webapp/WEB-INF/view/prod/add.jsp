<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<form id="frm_prod" method="post">
	<table cellpadding="6">
		<tr>
			<td>源标识：</td>
			<td>
				<input class="easyui-textbox" type="text" name="sourceid" data-options="required:true"></input>
			</td>
		</tr>
		<tr>
			<td>来源平台：</td>
			<td><input  id="cbx_fromsys"  class="easyui-textbox" type="text" name="fromsys" data-options="required:false"></input></td>
		</tr>
		<tr>
			<td>名称：</td>
			<td><input class="easyui-textbox" type="text" name="prodname" data-options="required:false"></input></td>
		</tr>
			<tr>
			<td>类别：</td>
			<td><input  id="cbx_catid"  class="easyui-checkbox" type="text" name="catid" ></input></td>
		</tr>
		
		<tr>
			<td>品牌：</td>
			<td><input  id="cbx_brandid" class="easyui-checkbox" type="text" name="brandid" ></input></td>
		</tr>
		<tr>
			<td>商品详情：</td>
			<td><input class="easyui-textbox" type="text" name="description" data-options="required:true"></input></td>
		</tr>
		 
	</table>
</form>
<script>
var fromsysCombox = new BSS.Combox('#cbx_fromsys');
fromsysCombox.fromDict('DICT_FROMSYS',function(){
	PRODDIALOG.loadCatName('#cbx_catid',function(){
		PRODDIALOG.loadBrandName('#cbx_brandid',function(){
			setOk();
		});
	});
});

function setOk(){
	PRODDIALOG.ok = function(){
		var prod= BSS.form2json('#frm_prod');
		BSS.dispatch({code:14013,data:[prod]},function(resp){
			if(resp.code == 0){
				BSS.info('添加成功');
			}else{
				BSS.warning(resp.message);
			}
		},function(resp){
			console.log(JSON.stringify(resp));
		});
	}
}
</script>