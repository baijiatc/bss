<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<table id="tbl_supplier_datagrid" class="easyui-datagrid"></table>
<div id="div_supplieradd" style="padding:0 0 0 50px;"></div>
<!-- javascript部分 -->
<script language="javascript" src="js/easyui/jquery.easyui.min.js" charset="utf-8"></script>
<script language="javascript" src="js/easyui/locale/easyui-lang-zh_CN.js" charset="utf-8"></script>
<script>
$(function(){
	var options={
		columns:[[
          {field:'suppid',title: 'ID',align: 'center',hidden:'true'},
          {field:'suppname',title: '供应商名称',align: 'center',width: 200},
          {field:'supplv',title: '供应商级别',align: 'center',hidden:'true'},
          {field:'supplvStr',title: '供应商级别',align: 'center',width: 200},
          {field:'contact',title: '联系人',align: 'center',width: 200},
          {field:'mobile',title: '手机',align: 'center',width: 200},
          {field:'telephone',title: '电话',align: 'center',width: 200},
          {field:'address',title: '联系地址',align: 'center',width: 200},
          {field:'isopenshop',title: '是否开店',align: 'center',hidden:'true'},
          {field:'isopenshopStr',title: '是否开店',align: 'center',width: 200},
		]]
	};
	//构建datagrid，并填充数据
	var dataGrid = new BSS.DataGrid('#tbl_supplier_datagrid');
	SUPPLIERDIALOG = new BSS.Dialog('#div_supplieradd');
	dataGrid.build(options,{code:13003});
	//设置新建事件
	dataGrid.create = function(){
		SUPPLIERDIALOG.init({href:'supp/add.html',width:400});
	};
	//设置编辑事件
	dataGrid.edit = function(){
		var row=this.getSelectedRow();
		if(BSS.Helper.isNull(row)){
			BSS.warning('请选择要编辑的数据行');
			return;
		}
		var suppid = row['suppid'];
		SUPPLIERDIALOG.init({href:'supp/'+suppid+'.html',width:400});
	};
})
</script>