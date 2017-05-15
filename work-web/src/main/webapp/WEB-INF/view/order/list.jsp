<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<table id="tbl_order_datagrid" class="easyui-datagrid"></table>
<table id="tbl_orderdet"></table>
<!-- javascript部分 -->
<script>
$(function(){
	var orderOpts={
		height:240,
		columns:[[
          {field:'id',title: 'ID',align: 'center',hidden:'true'},
          {field:'orderno',title: '订单号',align: 'center',width: 100},
          {field:'orderst',title: '订单状态',align: 'center',hidden:'true'},
          {field:'orderStr',title: '订单状态',align: 'center',width: 100},
          {field:'fromsys',title: '订单来源ID',align: 'center',hidden:'true'},
          {field:'fromsyStr',title: '订单来源',align: 'center',width: 100},
          {field:'totalfee',title: '订单金额',align: 'center',width: 100},
          {field:'payment',title: '实付金额',align: 'center',width: 100},
          {field:'totalpay',title: '应付金额',align: 'center',width: 100},
          {field:'discountfee',title: '优惠金额',align: 'center',width: 100},
          {field:'pointsfee',title: '抵扣金额',align: 'center',width: 100},
          {field:'platformpay',title: '承担金额',align: 'center',width: 100},
          {field:'refundfee',title: '退款金额',align: 'center',width: 100},
          {field:'ordertype',title: '订单类型',align: 'center',hidden:'true'},
          {field:'ordertypeStr',title: '订单类型',align: 'center',width: 100},
          {field:'buyer',title: '下单人',align: 'center',width: 100},
          {field:'saler',title: '销售商户',align: 'center',width: 100},
          {field:'paytype',title: '支付方式',align: 'center',hidden:'true'},
          {field:'paytypeStr',title: '支付方式',align: 'center',width: 100},
          {field:'orderdt',title: '下单日期',align: 'center',width: 150,formatter:BSS.formatTime},
          {field:'cstmcontactid',title: '收货人',align: 'center',width: 100},
		]]
	};
	var orderdetOpts={
			height:240,
			columns:[[
	          {field:'id',title: 'ID',align: 'center',hidden:'true'},
	          {field:'skuid',title: 'SKU值',align: 'center',hidden:'true'},
	          {field:'skuname',title: 'SKU',align: 'center',width: 100},
	          {field:'price',title: '商品价格',align: 'center',width: 100},
	          {field:'payment',title: '实付金额',align: 'center',width: 100},
	          {field:'totalpay',title: '应付金额',align: 'center',width: 100},
	          {field:'discountfee',title: '优惠金额',align: 'center',width: 100},
	          {field:'pointsfee',title: '抵扣金额',align: 'center',width: 100},
	          {field:'platformpay',title: '承担金额',align: 'center',width: 100},
	          {field:'refundfee',title: '退款金额',align: 'center',width: 100},
	          {field:'num',title: '数量',align: 'center',width: 100},
			]]
		};
	//构建datagrid，并填充数据
	var orderGrid = new BSS.DataGrid('#tbl_order_datagrid');
	orderGrid.toolbar=[{text:'<b>订单信息</b>',iconCls:'icon-tip'}]
	orderGrid.build(orderOpts,{code:16001});
	
	var orderdetGrid = new BSS.DataGrid('#tbl_orderdet');
	orderdetGrid.toolbar=[{text:'<b>订单明细信息</b>',iconCls:'icon-tip'}]
	orderdetGrid.init(orderdetOpts);
	
	orderGrid.clickRow = function(ridx,rdata){
	var orderid = rdata['id'];
	orderdetGrid.load({code:30004,data:[{orderid:orderid}]});
	};
})
</script>