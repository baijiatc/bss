<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Schedule List</title>
</head>
<body>
<table style="width: 1280px;">
		<thead>
			<tr>
				<td>sched_name</td><td>job_name</td>
				<td>job_group</td><td>description</td>
				<td>job_class_name</td><td>operation</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${triggers }" var="triggerMap">
				<tr>
					<td>${triggerMap.SCHED_NAME }</td><td>${triggerMap.JOB_NAME }</td><td>${triggerMap.JOB_GROUP }</td>
					<td>${triggerMap.DESCRIPTION }</td><td>${triggerMap.TRIGGER_STATE }</td>
					<td>
						<a href="javascript:void(0);">暂停</a>
						<a href="javascript:void(0);">恢复</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>