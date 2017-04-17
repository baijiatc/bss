<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div id="div_leftview"></div>
<script>
BSS.dispatch({code:10003},function(resp){
	if(resp.code == 0){
		var len = resp.data.length;
		var strbuilder = new BSS.StringBuilder();
		for(var i = 0; i < len; i++){
			var menuGroup = resp.data[i];
			var pmenu = menuGroup[0];
			strbuilder.append('<div title="').append(pmenu.menuname)
			.append('" data-options="iconCls:\'icon-blank\'" style="overflow:auto;padding:10px;">');
			if(menuGroup.length > 1){
				strbuilder.append('<ul style="margin:0;padding:0 0 0 20px">');
				var subMenu2ElemArr = menuGroup[1];
				var clen = subMenu2ElemArr.length;
				for(var j = 0; j < clen; j++){
					var submenuGroup = subMenu2ElemArr[j];
					var cmenu = submenuGroup[0];
					strbuilder.append('<li data-href="').append(cmenu.url)
					.append('"><a href="javascript:void(0)">').append(cmenu.menuname)
					.append('</a></li>');
				}
				strbuilder.append('</ul>');
			}
			strbuilder.append('</div>');
		}
		$('#div_leftview').html(strbuilder.toString());
		var leftMenuAcc = new BSS.Accordion('#div_leftview');
		leftMenuAcc.init({border:false});
		
		$('div[id^="div_leftview"] ul>li').click(function(){
			var url = $(this).attr('data-href');
			var title = $(this).text();
			BSS.showView(url,function(html){
				MAINTAB.add(title,html);
			});
		});
	}else{
		BSS.warning(resp.message);
	}
},function(resp){
	console.log(JSON.stringify(resp));
});
</script>