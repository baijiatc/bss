<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<table id="tbl_actparam_datagrid" class="easyui-datagrid"></table>
<div id="div_actparamadd" style="padding:0 0 0 50px;"></div>
<!-- javascript部分 -->
<script language="javascript" src="js/easyui/jquery.easyui.min.js" charset="utf-8"></script>
<script language="javascript" src="js/easyui/locale/easyui-lang-zh_CN.js" charset="utf-8"></script>
<script>
$(function(){
	var options={
		columns:[[
          {field:'id',title: 'ID',align: 'center',hidden:'true'},
          {field:'actid',title: '活动名称',align: 'center',width: 200},
          {field:'paramtype',title: '参数类型',align: 'center',width: 200},
          {field:'paramvalue',title: '参数值',align: 'center',width: 200},
          {field:'creator',title: '创建人',align: 'center',width: 200},
         
		]]
	};
	//构建datagrid，并填充数据
	var actparamGrid = new BSS.DataGrid('#tbl_actparam_datagrid');
	ACTPARAMDIALOG = new BSS.Dialog('#div_actparamadd');
	actparamGrid.build(options,{code:19006});
	//设置新建事件
	actparamGrid.create = function(){
		ACTPARAMDIALOG.init({href:'actparam/add.html',width:400});
	};
	//设置编辑事件
	actparamGrid.edit = function(){
		var row=this.getSelectedRow();
		if(BSS.Helper.isNull(row)){
			BSS.warning('请选择要编辑的数据行');
			return;
		}
		var id = row['id'];
		ACTPARAMDIALOG.init({href:'actparam/'+id+'.html',width:400});
	};
})
</script>