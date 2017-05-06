<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<ul id="role_tree">
	<input id="id_staffid" class="easyui-textbox" type="hidden" name="staffid"></input>
</ul>
<!-- javascript部分 -->
<script language="javascript" src="js/easyui-tree-extend.js" charset="utf-8"></script>
<script>
$(function(){
	var privsetRoleTree = new BSS.Tree('#role_tree');
			BSS.dispatch({code:20012,data:[{sid:'${staffid}'}]},function(resp){
				if(resp.code == 0){
					var nodes = [];
					var data = resp.data;
					var len = data.length;
					for(var i = 0; i < len; i++){
						var role = data[i];
						var node = {text:role.rolename,id:role.roleid,checked:role.checked};
						nodes.push(node);
					}
					privsetRoleTree.init({
						data:nodes,
						checkbox:true
						})
						
						STAFFDIALOG.ok = function(){
							var nodes = privsetRoleTree.getChecked();
							var len = nodes.length;
							if(len <= 0){
								BSS.alert('保存成功！');
								return;
							}
							var roleids = [];
							for(var i = 0; i < len; i++){
							    var roleid = nodes[i].id;
							    roleids.push(roleid);
							}
						    var staffid = ${staffid};
 						    var staffrole = {staffid:""+staffid+"",roleid:""+roleids+""};
							BSS.dispatch({code:30001,data:[staffrole]},function(resp){
	 						BSS.alert('保存成功！');
					});
				 }
				}else{
					BSS.warning(resp.message);
				}
				
			});
});
</script>