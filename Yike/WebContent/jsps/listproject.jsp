<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>所有工程案例列表</title>
<style type="text/css">
body {
	margin-left: 3px;
	margin-top: 0px;
	margin-right: 3px;
	margin-bottom: 0px;
}
.STYLE1 {
	color: #e1e2e3;
	font-size: 12px;
}
.STYLE6 {
    color: #000000; 
    font-size: 12px; 
    }
.STYLE10 {
    color: #000000; 
    font-size: 12px; 
    }
.STYLE19 {
	color: #344b50;
	font-size: 12px;
}
.STYLE21,.STYLE22{
	font-size: 12px;
	color: #3b6375;
}
.LINKSTYLE{
    color: #ffffff;
	font-size: 12px;
	text-decoration: none;
	margin-right:5px
}
a{
   text-decoration: none;
}
</style>
</head>
<body>
<!-- 页面头部信息处理 -->
<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td height="30"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td height="24" bgcolor="#353c44"><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td width="6%" height="19" valign="bottom"><div align="center"><img src="/BookStore/images/tb.gif" width="14" height="14" /></div></td>
                <td width="94%" valign="bottom" style="text-align:center"><span class="STYLE1"> <font size="5px"><strong>工程案例列表</strong></font></span></td>
              </tr>
            </table></td>
          </tr>
        </table></td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td><table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#a8c7ce" onmouseover="changeto();"  onmouseout="changeback();">
      <!-- 列表头 -->
      <tr>
        <td width="15%" height="20" bgcolor="d3eaef" class="STYLE6"><div align="center"><span class="STYLE10">案例标题</span></div></td>
        <td width="5%" height="20" bgcolor="d3eaef" class="STYLE6"><div align="center"><span class="STYLE10">案例种类</span></div></td>
        <td width="25%" height="20" bgcolor="d3eaef" class="STYLE6"><div align="center"><span class="STYLE10">描述</span></div></td>
        <td width="25%" height="20" bgcolor="d3eaef" class="STYLE6"><div align="center"><span class="STYLE10">图片</span></div></td>
        <td width="13%" height="20" bgcolor="d3eaef" class="STYLE6"><div align="center"><span class="STYLE10">产品操作</span></div></td>
      </tr>
      
      <!-- 在这里循环回来的图书分类列表数据 -->
      <%@taglib uri="/WEB-INF/c.tld" prefix="c"%>
      <c:choose>
         <c:when test="${ not empty requestScope.page.list}">
             <!-- 显示数据 -->
             <c:forEach items="${requestScope.page.list}" var="project">
                 <tr>
			        <td height="20" bgcolor="#FFFFFF" class="STYLE19"><div align="center">
			        	${ project.head }
			        </div></td>
			        <td height="20" bgcolor="#FFFFFF" class="STYLE19"><div align="center">
			        	${ project.category }
			        </div></td>
			        <td height="20" bgcolor="#FFFFFF" class="STYLE19"><div align="center">
			        	${ project.text }
			        </div></td>
			        <!-- 注意在显示图片路径的时候是没有意义的，因此这里提供一个超链接使得用户单击的时候可以查看图片 -->
			        <td height="20" bgcolor="#FFFFFF" class="STYLE19">
			        <div align="center">
			            <img style="width:200px;height:100px" src="${pageContext.request.contextPath}/upload/${project.imageurl}.jpg"/>
			        </div>
			        </td>
			        <td height="20" bgcolor="#FFFFFF"><div align="center" class="STYLE21">
			          <a href="editproject.action?id=${project.id}" onclick="javascipt: return window.confirm('您真的要编辑【${project.head}】案例吗?')">编辑</a>|
			          <a href="delproject.action?id=${project.id}" onclick="javascipt: return window.confirm('您真的要删除【${project.head}】案例吗?')">删除</a>
			        </div></td>
			      </tr>
             </c:forEach>
         </c:when>
         <c:otherwise>
             <!-- 合并单元格，提示没有数据 -->
                <tr>
                   <td colspan="5">
                      <font color="red"><div align="center" class="STYLE21">
                                                 对不起，目前还没有工程案例信息列表信息...
                      </div></font>
                   </td>
                </tr>
         </c:otherwise>
      </c:choose>
    </table></td>
  </tr>  
  
   <!-- 分页条处理 -->
  <tr>
    <td height="30"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="60%"><div align="left" class="pages"><span class="STYLE22">&nbsp;&nbsp;&nbsp;&nbsp;
                      共<strong>${page.allCount}</strong>记录 &nbsp;
                      当前第<strong>${page.currentPage }</strong>页&nbsp;
                      共 <strong>${page.allPage }</strong>页</span>
        &nbsp;&nbsp;&nbsp;&nbsp;
        <c:forEach begin="${page.begin}" end="${page.end}" var="num"> 
           <a class="STYLE22" href="allproject.action?currentPage=${num}">${num}</a>
        </c:forEach>
        </div></td>
        <td width="80%"><table width="312" border="0" align="right" cellpadding="0" cellspacing="0">
          <tr>
            <td width="44"><div align="center"><a href="allproject.action?currentPage=1"><img src="${pageContext.request.contextPath}/backimages/main_54.gif" width="40" height="15" /></a></div></td>
            <c:if test="${page.currentPage!=1 }">
            <td width="44"><div align="center"><a href="allproject.action?currentPage=${page.currentPage-1 }"><img src="${pageContext.request.contextPath}/backimages/main_56.gif" width="45" height="15" /></a></div></td>
            </c:if>
            <c:if test="${page.currentPage!=page.allPage }">
            <td width="44"><div align="center"><a href="allproject.action?currentPage=${page.currentPage+1 }"><img src="${pageContext.request.contextPath}/backimages/main_58.gif" width="45" height="15" /></a></div></td>
            </c:if>
            <td width="44"><div align="center"><a href="allproject.action?currentPage=${page.allPage }"><img src="${pageContext.request.contextPath}/backimages/main_60.gif" width="40" height="15" /></a></div></td>
            <td width="37" class="STYLE22"><div align="center">转到</div></td>
            <td width="22"><div align="center">
            <form name="form1" method="post" action="allproject.action">
            <input type="text" name="currentPage" id="textfield"  style="width:20px; height:20px; font-size:12px; border:solid 1px #7aaebd;"/>
            </form></div></td>
            <td width="22" class="STYLE22"><div align="center">页</div></td>
            <td width="35"><a onclick="form1.submit()"><img src="${pageContext.request.contextPath}/backimages/main_62.gif" width="26" height="15" /></a></td>
          </tr>
        </table></td>
      </tr>
    </table></td>
  </tr>
</table>
</body>
<script type="text/javascript">
  function selectAll(){
     alert("selected");
  }
  function add(){
     alert("add");
  }
  function del(){
     alert("delete");
  }
   function update(){
     alert("update");
  }
</script>
</html>