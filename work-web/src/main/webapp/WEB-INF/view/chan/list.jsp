<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<table id="tbl_chan_datagrid" class="easyui-datagrid"></table>
<div id="div_chanadd" style="padding:0 0 0 50px;"></div>
<!-- javascript部分 -->
<script>
$(function(){
	var options={
		columns:[[
          {field:'chanid',title: 'ID',align: 'center',hidden:'true'},
          {field:'channame',title: '渠道名称',align: 'center',width: 200},
          {field:'chantype',title: '渠道类型值',align: 'center',hidden:'true'},
          {field:'chantypeStr',title: '渠道类型',align: 'center',width: 200},
          {field:'contact',title: '联系人',align: 'center',width: 200},
          {field:'mobile',title: '角色名称',align: 'center',width: 200},
          {field:'province',title: '地址',align: 'center',hidden:'true'},
          {field:'city',title: '地址',align: 'center',hidden:'true'},
          {field:'district',title: '地址',align: 'center',hidden:'true'},
          {field:'address',title: '地址',align: 'center',width: 200},
          {field:'parentid',title: '上级渠道',align: 'center',width: 200},
          {field:'chanst',title: '状态值',align: 'center',hidden:'true'},
          {field:'chanstStr',title: '状态',align: 'center',width: 200}
		]]
	};
	//构建datagrid，并填充数据
	var chanGrid = new BSS.DataGrid('#tbl_chan_datagrid');
	CHANDIALOG = new BSS.Dialog('#div_chanadd');
	chanGrid.build(options,{code:13009});
	//设置新建事件
	chanGrid.create = function(){
		CHANDIALOG.init({href:'chan/add.html',width:400,height:450});
	};
	//设置编辑事件
	chanGrid.edit = function(){
		var row=this.getSelectedRow();
		if(BSS.Helper.isNull(row)){
			BSS.warning('请选择要编辑的数据行');
			return;
		}
		var chanid = row['chanid'];
		CHANDIALOG.init({href:'chan/'+chanid+'.html',width:400,height:450});
	};
})
</script>