<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<script language="javascript" src="js/easyui/jquery.easyui.min.js" charset="utf-8"></script>
<script language="javascript" src="js/easyui/locale/easyui-lang-zh_CN.js" charset="utf-8"></script>
<table style="text-align:center">
	<tr>
		<td>事件名称</td>
		<td><input id="motevt_name" value="${evtname }" type="text" name="evtname"class="easyui-textbox" style="width:200px;" readonly="readonly"/></td>
		<td>是否自定义</td>
		<td>
			<td><input id="id_ischeak" type="radio" name="issingle" value="1"/>是</td>
			<td><input id="ischeak" type="radio" name="issingle" value="0"/>否</td>
		</td>
	</tr>
</table>

<form id = "frm_motevtget2" style="display:none">
	<input id="id_evtids"  name="evtid" class="easyui-textbox" type="hidden" value="${id}"/>
	<input id="hid_ischeak"  name="isctsm" value="0" type="hidden"/>
	<table style="text-align:center" id="tblone">
		<tr>
			<td>业务类型</td>
		    <td><input id="cbx_biztype" type="text" name="biztype"class="easyui-combobox" style="width:150px;" /></td>
		</tr>
	</table>
	<table style="text-align:center" id="tbltwo">
		<tr>
			<td><input id="id_idxid" type="text" name="idxid" class="easyui-combobox" style="width:150px;" /></td>
			<td><input id="id_parmval"  type="text" name="parmval" class="easyui-textbox" style="width:200px;" /></td>
		</tr>
	</table>
</form>

<form id="frm_motevtget" method="post" style="display:none">
	<input id="id_evtids"  name="evtid" class="easyui-textbox" type="hidden" value="${id}"/>
	<input id="hid_ischeak"  name="isctsm" value="0" type="hidden"/>
	<table style="text-align:center" id="tblone">
		<tr>
			<td>业务类型</td>
		    <td><input id="cbx_biztype" type="text" name="biztype"class="easyui-combobox" style="width:150px;" /></td>
		</tr>
	</table>
	<table style="text-align:center" id="tbltwo">
		<tr>
			<td><input id="id_idxid" type="text" name="idxid" class="easyui-combobox" style="width:150px;" /></td>
			<td><input id="id_oprtchar" type="text" name="oprtchar" class="easyui-combobox" style="width:150px;" /></td>
			<td><input id="id_parmval"  type="text" name="parmval" class="easyui-textbox" style="width:200px;" /></td>
		</tr>
	</table>
</form>

<div style="text-align:right;">
	<a id="lnk_viewshow" href="javascript:void(0);" class="easyui-linkbutton" onclick="add()" data-options="iconCls:'icon-add'" style="width:80px">添加</a>
</div>
<table id="tbl_motevtcon_datagrid" class="easyui-datagrid"></table>

<script>
$(function(){
	var options={
		columns:[[
          {field:'evtname',title: '事件名称',align: 'center',width: 100},
          {field:'idxid',title: '条件编号',align: 'center',hidden:false},
          {field:'idxname',title: '条件',align: 'center',width: 100},
          {field:'oprtchar',title: '操作符',align: 'center',width: 100},
          {field:'parmval',title: '值',align: 'center',width: 100},
          {field:'id',title: '操作',align:'center',width:100,
        	  formatter:function(id){
	        	  var btn = '<a  onclick="deleteMotCondition(\''+id+'\')" href="javascript:void(0)">删除</a>';  
	        	  return btn;
	          	}
	          }
		  ]]
	};
	//构建datagrid，并填充数据
	var motevtsmeGrid = new BSS.DataGrid('#tbl_motevtcon_datagrid');
	motevtsmeGrid.toolbar=null;
	motevtsmeGrid.build(options,{code:22018,data:[{evtid:'${id}'}]});
		
	var hjoinCombox = new BSS.Combox('#id_hjoin');
	hjoinCombox.fromDict('DICT_HJOIN');
	
			
	//下拉框初始化
	BSS.dispatch({code:22009},function(resp){
		if(resp.code == 0)
		{
			var datas = resp.data;
			var options = {valueField:'id',textField:'tblname',data:datas,onSelect:function(item){
				loadDscol(item.id);
			}};
			
			//左关联表初始化
			var tblCombox = new BSS.Combox('#cbx_ldstbl');
			tblCombox.init(options);
			//右关联表初始化
			options = {valueField:'id',textField:'tblname',data:datas,onSelect:function(item){
				loadRdscol(item.id);}};
			var tblCombox = new BSS.Combox('#cbx_rdstbl');
			tblCombox.init(options);
			
			var dstblCombox = new BSS.Combox('#cbx_dstbl');
			options = {valueField:'id',textField:'tblname',data:datas};
			dstblCombox.init(options);
		}
		else
		{
			BSS.warning(resp.message);
		}
	},function(resp){
		console.log(JSON.stringify(resp));
	  });
})

//为页面单选按钮定义响应
$(":radio").click(function(){
	if(this.value==0)//设置为否时
	{
		$("#frm_motevtget").show();
		$("#frm_motevtget2").hide();
	}    
	else//设置为是时
	{
		$("#frm_motevtget").hide();
		$("#frm_motevtget2").show();
	}
 });
 
function loadDscol(id)
{
	BSS.dispatch({code:22010,data:[{tblid:id}]},function(resp){
		if(resp.code == 0)
		{
			var datas = resp.data;
			var options = {valueField:'id',textField:'colname',data:datas}
			var colCombox = new BSS.Combox('#cbx_ldscol');
			colCombox.init(options);
		}
		else
		{
			BSS.warning(resp.message);
		}
	},function(resp){
		console.log(JSON.stringify(resp));
	});
}

function loadRdscol(id){
	BSS.dispatch({code:22010,data:[{tblid:id}]},function(resp){
		if(resp.code == 0){
			var datas = resp.data;
			var options = {valueField:'id',textField:'colname',data:datas}
			var colCombox = new BSS.Combox('#cbx_rdscol');
			colCombox.init(options);
		}else{
			BSS.warning(resp.message);
		}
	},function(resp){
		console.log(JSON.stringify(resp));
	});
}

function add()
{  
	//判断是否单表
	if($('#id_ischeak').is(':checked')) //是单表
	{
		var evt = BSS.form2json('#frm_motevtget2');
		
		BSS.dispatch({code:22019,data:[evt]},function(resp){
			if(resp.code == 0){
				BSS.info('保存成功');
			}else{
				BSS.warning(resp.message);
			}
		},function(resp){
			console.log(JSON.stringify(resp));
		});
	}
	else//不是单表
	{
		var evt = BSS.form2json('#frm_motevtget');
		
		BSS.dispatch({code:22019,data:[evt]},function(resp){
			if(resp.code == 0){
				BSS.info('保存成功');
			}else{
				BSS.warning(resp.message);
			}
		},function(resp){
			console.log(JSON.stringify(resp));
		});
	}
}

function deleteMotCondition(id)
{  
	BSS.dispatch({code:22020,data:[{id:id}]},function(resp){
		if(resp.code == 0){
			BSS.info('删除成功');
		}else{
			BSS.warning(resp.message);
		}
	},function(resp){
		console.log(JSON.stringify(resp));
	});
}
</script>