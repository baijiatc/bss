<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<table id="tbl_deoart_datagrid" class="easyui-datagrid"></table>
<div id="div_departadd" style="padding:0 0 0 50px;"></div>
<!-- javascript部分 -->
<script>
$(function(){
	var options={
		columns:[[
          {field:'departid',title: 'ID',align: 'center',hidden:'true'},
          {field:'departname',title: '部门名称',align: 'center',width: 200},
          {field:'leader',title: '负责人值',align: 'center',hidden:'true'},
          {field:'staffname',title: '负责人',align: 'center',width: 200},
          {field:'parentid',title: '上级部门',align: 'center',hidden:'true'},
          {field:'parentStr',title: '上级部门',align: 'center',width: 200},
          {field:'address',title: '地址',align: 'center',width: 200},
          {field:'telephone',title: '联系电话',align: 'center',width: 200},
          {field:'departst',title: '状态值',align: 'center',hidden:'true'},
          {field:'departStr',title: '状态',align: 'center',width: 200},
		]]
	};
	//构建datagrid，并填充数据
	var dprtGrid = new BSS.DataGrid('#tbl_deoart_datagrid');
	DEPTDIALOG = new BSS.Dialog('#div_departadd');
	dprtGrid.build(options,{code:11008});
	//设置新建事件
	dprtGrid.create = function(){
		DEPTDIALOG.init({href:'dprt/add.html',width:400});
	};
	//设置编辑事件
	dprtGrid.edit = function(){
		var row=this.getSelectedRow();
		if(BSS.Helper.isNull(row)){
			BSS.warning('请选择要编辑的数据行');
			return;
		}
		var departid = row['departid'];
		DEPTDIALOG.init({href:'dprt/'+departid+'.html',width:400});
	};
	DEPTDIALOG.loadParentDepart=function(selector,callback){
		BSS.dispatch({code:11008},function(resp){
			if(resp.code == 0){
				var datas = resp.data;
				var options = {valueField:'departid',textField:'departname',data:datas};
				var parentCombox=new BSS.Combox(selector);
				parentCombox.init(options);
				if(jQuery.isFunction(callback)){
					callback();
				}
			}else{
				BSS.warning(resp.message);
			}
		},function(resp){});
	}
	DEPTDIALOG.loadStaff=function(selector,callback){
		BSS.dispatch({code:11003},function(resp){
			if(resp.code == 0){
				var datas = resp.data;
				var options = {valueField:'staffid',textField:'staffname',data:datas};
				var staffCombox=new BSS.Combox(selector);
				staffCombox.init(options);
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