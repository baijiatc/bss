<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<table class="easyui-datagrid"></table>
<div id="div_syslog" style="padding:0 0 0 50px;"></div>
<!-- javascript部分 -->
 <script>
$(function(){
	var options={
		columns:[[
          {field:'id',title: 'ID',align: 'center',hidden:'true'},
          {field:'logtype',title: '日志类型',align: 'center',width: 200},
          {field:'operator',title: '操作人',align: 'center',width: 200},
          {field:'privid',title: '操作内容',align: 'center',width: 200},
          {field:'createtime',title: '记录时间',align: 'center',width: 200},
         
		]]
	};
	//构建datagrid，并填充数据
	var dataGrid = new BSS.DataGrid('.easyui-datagrid');
	SYSLOG  = new BSS.Dialog('#div_syslog');
	dataGrid.build(options,{code:21004});

})
</script>