<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<table  id="cust-datagrid" class="easyui-datagrid"></table>
<div id="div_customer" style="padding:0 0 0 50px;"></div>
<!-- javascript部分 -->
 <script>
$(function(){
	var options={
		columns:[[
          {field:'cstmid',title: 'ID',align: 'center',hidden:'true'},
          {field:'cstmname',title: '会员姓名',align: 'center',width: 200},
          {field:'certno',title: '证件号码',align: 'center',width: 200},
          {field:'certtype',title: '证件类型值',align: 'center',hidden:'true'},
          {field:'certtypeStr',title: '证件类型',align: 'center',width: 200},
          {field:'mobile',title: '手机',align: 'center',width: 200},
          {field:'gender',title: '性别值',align: 'center',hidden:'true'},
          {field:'genderStr',title: '性别',align: 'center',width: 200},
          {field:'birthday',title: '出生日期',align: 'center',width: 200},
          {field:'cstmlevel',title: '客户等级',align: 'center',width: 200},
          {field:'cstmphoto',title: '客户头像',align: 'center',width: 200},
          {field:'hobby',title: '爱好',align: 'center',width: 200},
          {field:'email',title: '电子邮件',align: 'center',width: 200},
          {field:'cstmtype',title: '客户类型值',align: 'center',hidden:'true'},
          {field:'cstmtypeStr',title: '客户类型',align: 'center',width: 200},
          {field:'regtime',title: '注册日期',align: 'center',width: 200},
          {field:'cstmst',title: '状态',align: 'center',hidden:'true'},
          {field:'cstmstStr',title: '状态',align: 'center',width: 200}
		]]
	};
	//构建datagrid，并填充数据
	var custGrid = new BSS.DataGrid('#cust-datagrid');
	CUSTOMER  = new BSS.Dialog('#div_customer');
	custGrid.toolbar=null;
	custGrid.build(options,{code:12002});
})
</script>