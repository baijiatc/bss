<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<table id="tbl_prod_datagrid" class="easyui-datagrid"></table>
<div id="div_prodadd" style="padding:0 0 0 50px;"></div> 
<!-- javascript部分 -->
<script language="javascript" src="js/easyui/jquery.easyui.min.js" charset="utf-8"></script>
<script language="javascript" src="js/easyui/locale/easyui-lang-zh_CN.js" charset="utf-8"></script>
<script>
$(function(){
	var options={
		columns:[[
          {field:'id',title: 'ID',align: 'center',hidden:'true'},
          {field:'sourceid',title: '源标识',align: 'center',width: 200},
          {field:'fromsys',title: '来源平台值',align: 'center',hidden:'true'},
          {field:'fromsysStr',title: '来源平台',align: 'center',width: 200},
          {field:'prodname',title: '名称',align: 'center',width: 200},
          {field:'catid',title: '类别值',align: 'center',hidden:'true'},
          {field:'catname',title: '类别',align: 'center',width: 220},
          {field:'brandid',title: '品牌值',align: 'center',hidden:'true'},
          {field:'brandname',title: '品牌',align: 'center',width: 220},
          {field:'description',title: '商品详情',align: 'center',width: 200},
         
		]]
	};
	
	
	//构建datagrid，并填充数据
	var prodGrid = new BSS.DataGrid('#tbl_prod_datagrid');
	PRODDIALOG = new BSS.Dialog('#div_prodadd');
	prodGrid.toolbar.push({iconCls:'icon-redo',text:'参数分配 ',handler:function(){
		var row=prodGrid.getSelectedRow();
			if(BSS.Helper.isNull(row)){
				BSS.warning('请选择数据行');
				return;
			}
			var id = row['id'];
			PRODDIALOG.init({href:'prodparm/'+id+'.html',width:400});
	}});
	prodGrid.build(options,{code:14015});
	//设置新建事件
	prodGrid.create = function(){
		PRODDIALOG.init({href:'prod/add.html',width:400});
	};
	//设置编辑事件
	prodGrid.edit = function(){
		var row=this.getSelectedRow();
		if(BSS.Helper.isNull(row)){
			BSS.warning('请选择要编辑的数据行');
			return;
		}
		var id = row['id'];
		PRODDIALOG.init({href:'prod/'+id+'.html',width:400});
	};
	
	//设置品类名字
	PRODDIALOG.loadCatName=function(selector,callback){
		BSS.dispatch({code:14006},function(resp){
			if(resp.code == 0){
				var datas = resp.data;
				var options = {valueField:'id',textField:'catname',data:datas};
				var parentCatCombox=new BSS.Combox(selector);
				parentCatCombox.init(options);
				if(jQuery.isFunction(callback)){
					callback();
				}
			}else{
				BSS.warning(resp.message);
			}
		},function(resp){});
	}
	
	//设置品牌名字
	PRODDIALOG.loadBrandName=function(selector,callback){
		BSS.dispatch({code:14003},function(resp){
			if(resp.code == 0){
				var datas = resp.data;
				var options2 = {valueField:'id',textField:'brandname',data:datas};
				var prodGridCombox=new BSS.Combox(selector);
				prodGridCombox.init(options2);
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