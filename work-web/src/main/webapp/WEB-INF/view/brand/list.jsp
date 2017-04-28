<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<table id="tbl_brand_datagrid" class="easyui-datagrid"></table>
<div id="div_brandadd" style="padding:0 0 0 50px;"></div>
<!-- javascript部分 -->
<script language="javascript" src="js/easyui/jquery.easyui.min.js" charset="utf-8"></script>
<script language="javascript" src="js/easyui/locale/easyui-lang-zh_CN.js" charset="utf-8"></script>
<script>
$(function(){
	var options={
		columns:[[
          {field:'id',title: 'ID',align: 'center',hidden:'true'},
          {field:'brandname',title: '品牌名称',align: 'center',width: 200},
          {field:'brandalias',title: '品牌别称',align: 'center',width: 200},
          {field:'weburl',title: '品牌网址',align: 'center',width: 200},
          {field:'branddesc',title: '品牌介绍',align: 'center',width: 200},
          {field:'brandlogo',title: '品牌logo',align: 'center',width: 200},
          {field:'sort',title: '排序',align: 'center',width: 200},
          {field:'brandst',title: '状态值',align: 'center',hidden:'true'},
          {field:'brandstStr',title: '状态',align: 'center',width: 200},
         
		]]
	};
	//构建datagrid，并填充数据
	var brandGrid = new BSS.DataGrid('#tbl_brand_datagrid');
	BRANDDIALOG = new BSS.Dialog('#div_brandadd');
	brandGrid.build(options,{code:14003});
	//设置新建事件
	brandGrid.create = function(){
		BRANDDIALOG.init({href:'brand/add.html',width:400});
	};
	//设置编辑事件
	brandGrid.edit = function(){
		var row=this.getSelectedRow();
		if(BSS.Helper.isNull(row)){
			BSS.warning('请选择要编辑的数据行');
			return;
		}
		var id = row['id'];
		BRANDDIALOG.init({href:'brand/'+id+'.html',width:400});
	};
})
</script>