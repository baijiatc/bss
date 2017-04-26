<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<table id="tbl_idx_datagrid" class="easyui-datagrid"></table>
<div id="div_idxadd" style="padding:0 0 0 50px;"></div>
<!-- javascript部分 -->
<script language="javascript" src="js/easyui/jquery.easyui.min.js" charset="utf-8"></script>
<script language="javascript" src="js/easyui/locale/easyui-lang-zh_CN.js" charset="utf-8"></script>
<script>
$(function(){
	var options={
		columns:[[
          {field:'id',title: 'ID',align: 'center',hidden:'true'},
          {field:'idxcode',title: '指标代码',align: 'center',width: 100},
          {field:'idxname',title: '指标名称',align: 'center',width: 100},
          {field:'idxorder',title: '计算顺序',align: 'center',width: 100},
          {field:'idxtype',title: '指标类型',align: 'center',width: 100},
          {field:'idxscope',title: '适用范围',align: 'center',width: 100},
          {field:'idxformula',title: '计算公式',align: 'center',width: 100},
          {field:'isdisplay',title: '是否显示',align: 'center',width: 100},
          {field:'isdisplayStr',title: '是否显示',align: 'center',width: 100},
          {field:'validdt',title: '生效日期',align: 'center',width: 100},
          {field:'invaliddt',title: '失效日期',align: 'center',width: 100},
          {field:'creator',title: '创建人',align: 'center',width: 100},
		]]
	};
	//构建datagrid，并填充数据
	var dataGrid = new BSS.DataGrid('#tbl_idx_datagrid');
	IDXDIALOG = new BSS.Dialog('#div_idxadd');
	dataGrid.build(options,{code:18002});
	//设置新建事件
	dataGrid.create = function(){
		IDXDIALOG.init({href:'idx/add.html',width:400});
	};
	//设置编辑事件
	dataGrid.edit = function(){
		var row=this.getSelectedRow();
		if(BSS.Helper.isNull(row)){
			BSS.warning('请选择要编辑的数据行');
			return;
		}
		var id = row['id'];
		IDXDIALOG.init({href:'idx/'+id+'.html',width:400});
	};
})
</script>