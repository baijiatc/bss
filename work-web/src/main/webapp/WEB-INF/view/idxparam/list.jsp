<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<table id="tbl_idxparam_datagrid" class="easyui-datagrid"></table>
<div id="div_idxparamadd" style="padding:0 0 0 50px;"></div>
<!-- javascript部分 -->
<script language="javascript" src="js/easyui/jquery.easyui.min.js" charset="utf-8"></script>
<script language="javascript" src="js/easyui/locale/easyui-lang-zh_CN.js" charset="utf-8"></script>
<script>
$(function(){
	var options={
		columns:[[
          {field:'id',title: 'ID',align: 'center',hidden:'true'},
          {field:'parmcode',title: '参数代码',align: 'center',width: 100},
          {field:'parmname',title: '参数名称',align: 'center',width: 100},
          {field:'parmtype',title: '参数类型',align: 'center',width: 100},
          {field:'defaultvalue',title: '默认值',align: 'center',width: 100},
          {field:'creator',title: '创建人',align: 'center',width: 100},
		]]
	};
	//构建datagrid，并填充数据
	var dataGrid = new BSS.DataGrid('#tbl_idxparam_datagrid');
	IDXPARAMDIALOG = new BSS.Dialog('#div_idxparamadd');
	dataGrid.build(options,{code:18006});
	//设置新建事件
	dataGrid.create = function(){
		IDXPARAMDIALOG.init({href:'idxparam/add.html',width:400});
	};
	//设置编辑事件
	dataGrid.edit = function(){
		var row=this.getSelectedRow();
		if(BSS.Helper.isNull(row)){
			BSS.warning('请选择要编辑的数据行');
			return;
		}
		var id = row['id'];
		IDXPARAMDIALOG.init({href:'idxparam/'+id+'.html',width:400});
	};
})
</script>