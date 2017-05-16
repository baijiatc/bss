<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<table id="tbl_stock"></table>
<table id="tbl_stockdet"></table>
<!-- javascript部分 -->
<script>
$(function(){
	var stockOpts={
		height:240,
		columns:[[
          {field:'stockid',title: 'ID',align: 'center',hidden:'true'},
          {field:'productid',title: '商品',align: 'center',width: 200},
          {field:'skuid',title: '商品SKUID',align: 'center',hidden:'true'},
          {field:'skuname',title: '商品SKU',align: 'center',width: 200},
          {field:'stocknum',title: '库存总数',align: 'center',width: 200},
          {field:'minstock',title: '最小库存数',align: 'center',width: 200}
		]]
	};
	var stockdetOpts={
		height:240,
		columns:[[
          {field:'stockdetid',title: 'ID',align: 'center',hidden:'true'},
          {field:'warehouse',title: '库房',align: 'center',width: 150},
          {field:'position',title: '库位',align: 'center',width: 150},
          {field:'batchno',title: '批次号',align: 'center',width: 200},
          {field:'indt',title: '入库日期',align: 'center',width: 200,formatter:BSS.formatTime},
          {field:'expirydt',title: '过期日期',align: 'center',width: 200,formatter:BSS.formatTime},
          {field:'stocknum',title: '库位库存数',align: 'center',width: 200}
		]]
	};
	var stockGrid = new BSS.DataGrid('#tbl_stock');
	stockGrid.toolbar=[{text:'<b>库存信息</b>',iconCls:'icon-tip'}]
	stockGrid.build(stockOpts,{code:15001});
	
	var stockdetGrid = new BSS.DataGrid('#tbl_stockdet');
	stockdetGrid.toolbar=[{text:'<b>库存明细信息</b>',iconCls:'icon-tip'}]
	stockdetGrid.init(stockdetOpts);
	
	stockGrid.clickRow = function(ridx,rdata){
		var stockid = rdata['stockid'];
		stockdetGrid.load({code:15004,data:[{stockid:stockid}]});
	};
	
})
</script>