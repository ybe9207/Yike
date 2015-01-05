<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>左边菜单部分</title>
<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}
.style1 {
	font-size: 12px;
	color: #435255;
	text-decoration:none;
}
.style2 {
	margin-left:10px;
	width:20px;
	height:20px;
	margin-top:5px;
	}
.style3 {
	font-size: 12px; 
	font-weight: bold; 
    background:url("${pageContext.request.contextPath}/backimages/main_34.gif");
	height:20px;
	text-align:center;
	padding-top:5px;
}
.style4 {
	font-size: 12px; 
	font-weight: bold; 
    background:url("${pageContext.request.contextPath}/backimages/main_69.gif");
	height:20px;
	text-align:center;
	padding-top:5px;
	position:fixed;
	bottom:0px;
	width:100%;
}
.style5 {
	margin-top:20px;
}
-->
</style>
</head>

<body>
<!-- 菜单 -->
<div class="style3">产品信息管理</div>
<div>
	<div>
	<img src="${pageContext.request.contextPath }/backimages/main_40.gif" class="style2">
	<a href="${pageContext.request.contextPath }/jsps/addProduct.jsp" target="center_right" class="style1">添加产品信息</a>
	</div>
	<div>
	<img src="${pageContext.request.contextPath }/backimages/main_46.gif" class="style2">
	<a href="allproduct.action" target="center_right" class="style1">查看产品信息</a>
	</div>
</div>

<div class="style3 style5">新闻资讯管理</div>
<div>
	<div>
	<img src="${pageContext.request.contextPath }/backimages/main_40.gif" class="style2">
	<!-- 该界面中的图书分类信息需要从数据库中先获取出来，因此添加图书信息的界面一定是先由一个servlet跳转过来的 -->
	<a href="${pageContext.request.contextPath }/jsps/addNews.jsp" target="center_right" class="style1">添加新闻资讯</a>
	</div>
	<div>
	<img src="${pageContext.request.contextPath }/backimages/main_46.gif" class="style2">
	<a href="allnews.action" target="center_right" class="style1">查看新闻资讯</a>
	</div>
</div>
<div class="style3 style5">工程案例管理</div>
<div>
	<div>
	<img src="${pageContext.request.contextPath}/backimages/main_40.gif" class="style2">
	<a href="${pageContext.request.contextPath }/jsps/addProject.jsp" target="center_right" class="style1">添加工程案例</a>
	</div>
	<div>
	<img src="${pageContext.request.contextPath}/backimages/main_46.gif" class="style2">
	<a href="allproject.action" target="center_right" class="style1">查看工程案例</a>
	</div>
</div>
<div class="style3 style5">联系我们</div>
<div>
	<div>
	<img src="${pageContext.request.contextPath}/backimages/main_40.gif" class="style2">
	<a href="allemail.action" target="center_right" class="style1">邮件信息</a>
	</div>
	<div>
	<img src="${pageContext.request.contextPath}/backimages/main_40.gif" class="style2">
	<a href="alljob.action" target="center_right" class="style1">招聘信息</a>
	</div>
</div>
<div class="style3 style5">数据库管理</div>
<div>
	<div>
	<img src="${pageContext.request.contextPath}/backimages/main_40.gif" class="style2">
	<a href="${pageContext.request.contextPath}/jsps/orderAnalysis.jsp" target="center_right" class="style1">备份数据库</a>
	</div>
	<div>
	<img src="${pageContext.request.contextPath}/backimages/main_46.gif" class="style2">
	<a href="${pageContext.request.contextPath}/servlet/DBServlet?method=listBackup" target="center_right" class="style1">恢复数据库</a>
	</div>
</div>
<div class="style4">版本：2012 v1.1</div>
</body>
</html>
