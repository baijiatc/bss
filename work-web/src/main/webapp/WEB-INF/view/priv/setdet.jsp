<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<ul id="ul_privset_show_tree"></ul>
<!-- javascript部分 -->
<script>
$(function(){
	BSS.dispatch({code:10003},function(resp){
		if(resp.code == 0){
			var len = resp.data.length;
			var nodes = [];
			for(var i = 0; i < len; i++){
				var menuGroup = resp.data[i];
				var pmenu = menuGroup[0];
				var node = {text:pmenu.menuname,state:'open',id:pmenu.menuid,children:[],ismenu:true};
				if(menuGroup.length > 1){
					var subMenu2ElemArr = menuGroup[1];
					var clen = subMenu2ElemArr.length;
					for(var j = 0; j < clen; j++){
						var submenuGroup = subMenu2ElemArr[j];
						var cmenu = submenuGroup[0];
						var cnode = {text:cmenu.menuname,state:'open',id:cmenu.menuid,children:[],ismenu:true};
						if(submenuGroup.length > 1){
							var elems = submenuGroup[1];
							var elen = elems.length;
							for(var k = 0; k < elen; k++){
								var elem = elems[k];
								var enode = {text:elem.elemname,id:elem.elemid,ismenu:false};
								cnode.children.push(enode);
							}
						}
						node.children.push(cnode);
					}
				}
				nodes.push(node);
			}
			
			var privsetShowTree =new BSS.Tree('#ul_privset_show_tree');
			privsetShowTree.init({
				checkbox:true,
				data:nodes
			});
		}else{
			BSS.warning(resp.message);
		}
	},function(resp){});
});
</script>