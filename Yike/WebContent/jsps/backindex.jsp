<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>亿可后台系统</title>
</head>
<frameset rows="127,*,11" frameborder="no" border="0" framespacing="0">
  <frame src="${pageContext.request.contextPath}/publics/top.jsp" name="topFrame" scrolling="No" noresize="noresize" id="topFrame" />
  <frame src="${pageContext.request.contextPath}/publics/center.jsp" name="mainFrame" id="mainFrame" />
  <frame src="${pageContext.request.contextPath}/publics/down.jsp" name="bottomFrame" scrolling="No" noresize="noresize" id="bottomFrame" />
</frameset>
<noframes>
  <body style="overflow-y:auto;">
  </body>
</noframes>
</html>
