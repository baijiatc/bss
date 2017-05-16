<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<table id="tbl_menu_datagrid" class="easyui-datagrid"></table>
<div id="div_menuadd" style="padding:0 0 0 50px;"></div>
<!-- javascript部分 -->
<script>
$(function(){
	var options={
		columns:[[
          {field:'menuid',title: 'ID',align: 'center',hidden:'true'},
          {field:'menuname',title: '菜单名称',align: 'center',width: 220},
          {field:'url',title: '菜单URL',align: 'center',width: 220},
          {field:'parentid',title: '上级菜单值',align: 'center',hidden:'true'},
          {field:'parentname',title: '上级菜单',align: 'center',width: 220},
          {field:'icon',title: '菜单图标',align: 'center',width: 220},
          {field:'sort',title: '菜单排序',align: 'center',width: 220},
          {field:'menust',title: '状态值',align: 'center',hidden:'true'},
          {field:'menustStr',title: '状态',align: 'center',width: 200},
		]]
	};
	//构建datagrid，并填充数据
	var menuGrid = new BSS.DataGrid('#tbl_menu_datagrid');
	menuGrid.toolbar.push({iconCls:'icon-refresh',text:'刷新',handler:function(){
		BSS.dispatch({code:21092},function(resp){
			if(resp.code == 0){
				BSS.info('刷新成功<br/>请刷新页面!');
			}else{
				BSS.warning(resp.message);
			}
		},function(resp){
			console.log(JSON.stringify(resp));
		});
	}});
    MENUDIALOG = new BSS.Dialog('#div_menuadd');
    menuGrid.build(options,{code:21003});
	//设置新建事件
	menuGrid.create = function(){
		MENUDIALOG.init({href:'menu/add.html',width:400});
	};
	//设置编辑事件
	menuGrid.edit = function(){
		var row=this.getSelectedRow();
		if(BSS.Helper.isNull(row)){
			BSS.warning('请选择要编辑的数据行');
			return;
		}
		var menuid = row['menuid'];
		MENUDIALOG.init({href:'menu/'+menuid+'.html',width:400});
	};
	//设置父类名字
	MENUDIALOG.loadParentMenu=function(selector,callback){
		BSS.dispatch({code:21003,data:[{parentid:0}]},function(resp){
			if(resp.code == 0 ){
				var datas = resp.data;
				var options = {valueField:'menuid',textField:'menuname',data:datas};
				var parentidCombox=new BSS.Combox(selector);
				parentidCombox.init(options);
				if(jQuery.isFunction(callback)){
					callback();
				}
			}else{
				BSS.warning(resp.message);
			}
		},function(resp){});
	}
})
</script>