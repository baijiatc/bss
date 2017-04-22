<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<table id="tbl_sku_datagrid" class="easyui-datagrid"></table>
<div id="div_skuadd" style="padding:0 0 0 50px;"></div>
<!-- javascript部分 -->
<script>
$(function(){
	var options={
		columns:[[
          {field:'id',title: 'ID',align: 'center',hidden:'true'},
          {field:'skuname',title: '商品SKU名称',align: 'center',width: 100},
          {field:'barcode',title: '条形码',align: 'center',width: 100},
          {field:'price',title: '商品SKU价格',align: 'center',width: 100},
          {field:'mktprice',title: '市场价格',align: 'center',width: 100},
          {field:'fromsys',title: '来源平台',align: 'center',width: 100},
          {field:'sourceid',title: '平台编码',align: 'center',width: 100},
          {field:'productid',title: '产品',align: 'center',width: 100},
		]]
	};
	//构建datagrid，并填充数据
	var dataGrid = new BSS.DataGrid('#tbl_sku_datagrid');
	SKUDIALOG = new BSS.Dialog('#div_skuadd');
	dataGrid.build(options,{code:14018});
	//设置新建事件
	dataGrid.create = function(){
		SKUDIALOG.init({href:'sku/add.html',width:400});
	};
	//设置编辑事件
	dataGrid.edit = function(){
		var row=this.getSelectedRow();
		if(BSS.Helper.isNull(row)){
			BSS.warning('请选择要编辑的数据行');
			return;
		}
		var id = row['id'];
		SKUDIALOG.init({href:'sku/'+id+'.html',width:400});
	};
})
</script>