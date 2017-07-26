<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<table style="text-align:center">
	<tr>
		<td>事件名称</td>
		<td><input id="motevt_name" value="${evtname }" type="text" name="evtname"class="easyui-textbox" style="width:200px;" readonly="readonly"/></td>
		<td>是否自定义</td>
		<td>
			<td><input id="id_ischeak" type="radio" name="issingle" value="1"/>是</td>
			<td><input id="ischeak" type="radio" name="issingle" value="0" checked/>否</td>
		</td>
	</tr>
</table>

<form id="frm_motevtget" method="post">
	<input id="id_evtids"  name="evtid" class="easyui-textbox" type="hidden" value="${id}"/>
	<input id="hid_ischeak"  name="iscstm" value="0" type="hidden"/>
	<table style="text-align:center" id="tblone">
		<tr>
			<td>业务类型</td>
		    <td><input id="cbx_biztype" type="text" class="easyui-combobox" style="width:150px;" /></td>
		</tr>
	</table>
	<table style="text-align:center" id="tbltwo">
		<tr>
			<td><input id="id_idxid" type="text" name="idxid" class="easyui-combobox" style="width:150px;" /></td>
			<td id="td_oprtchar"><input id="id_oprtchar" type="text" name="oprtchar" class="easyui-combobox" style="width:150px;" /></td>
			<td><input id="id_parmval"  type="text" name="parmval" class="easyui-textbox" style="width:200px;" placeholder="指标结果"/></td>
		</tr>
	</table>
</form>

<div style="text-align:right;">
	<a id="lnk_viewshow" href="javascript:void(0);" class="easyui-linkbutton" onclick="add()" data-options="iconCls:'icon-add'" style="width:80px">添加</a>
</div>
<table id="tbl_motevtcon_datagrid" class="easyui-datagrid"></table>

<script>
//构建datagrid，并填充数据
var motevtsmeGrid = new BSS.DataGrid('#tbl_motevtcon_datagrid');
$(function(){
	var options={
		columns:[[
          {field:'idxid',title: '指标',align: 'center',width: 100},
          {field:'oprtchar',title: '运算符',align: 'center',width: 100},
          {field:'parmval',title: '指标结果',align: 'center',width: 200},
          {field:'cstmStr',title: '类别',align: 'center',width: 100},
          {field:'id',title: '操作',align:'center',width:100,
        	  formatter:function(id){
	        	  var btn = '<a  onclick="deleteMotCondition(\''+id+'\')" href="javascript:void(0)">删除</a>';  
	        	  return btn;
	          	}
	          }
		  ]]
	};
	motevtsmeGrid.toolbar=null;
	motevtsmeGrid.build(options,{code:22021,data:[{evtid:'${id}'}]});
	//业务类型
	var biztypeCombox = new BSS.Combox('#cbx_biztype');
	biztypeCombox.change=function(item){
		initMotIdxCombox(item.value);
	};
	biztypeCombox.fromDict('DICT_BIZTYPE',function(){
		var oprtcharCombox = new BSS.Combox('#id_oprtchar');
		oprtcharCombox.fromDict('DICT_OPRTCHAR');
	});
	
	//为页面单选按钮定义响应
	$(":radio").click(function(){
		if(this.value==0){//设置为否时
			$("#td_oprtchar").show();
		}else{//设置为是时
			$("#td_oprtchar").hide();
		}
		$('#hid_ischeak').val(this.value);
	});
	//下拉框初始化
	//initCombox();
	
});

var motIdxCombox = new BSS.Combox('#id_idxid');
function initMotIdxCombox(val){
	BSS.dispatch({code:22007,data:[{biztype:val}]},function(resp){
		var datas = resp.data;
		var options = {valueField:'id',textField:'idxname',data:datas};
		motIdxCombox.init(options);
	});
}

function add(){  
	var evt = BSS.form2json('#frm_motevtget');
	BSS.dispatch({code:22023,data:[evt]},function(resp){
		if(resp.code == 0){
			BSS.info('保存成功');
			motevtsmeGrid.load({code:22021,data:[{evtid:'${id}'}]});
		}else{
			BSS.warning(resp.message);
		}
	},function(resp){
		console.log(JSON.stringify(resp));
	});
}

function deleteMotCondition(id){
	BSS.dispatch({code:22022,data:[{id:id}]},function(resp){
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