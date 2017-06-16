<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script>
BSS.dispatch({code:15012},function(resp){
	if(resp.code == 0){
		var datas = resp.data;
		var skuCombox = new BSS.Combox('#stock_sku');
		var options = {valueField:'sourceid',textField:'skuname',data:datas,panelHeight:150};
		skuCombox.init(options);
		STOCKQUERYDIALOG.ok=function(){
			var skuid=skuCombox.getValue();
			STOCKGRID.load({code:15001,data:[{skuid:skuid}]});
		}
	}else{
		BSS.warning(resp.message);
	}
},function(resp){});
</script>
<form>
	<table style="text-align:center">
		<tr style="display:none;">
			<td>来源系统</td>
			<td><input id="stock_fromsys" type="text" class="easyui-combobox" style="width:200px;"/></td>
		</tr>
		<tr>
			<td>商品SKU</td>
			<td><input id="stock_sku" type="text" class="easyui-combobox" style="width:200px;"/></td>
		</tr>
	</table>
</form>