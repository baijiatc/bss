<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<table id="tbl_acty_datagrid" class="easyui-datagrid"></table>
<div id="div_actyadd" style="padding:0 0 0 50px;"></div>
<!-- javascript部分 -->
<script language="javascript" src="js/easyui/jquery.easyui.min.js" charset="utf-8"></script>
<script language="javascript" src="js/easyui/locale/easyui-lang-zh_CN.js" charset="utf-8"></script>
<script>
$(function(){
	var options={
		columns:[[
          {field:'id',title: 'ID',align: 'center',hidden:'true'},
          {field:'actname',title: '活动名称',align: 'center',width: 200},
          {field:'acttype',title: '活动类型值',align: 'center',hidden:'true'},
          {field:'acttypeStr',title: '活动类型',align: 'center',width: 200},
          {field:'actcat',title: '活动类别值',align: 'center',hidden:'true'},
          {field:'actcatStr',title: '活动类别',align: 'center',width: 200},
          {field:'begindt',title: '开始日期',align: 'center',width: 200},
          {field:'enddt',title: '结束日期',align: 'center',width: 200},
          {field:'actdesc',title: '活动详情',align: 'center',width: 200},
          {field:'creator',title: '创建人',align: 'center',width: 200},
          {field:'actst',title: '状态值',align: 'center',hidden:'true'},
          {field:'actstStr',title: '状态',align: 'center',width: 200}
		]]
	};
	//构建datagrid，并填充数据
	var dataGrid = new BSS.DataGrid('#tbl_acty_datagrid');
	ACTYDIALOG = new BSS.Dialog('#div_actyadd');
	dataGrid.build(options,{code:19003});
	//设置新建事件
	dataGrid.create = function(){
		ACTYDIALOG.init({href:'act/add.html',width:400});
	};
	//设置编辑事件
	dataGrid.edit = function(){
		var row=this.getSelectedRow();
		if(BSS.Helper.isNull(row)){
			BSS.warning('请选择要编辑的数据行');
			return;
		}
		var id = row['id'];
		ACTYDIALOG.init({href:'act/'+id+'.html',width:400});
	};
})
</script>