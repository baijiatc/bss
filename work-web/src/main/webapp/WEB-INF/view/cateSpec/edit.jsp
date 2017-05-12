<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
 <ul id="cateSpec_tree">
	<input id="id_id" class="easyui-textbox" type="hidden" name="id"></input>
</ul>
<script>
$(function(){
	var cateSpecTree = new BSS.Tree('#cateSpec_tree');
			BSS.dispatch({code:14033,data:[{id:'${id}'}]},function(resp){
				if(resp.code == 0){
					var nodes = [];
					var data = resp.data;
					var len = data.length;
					for(var i = 0; i < len; i++){
						var spec = data[i];
						var node = {text:spec.specname,id:spec.id,checked:spec.checked};
						nodes.push(node);
					}
					cateSpecTree.init({
						data:nodes,
						checkbox:true

					})
					CATDIALOG.ok = function(){
						var nodes = cateSpecTree.getChecked();
						var len = nodes.length;
						 
						
						var specids = [];
						for(var i = 0; i < len; i++){
						    var specid = nodes[i].id;
						    specids.push(specid);
						}
					    var catid = ${id};
					    var catspec = {catid:""+catid+"",specid:""+specids+""}; 
						BSS.dispatch({code:14032,data:[catspec]},function(resp){
 						BSS.alert('保存成功！');
				});
			 }
			}else{
				BSS.warning(resp.message);
			}
			
		});
});
</script>