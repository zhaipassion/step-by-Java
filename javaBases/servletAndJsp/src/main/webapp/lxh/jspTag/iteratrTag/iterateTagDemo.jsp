<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="iterTag" uri="/lxh/jspTag/iteratrTag/iterateTagDemo.tld" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>IterateTagDemo</title>
</head>
<body>
<%
List<String> iterList = new ArrayList<String>();
iterList.add("HZ");
iterList.add("Bob");
iterList.add("stepByMe.com");
%>

	<p>以下是遍历标签内容：</p>
	<iterTag:iterTagDemo id="iterVal" name="iterList" scope="request">
		<h2>姓名：${iterVal}</h2>
	</iterTag:iterTagDemo>
</body>
</html>