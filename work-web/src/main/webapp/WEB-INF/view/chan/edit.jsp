<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<form id="frm_chanedit" method="post">
	<table cellpadding="5">
		<tr>
			<td>渠道名称：</td>
			<td>
				<input class="easyui-textbox" type="text" name="channame" data-options="required:true"></input>
				<input class="easyui-textbox" type="hidden" name="chanid"></input>
			</td>
		</tr>
		<tr>
			<td>渠道分类：</td>
			<td>
				<input id="cbx_chantype" class="easyui-combobox" type="text" name="chantype" data-options="required:true"></input>
			</td>
		</tr>
		<tr>
			<td>联系人：</td>
			<td>
				<input class="easyui-textbox" type="text" name="contact" data-options="required:true"></input>
			</td>
		</tr>
		<tr>
			<td>手机：</td>
			<td>
				<input class="easyui-textbox" type="text" name="mobile" data-options="required:true"></input>
			</td>
		</tr>
		<tr>
			<td>省：</td>
			<td>
				<input id="cbx_chan_province" class="easyui-combobox" type="text" name="province"></input>
			</td>
		</tr>
		<tr>
			<td>市：</td>
			<td>
				<input id="cbx_chan_city" class="easyui-combobox" type="text" name="city"></input>
			</td>
		</tr>
		<tr>
			<td>区：</td>
			<td>
				<input id="cbx_chan_district" class="easyui-combobox" type="text" name="district"></input>
			</td>
		</tr>
		<tr>
			<td>地址：</td>
			<td>
				<input class="easyui-textbox" type="text" name="address" data-options="required:true"></input>
			</td>
		</tr>
		<tr id="tr_prarent_chan">
			<td>上级渠道：</td>
			<td>
				<input id="cbx_parent_chan" class="easyui-combobox" type="text" name="parentid"></input>
			</td>
		</tr>
		<tr>
			<td>渠道状态：</td>
			<td><input id="cbx_chanst" class="easyui-combobox" type="text" name="chanst" data-options="required:true"></input></td>
		</tr>
	</table>
</form>
<script>
var chantypeCombox = new BSS.Combox('#cbx_chantype');
chantypeCombox.change=function(item){
	if(item.value == 1){//县级代理
		$('#tr_prarent_chan').hide();
	}else{
		$('#tr_prarent_chan').show();
		CHANDIALOG.loadParentChans('#cbx_parent_chan',item.value);
	}
};
chantypeCombox.fromDict('DICT_CHANTYPE',function(){
	var chanstCombox = new BSS.Combox('#cbx_chanst');
	chanstCombox.fromDict('DICT_CHANST',function(){
		initChanEditPage();
	});
});

function initChanEditPage(){
	BSS.dispatch({code:13014,data:[{chanid:'${chanid}'}]},function(resp){
		if(resp.code == 0){
			var chan = resp.data[0];
			loadProvince(function(){
				loadCity(chan.province,function(){
					loadDistrict(chan.city,function(){
						BSS.json2form('#frm_chanedit',chan);
						provCombox.change=function(item){
							loadCity(item.value);
						};
						cityCombox.change=function(item){
							loadDistrict(item.value);
						};
					});
				});
			});
			
			setOk();
		}else{
			BSS.warning(resp.message);
		}
	},function(resp){
		console.log(console.log(resp));
	});
}

var provCombox = new BSS.Combox('#cbx_chan_province');
function loadProvince(callback){
	BSS.dispatch({code:21018,data:[{pid:0}]},function(resp){
		if(resp.code == 0){
			var datas = resp.data;
			var options = {valueField:'value',textField:'label',data:datas};
			provCombox.init(options);
			callback();
		}else{
			BSS.warning(resp.message);
		}
	},function(resp){
		console.log(JSON.stringify(resp));
	});
}
var cityCombox = new BSS.Combox('#cbx_chan_city');
function loadCity(parentid,callback){
	BSS.dispatch({code:21018,data:[{pid:parentid}]},function(resp){
		if(resp.code == 0){
			var datas = resp.data;
			var options = {valueField:'value',textField:'label',data:datas};
			cityCombox.init(options);
			callback();
		}else{
			BSS.warning(resp.message);
		}
	},function(resp){
		console.log(JSON.stringify(resp));
	});
}
var distCombox = new BSS.Combox('#cbx_chan_district');
function loadDistrict(parentid,callback){
	BSS.dispatch({code:21018,data:[{pid:parentid}]},function(resp){
		if(resp.code == 0){
			var datas = resp.data;
			var options = {valueField:'value',textField:'label',data:datas};
			distCombox.init(options);
			callback();
		}else{
			BSS.warning(resp.message);
		}
	},function(resp){
		console.log(JSON.stringify(resp));
	});
}

function setOk(){
	CHANDIALOG.ok = function(){
		var chan = BSS.form2json('#frm_chanedit');
		BSS.dispatch({code:13008,data:[chan]},function(resp){
			if(resp.code == 0){
				BSS.info('保存成功！');
				//chanGrid.load({code:13009});
			}else{
				BSS.error(resp.message);
			}
		},function(){});
	}
}
</script>