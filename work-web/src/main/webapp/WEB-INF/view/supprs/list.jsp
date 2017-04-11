<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<table id="tbl_supprs_datagrid" class="easyui-datagrid"></table>
<div id="div_supprsadd" style="padding:0 0 0 50px;"></div>
<!-- javascript部分 -->
<script language="javascript" src="js/easyui/jquery.easyui.min.js" charset="utf-8"></script>
<script language="javascript" src="js/easyui/locale/easyui-lang-zh_CN.js" charset="utf-8"></script>
<script>
$(function(){
	var options={
		columns:[[
          {field:'staffobjid',title: 'ID',align: 'center',hidden:'true'},
          {field:'objid',title: '客户',align: 'center',width: 200},
          {field:'staffid',title: '员工',align: 'center',width: 200},
          {field:'cstype',title: '关系类型',align: 'center',width: 200},
          {field:'objtype',title: '对象类型',align: 'center',width: 200},
          {field:'createtime',title: '关系建立日期',align: 'center',width: 200},
		]]
	};
	//构建datagrid，并填充数据
	var dataGrid = new BSS.DataGrid('#tbl_supprs_datagrid');
	SUPPRSDIALOG = new BSS.Dialog('#div_supprsadd');
	dataGrid.build(options,{code:13006});
	//设置新建事件
	dataGrid.create = function(){
		SUPPRSDIALOG.init({href:'supprs/add.html',width:400});
	};
	//设置编辑事件
	dataGrid.edit = function(){
		var row=this.getSelectedRow();
		if(BSS.Helper.isNull(row)){
			BSS.warning('请选择要编辑的数据行');
			return;
		}
		var staffobjid = row['staffobjid'];
		SUPPRSDIALOG.init({href:'supprs/'+staffobjid+'.html',width:400});
	};
})
</script>