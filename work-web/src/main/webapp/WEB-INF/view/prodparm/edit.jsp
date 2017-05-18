<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
 <ul id="proParm_tree">
	<input id="id_id" class="easyui-textbox" type="hidden" name="id"></input>
</ul>
<script>
$(function(){
	var proParmTree = new BSS.Tree('#proParm_tree');
			BSS.dispatch({code:14030,data:[{id:'${id}'}]},function(resp){
				if(resp.code == 0){
					var nodes = [];
					var data = resp.data;
					var len = data.length;
					for(var i = 0; i < len; i++){
						var parm = data[i];
						var  html = '&nbsp<input id="id_paramvalue'+i+'" class="easyui-textbox unrequired" required="true" name="paramvalue" placeholder="请填写参数值"></input>';
// 						$("#id_paramvalue"+i+"").value=parm.paramvalue;
//   						alert(JSON.stringify(resp.data));
						var node = {text:parm.paramname+html,id:parm.id,checked:parm.checked};
						nodes.push(node);
					}
					proParmTree.init({
						data:nodes,
						checkbox:true

					})
					for(var i = 0; i < len; i++){
						var parms = data[i];
						$("#id_paramvalue"+i+"").val(parms.paramvalue);
					}
					
						
						PRODDIALOG.ok = function(){
						var nodes = proParmTree.getChecked();
						var len = nodes.length;
 
						var paramids = [];
						for(var i = 0; i < len; i++){
						    var paramid = nodes[i].id;
						    paramids.push(paramid);
						}
						
						var paramvalues = [];
						for(var i = 0; i < len; i++){
						    var paramvalue = $("#id_paramvalue"+i+"").val();
						    paramvalues.push(paramvalue);
						}
						alert(paramvalues);
					    var productid = ${id};
					    var prodparm = {productid:""+productid+"",paramid:""+paramids+"",paramvalue:""+paramvalues+""}; 
						BSS.dispatch({code:14031,data:[prodparm]},function(resp){
 						BSS.alert('保存成功！');
				});
			 }
			}else{
				BSS.warning(resp.message);
			}
			
		});
});
</script>