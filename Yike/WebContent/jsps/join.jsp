<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>所有招聘信息列表</title>
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
<div>
	<div align="center"><font size="3" color="red">发布招聘信息</font></div>
	<div style="margin-left: 300px">
		<form action="addjob.action" method="post">
			职位名称：<input type="text" name="jobname"/><br/>
			招聘内容：<textarea rows="4" name="jobtext" style="width:450px;height:200px"></textarea><br/><br/>
			<input type="submit" value="保存"/>
		</form>
	</div>
</div>
<br/>
<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td height="30"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td height="24" bgcolor="#353c44"><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td width="6%" height="19" valign="bottom"><div align="center"><img src="/BookStore/images/tb.gif" width="14" height="14" /></div></td>
                <td width="94%" valign="bottom" style="text-align:center"><span class="STYLE1"> <font size="5px"><strong>招聘信息列表</strong></font></span></td>
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
        <td width="20%" height="20" bgcolor="d3eaef" class="STYLE6"><div align="center"><span class="STYLE10">招聘职位</span></div></td>
        <td width="70%" height="20" bgcolor="d3eaef" class="STYLE6"><div align="center"><span class="STYLE10">招聘信息 </span></div></td>
      	<td width="10%"  height="20" bgcolor="d3eaef" class="STYLE6"><div align="center"><span class="STYLE10">操作</span></div></td>
      </tr>
      
      <%@taglib uri="/WEB-INF/c.tld" prefix="c"%>
      <c:choose>
         <c:when test="${ not empty requestScope.page.list}">
             <!-- 显示数据 -->
             <c:forEach items="${requestScope.page.list}" var="join">
                 <tr>
			        <td height="20" bgcolor="#FFFFFF" class="STYLE19"><div align="center">
			        	${ join.jobname }
			        </div></td>
			        <td height="20" bgcolor="#FFFFFF" class="STYLE19"><div align="center">
			        	${ join.joinltext }
			        </div></td>
			        <td height="20" bgcolor="#FFFFFF" class="STYLE19"><div align="center">
			        	${ join.jointime }
			        </div></td>
			      </tr>
             </c:forEach>
         </c:when>
         <c:otherwise>
             <!-- 合并单元格，提示没有数据 -->
                <tr>
                   <td colspan="5">
                      <font color="red"><div align="center" class="STYLE21">
                                                 对不起，目前还没有招聘信息列表信息...
                      </div></font>
                   </td>
                </tr>
         </c:otherwise>
      </c:choose>
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