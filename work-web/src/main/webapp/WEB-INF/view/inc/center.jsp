<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<div id="div_centerview">
	<div title="欢迎页">
		<div>欢迎你：${loginuser }</div>
	</div>
</div>
<script>
$(function(){
	MAINTAB = new BSS.Tab('#div_centerview');
	MAINTAB.init();
});
</script>