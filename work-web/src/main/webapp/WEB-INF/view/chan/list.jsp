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
          {field:'chantype',title: '渠道类型',align: 'center',width: 200},
          {field:'contact',title: '联系人',align: 'center',width: 200},
          {field:'mobile',title: '角色名称',align: 'center',width: 200},
          {field:'address',title: '地址',align: 'center',width: 200},
          {field:'parentid',title: '上级渠道',align: 'center',width: 200},
          {field:'chanst',title: '状态',align: 'center',width: 200}
		]]
	};
	//构建datagrid，并填充数据
	var chanGrid = new BSS.DataGrid('#tbl_chan_datagrid');
	var chanDialog = new BSS.Dialog('#div_chanadd');
	chanGrid.build(options,{code:13009});
	//设置新建事件
	chanGrid.create = function(){
		chanDialog.ok = function(){
			var chan = BSS.form2json('#frm_chanadd');
			BSS.dispatch({code:13007,data:[chan]},function(resp){
				if(resp.code == 0){
					BSS.info('保存成功！');
					chanGrid.load({code:13009});
				}else{
					BSS.error(resp.message);
				}
			},function(){});
		}
		chanDialog.init({href:'chan/add.html',width:400,height:400});
	};
	//设置编辑事件
	chanGrid.edit = function(){
		var row=this.getSelectedRow();
		if(BSS.Helper.isNull(row)){
			BSS.warning('请选择要编辑的数据行');
			return;
		}
		chanDialog.ok = function(){
			var chan = BSS.form2json('#frm_chanedit');
			BSS.dispatch({code:13008,data:[chan]},function(){
				if(resp.code == 0){
					BSS.info('保存成功！');
					chanGrid.load({code:13009});
				}else{
					BSS.error(resp.message);
				}
			},function(){});
		}
		var chanid = row['chanid'];
		chanDialog.init({href:'chan/'+chanid+'.html',width:400,height:400});
	};
})
</script>