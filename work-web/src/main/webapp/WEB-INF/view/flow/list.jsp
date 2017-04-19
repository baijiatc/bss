<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<table id="tbl_flow_datagrid" class="easyui-datagrid"></table>
<!-- javascript部分 -->
<script>
$(function(){
	var options={
		columns:[[
          {field:'id',title: 'ID',align: 'center',hidden:'true'},
          {field:'flowno',title: '流水号',align: 'center',width: 100},
          {field:'departid',title: '平台下机构',align: 'center',width: 100},
          {field:'fromsys',title: '来源平台',align: 'center',width: 100},
          {field:'total',title: '钱数',align: 'center',width: 100},
          {field:'account',title: '账号',align: 'center',width: 100},
          {field:'selftime',title: '流水原本时间',align: 'center',width: 100},
          {field:'direction',title: '方向',align: 'center',width: 100},
          {field:'createtime',title: '同步时间',align: 'center',width: 100},
		]]
	};
	//构建datagrid，并填充数据
	var flowGrid = new BSS.DataGrid('#tbl_flow_datagrid');
	flowGrid.toolbar=null;
	flowGrid.build(options,{code:16002});
})
</script>