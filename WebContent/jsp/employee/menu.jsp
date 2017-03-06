<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
	<div class="list-group">
		<a href="${pageContext.request.contextPath}/${param.module}/${param.function1}" class="list-group-item">${param.title1}</a>
		<a href="${pageContext.request.contextPath}/${param.module}/${param.function2}" class="list-group-item">${param.title2}</a>
		<a href="${pageContext.request.contextPath}/${param.module}/${param.function3}" class="list-group-item">${param.title3}</a>
		<a href="${pageContext.request.contextPath}/${param.module}/${param.function4}" class="list-group-item">${param.title4}</a>
		<a href="${pageContext.request.contextPath}/${param.module}/${param.function5}" class="list-group-item">${param.title5}</a>
	</div>
</body>
</html>