<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<table class="easyui-datagrid"></table>
<div id="div_customer" style="padding:0 0 0 50px;"></div>
<!-- javascript部分 -->
 <script>
$(function(){
	var options={
		columns:[[
          {field:'cstmid',title: 'ID',align: 'center',hidden:'true'},
          {field:'cstmname',title: '会员姓名',align: 'center',width: 200},
          {field:'mobile',title: '手机',align: 'center',width: 200},
          {field:'email',title: '电子邮件',align: 'center',width: 200},
          {field:'cstmlevel',title: '会员级别',align: 'center',width: 200},
          {field:'regtime',title: '注册日期',align: 'center',width: 200},
          {field:'cstmst',title: '状态',align: 'center',width: 200}
		]]
	};
	//构建datagrid，并填充数据
	var dataGrid = new BSS.DataGrid('.easyui-datagrid');
	CUSTOMER  = new BSS.Dialog('#div_customer');
	dataGrid.build(options,{code:12002});

})
</script>