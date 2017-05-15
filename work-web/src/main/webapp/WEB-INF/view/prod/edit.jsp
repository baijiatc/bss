<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<form id="frm_prod" method="post">
	<table cellpadding="5">
			<tr>
			<td>源标识：</td>
			<td>
				<input id="id_sourceid"  class="easyui-textbox" type="text" name="sourceid" data-options="required:true"></input>
				<input id="id_id" class="easyui-textbox" type="hidden" name="id" data-options="required:true"></input>
			</td>
		</tr>
		<tr>
			<td>来源平台：</td>
			<td><input  id="cbx_fromsys" class="easyui-textbox" type="text" name="fromsys" data-options="required:false"></input></td>
		</tr>
		<tr>
			<td>名称：</td>
			<td><input id="id_prodname"  class="easyui-textbox" type="text" name="prodname" data-options="required:false"></input></td>
		</tr>
			<tr>
			<td>类别：</td>
			<td><input  id="cbx_catid" class="easyui-textbox" type="text" name="catid" data-options="required:false"></input></td>
		</tr>
		
		<tr>
			<td>品牌：</td>
			<td><input id="cbx_brandid"  class="easyui-textbox" type="text" name="brandid" data-options="required:true"></input></td>
		</tr>
		<tr>
			<td>商品详情：</td>
			<td><input id="id_description" class="easyui-textbox" type="text" name="description" data-options="required:true"></input></td>
		</tr>
		 
	</table>
</form>
<script>

var fromsysCombox = new BSS.Combox('#cbx_fromsys');
var catCombox = new BSS.Combox('#cbx_catid');
var brandCombox = new BSS.Combox('#cbx_brandid');
fromsysCombox.fromDict('DICT_FROMSYS',function(){
	PRODDIALOG.loadCatName('#cbx_catid',function(){
		PRODDIALOG.loadBrandName('#cbx_brandid',function(){
			initProdEditPage();
    });
   });
})
function initProdEditPage(){
  BSS.dispatch({code:14092,data:[{id:'${id}'}]},function(resp){
	  BSS.json2form('#frm_prod',resp.data[0]);
   });
  PRODDIALOG.ok = function(){
	var prod = BSS.form2json('#frm_prod');
	BSS.dispatch({code:14014,data:[prod]},function(){
		BSS.alert('保存成功！');
	},function(){});	
 }
}
</script>