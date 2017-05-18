<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div id="div_privset_container" style="height:491px;">
	<div id="div_privset_left" data-options="region:'west'" style="width:180px;height:80px;">
		<div id="div_privset_west_pnl">
			<div id="div_privset_tab">
				<div title="角色">
					<ul id="ul_privset_role_tree"></ul>
				</div>
				<div title="员工">
					<ul id="ul_privset_staff_tree"></ul>
				</div>
			</div>
		</div>
	</div>
	<div id="div_privset_center" data-options="region:'center'" style="width:auto">
		<div id="div_privset_center_pnl"></div>
	</div>
</div>
<!-- javascript部分 -->
<script>
$(function(){
	var privsetLayout = new BSS.Layout('#div_privset_container');
	var privsetWestPnl = new BSS.Panel('#div_privset_west_pnl');
	var privsetTab = new BSS.Tab('#div_privset_tab');
	var privsetRoleTree = new BSS.Tree('#ul_privset_role_tree');
	var privsetStaffTree = new BSS.Tree('#ul_privset_staff_tree');
	privsetLayout.layout();
	var curNode={isRole:null};//选定角色或者人员
	var html = $('#div_privset_west_pnl').html();
	privsetWestPnl.init({
		title:'列表',
		tools:[{
			iconCls:'icon-save',
			handler:function(){
				if(curNode.isRole == null){
					BSS.warning('请选择要操作的角色或员工！');
					return;
				}
				var nodes = $('#ul_privset_show_tree').tree('getChecked', ['checked','indeterminate']);
				var len = nodes.length;
				if(len == 0){
					BSS.warning('未选择任何权限！');
					return;
				}
				var menus = [], elems = [];
				for(var i = 0; i < len; i++){
					var node = nodes[i];
					if(node.disabled){continue;}//禁用的直接跳过
					if(node.ismenu){
						menus.push(node.id);
					}else{
						elems.push(node.id);
					}
				}
				if(curNode.isRole==true){
					saveRolePriv(curNode.id,menus,elems);
				}else if(curNode.isRole==false){
					saveStaffPriv(curNode.id,menus,elems);
				}
			}
		}]
	},html);
	BSS.dispatch({code:20007,data:[{rolest:1}]},function(resp){
		var roles = [];
		var data = resp.data;
		var len = data.length;
		for(var i = 0; i < len; i++){
			var role = {text:data[i].rolename,id:data[i].roleid};
			roles.push(role);
		}
		privsetRoleTree.init({
			data:roles,
			onClick:function(node){
				curNode.isRole=true;
				$.extend(curNode,node);
				showPrivDetView(node,curNode.isRole);
			}
		});
	},function(resp){});
	BSS.dispatch({code:11003,data:[{staffst:1}],psize:100},function(resp){
		var staffs = [];
		var data = resp.data;
		var len = data.length;
		for(var i = 0; i < len; i++){
			var staff = {text:data[i].staffname,id:data[i].staffid};
			staffs.push(staff);
		}
		privsetStaffTree.init({
			data:staffs,
			onClick:function(node){
				curNode.isRole=false;
				$.extend(curNode,node);
				showPrivDetView(node,curNode.isRole);
			}
		});
	},function(resp){});
	
	//初始化Tab
	privsetTab.init({
		onSelect:function(title,index){
			privsetRoleTree.unselect();
			privsetStaffTree.unselect();
			curNode.isRole=null;
			/*清除右侧内容begin*/
			$('#div_privset_center_pnl').html('');
			var options = {title:''};
			var privsetCenterPnl=new BSS.Panel('#div_privset_center_pnl');
			privsetCenterPnl.init(options,'');
			/*清除右侧内容end*/
		}
	});
});
function showPrivDetView(node,isRole){
	var title=node.text;
	var objid=node.id;
	BSS.showView('privset/det.html?objid='+objid+'&isRole='+isRole,function(html){
		var options = {title:'['+title+']权限分配'};
		var privsetCenterPnl =new BSS.Panel('#div_privset_center_pnl');
		privsetCenterPnl.init(options,html);
	});
}
function saveRolePriv(who,what,how){
	BSS.dispatch({code:20009,data:[{who:who,what:what,how:how}]},function(resp){
		if(resp.code == 0){
			BSS.info('保存成功！');
		}else{
			BSS.warning(resp.message);
		}
	},function(resp){
		console.log(JSON.stringify(resp));
	});
}
function saveStaffPriv(who,what,how){
	BSS.dispatch({code:20010,data:[{who:who,what:what,how:how}]},function(resp){
		if(resp.code == 0){
			BSS.info('保存成功！');
		}else{
			BSS.warning(resp.message);
		}
	},function(resp){
		console.log(JSON.stringify(resp));
	});
}
</script>