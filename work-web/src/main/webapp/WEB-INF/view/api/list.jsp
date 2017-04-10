<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<table id="tbl_api_datagrid" class="easyui-datagrid"></table>
<div id="div_apiadd" style="padding:0 0 0 50px;"></div>
<!-- javascript部分 -->
<script>
$(function(){
	var options={
		columns:[[
          {field:'apiid',title: 'ID',align: 'center',hidden:'true'},
          {field:'code',title: '业务编码',align: 'center',width: 200},
          {field:'apiname',title: '业务名称',align: 'center',width: 200},
          {field:'apiurl',title: 'URL',align: 'center',width: 200},
          {field:'retype',title: '返回类型',align: 'center',width: 200},
          {field:'apist',title: '状态',align: 'center',width: 200}
		]]
	};
	//构建datagrid，并填充数据
	var apiGrid = new BSS.DataGrid('#tbl_api_datagrid');
	var apiDialog = new BSS.Dialog('#div_apiadd');
	apiGrid.build(options,{code:21012});
	//设置新建事件
	apiGrid.create = function(){
		apiDialog.ok = function(){
			var api = BSS.form2json('#frm_api');
			BSS.dispatch({code:21010,data:[api]},function(){
				BSS.info('保存成功');
				apiGrid.load({code:21012});
			},function(){});
		}
		apiDialog.init({href:'api/add.html',width:400});
	};
	//设置编辑事件
	apiGrid.edit = function(){
		var row=this.getSelectedRow();
		if(BSS.Helper.isNull(row)){
			BSS.warning('请选择要编辑的数据行');
			return;
		}
		var apiid = row['apiid'];
		apiDialog.init({href:'api/'+apiid+'.html',width:400});
		apiDialog.ok = function(){
			var api = BSS.form2json('#frm_api');
			BSS.dispatch({code:21013,data:[api]},function(){
				BSS.info('更新成功');
				apiGrid.load({code:21012});
			},function(){});
		}
	};
})
</script>