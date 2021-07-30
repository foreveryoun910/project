<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>home</title>
</head>
<body>
	<table border="1">
		<tr>
			<td colspan="2"><tiles:insertAttribute name="header" ignore="true" /></td>
		</tr>
		<tr>
			<td><tiles:insertAttribute name="menu" ignore="true" /></td>
			<td><tiles:insertAttribute name="body" ignore="true" /></td>
		</tr>
		<tr>
			<td colspan="2"><tiles:insertAttribute name="footer" ignore="true" /></td>
		</tr>
	</table>
</body>
</html>