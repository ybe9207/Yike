<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>所有图书分类列表</title>
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
.STYLE21,.STYLE22 {
	font-size: 12px;
	color: #3b6375;
} {
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
                <td width="94%" valign="bottom"><span class="STYLE1"> 图书分类信息列表</span></td>
              </tr>
            </table></td>
            <!-- 主要分担的是界面的工具栏  -->
            <td>
              <div align="right"><span class="STYLE1">
              <input type="checkbox" name="checkbox11" id="checkbox11" />  
                  <a href="#" onclick="selectAll();" class="LINKSTYLE">全选</a> &nbsp;&nbsp;
              <img src="/BookStore/images/add.gif" width="10" height="10" /> 
                  <a href="#" onclick="add();" class="LINKSTYLE">添加</a> &nbsp; 
              <img src="/BookStore/images/del.gif" width="10" height="10" /> 
                  <a href="#" onclick="del();"  class="LINKSTYLE">删除</a> &nbsp;&nbsp;
              <img src="/BookStore/images/edit.gif" width="10" height="10" /> 
                  <a href="#" onclick="update();"  class="LINKSTYLE">编辑</a> &nbsp;</span>
              <span class="STYLE1"> &nbsp;</span></div>
           </td>
          </tr>
        </table></td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td><table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#a8c7ce" onmouseover="changeto();"  onmouseout="changeback();">
      <!-- 列表头 -->
      <tr>
        <td width="4%" height="20" bgcolor="d3eaef" class="STYLE10"><div align="center">
          <input type="checkbox" name="checkbox" id="checkbox" />
        </div></td>
        <td width="30%" height="20" bgcolor="d3eaef" class="STYLE6"><div align="center"><span class="STYLE10">图书分类编号</span></div></td>
        <td width="18%" height="20" bgcolor="d3eaef" class="STYLE6"><div align="center"><span class="STYLE10">分类名</span></div></td>
        <td width="28%" height="20" bgcolor="d3eaef" class="STYLE6"><div align="center"><span class="STYLE10">分类描述</span></div></td>
        <td width="20%" height="20" bgcolor="d3eaef" class="STYLE6"><div align="center"><span class="STYLE10">图书分类操作</span></div></td>
      </tr>
      
      <!-- 在这里循环回来的图书分类列表数据 -->
      <%@taglib uri="/WEB-INF/c.tld" prefix="c"%>
      <c:choose>
         <c:when test="${ not empty requestScope.categories}">
             <!-- 显示数据 -->
             <c:forEach items="${requestScope.categories}" var="categories">
                 <tr>
			        <td height="20" bgcolor="#FFFFFF"><div align="center">
			          <input type="checkbox" name="checkbox2" id="checkbox2" />
			        </div></td>
			        <td height="20" bgcolor="#FFFFFF" class="STYLE6"><div align="center"><span class="STYLE19">
			       		${ categories.id }
			        </span></div></td>
			        <td height="20" bgcolor="#FFFFFF" class="STYLE19"><div align="center">
			        	${ categories.name }
			        </div></td>
			        <td height="20" bgcolor="#FFFFFF" class="STYLE19"><div align="center">
			        	${ categories.description }
			        </div></td>
			        <td height="20" bgcolor="#FFFFFF"><div align="center" class="STYLE21">
			          <a href="${ pageContext.request.contextPath}/servlet/CategoryServlet?method=findCategoryByID&id=${categories.id}">编辑</a>
			           | 
			          <a href="${ pageContext.request.contextPath}/servlet/CategoryServlet?method=delete&id=${categories.id}">删除</a>
			           | 
			          <a href="#">明细</a>
			        </div></td>
			      </tr>
             </c:forEach>
         </c:when>
         <c:otherwise>
             <!-- 合并单元格，提示没有数据 -->
                <tr>
                   <td colspan="5">
                      <font color="red"><div align="center" class="STYLE21">
                                                 对不起，目前还没有图书分类列表信息...
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
        <td width="33%"><div align="left"><span class="STYLE22">&nbsp;&nbsp;&nbsp;&nbsp;共有<strong> 243</strong> 条记录，当前第<strong> 1</strong> 页，共 <strong>10</strong> 页</span></div></td>
        <td width="67%"><table width="312" border="0" align="right" cellpadding="0" cellspacing="0">
          <tr>
            <td width="49"><div align="center"><img src="${pageContext.request.contextPath}/images/main_54.gif" width="40" height="15" /></div></td>
            <td width="49"><div align="center"><img src="${pageContext.request.contextPath}/images/main_56.gif" width="45" height="15" /></div></td>
            <td width="49"><div align="center"><img src="${pageContext.request.contextPath}/images/main_58.gif" width="45" height="15" /></div></td>
            <td width="49"><div align="center"><img src="${pageContext.request.contextPath}/images/main_60.gif" width="40" height="15" /></div></td>
            <td width="37" class="STYLE22"><div align="center">转到</div></td>
            <td width="22"><div align="center">
              <input type="text" name="textfield" id="textfield"  style="width:20px; height:12px; font-size:12px; border:solid 1px #7aaebd;"/>
            </div></td>
            <td width="22" class="STYLE22"><div align="center">页</div></td>
            <td width="35"><img src="${pageContext.request.contextPath}/images/main_62.gif" width="26" height="15" /></td>
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