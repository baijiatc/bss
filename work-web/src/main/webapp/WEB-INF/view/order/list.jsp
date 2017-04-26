<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<table id="tbl_order_datagrid" class="easyui-datagrid"></table>
<!-- javascript部分 -->
<script>
$(function(){
	var options={
		columns:[[
          {field:'id',title: 'ID',align: 'center',hidden:'true'},
          {field:'orderno',title: '订单号',align: 'center',width: 100},
          {field:'orderst',title: '订单状态',align: 'center',hidden:'true'},
          {field:'orderStr',title: '订单状态',align: 'center',width: 100},
          {field:'fromsys',title: '订单来源',align: 'center',width: 100},
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
          {field:'orderdt',title: '下单日期',align: 'center',width: 100},
          {field:'cstmcontactid',title: '收货人',align: 'center',width: 100},
		]]
	};
	//构建datagrid，并填充数据
	var dataGrid = new BSS.DataGrid('#tbl_order_datagrid');
	dataGrid.toolbar=null;
	dataGrid.build(options,{code:16001});
})
</script>