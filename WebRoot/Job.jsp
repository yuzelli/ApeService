<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'Job.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

</head>

<body>
	This is my JSP page.
	<br>
	<table>
		<tr  >
			<td>职位ID</td>
			<td>职位标题</td>
			<td>职位详情</td>
			<td>职位类别</td>
			<td>职位薪资</td>
			<td>职位要求城市</td>
			<td>职位所属公司</td>
			<td>职位技能</td>
		</tr>
		<c:forEach items="${requestScope.list1 }" var="job">
			<tr>
				<td>${job.jobId}</td>
				<td>${job.jobName}</td>
				<td>${job.jobDetail}</td>
				<td>${job.jobType}</td>
				<td>${job.jobCharge}</td>
				<td>${job.jobCity}</td>
				<td>${job.companyId}</td>
				<td>${job.jobTechnology}</td>
			</tr>
		</c:forEach>

	</table>
</body>
</html>
