<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<table class="easyui-datagrid"></table>
<!-- javascript部分 -->
<script language="javascript" src="js/easyui/jquery.easyui.min.js" charset="utf-8"></script>
<script language="javascript" src="js/easyui/locale/easyui-lang-zh_CN.js" charset="utf-8"></script>
<script>
$(function(){
	var options={
		columns:[[
          {field:'username',title: '用户名',align: 'center',width: 300},
          {field:'password',title: '密码',align: 'center',width: 300}
		]]
	};
	BSS.DataGrid.build('.easyui-datagrid',options,{code:10001,data:[{username:'abc',password:'123'}]});
})
</script>