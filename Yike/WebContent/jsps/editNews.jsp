<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>编辑新闻资讯</title>
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
.STYLE19 {
	color: #344b50;
	font-size: 12px;
}
form{
  margin-top: 40px;
}
.showbookimage{
  position: fixed;
  left: 65%;
  top: 12%;
}
</style>
</head>
<body>
   <!-- 顶层模板 -->
   <table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
   <tr>
    <td height="30">
     <table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td height="24" bgcolor="#353c44"><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td width="6%" height="19" valign="bottom"><div align="center"><img src="/BookStore/backimages/tb.gif" width="14" height="14" /></div></td>
                <td width="94%" valign="bottom" style="text-align: center"><span class="STYLE1"><font size="5px"><strong>编辑新闻资讯</strong></font></span></td>
              </tr>
     </table>
    </td>
    </tr>
    </table>
    </td>
    </tr>
    </table>
    </td>
    </tr>
    </table>
    <!-- 提交表单，注意该表单有上传的数据必须将 enctype=multipart/form-data -->
    <form action="savenews.action" method="post">
    	<input type="hidden" name="id" value="${ requestScope.news.id }"/> 
    	<!-- 当用户修改了图书的图片，那么删除原来的图片 -->
    	<table width="600px;" class="form_table" align="center">
		<tr>
    		<td bgcolor="#FFFFFF" class="STYLE19">新闻标题：</td>
    		<td><input type="text" name="head" style="width:200px;height:20px" value="${ requestScope.news.head}"></td>
    	</tr>
    	<tr>
    		<td bgcolor="#FFFFFF" class="STYLE19">新闻来源：</td>
    		<td><input type="text" name="newsfrom" style="width:300px;height:20px" value="${ requestScope.news.newsfrom}">
    		</td>
    	</tr>
    	<tr>
    		<td bgcolor="#FFFFFF" class="STYLE19">新闻类别：</td>
    		<td>
    		<select name="category">
    		<option value="行业资讯" ${ requestScope.news.category == '行业资讯' ? "selected":"" }>行业资讯</option>
    		<option value="企业新闻" ${ requestScope.news.category == '企业新闻' ? "selected":"" }>企业新闻</option>
    		</select>
    		</td>
    	</tr>
    	<tr>
    		<td bgcolor="#FFFFFF" class="STYLE19">导读：</td>
    		<td><textarea rows="2" name="guideread" style="width:300px;height:60px">${ requestScope.news.guideread}</textarea></td>
    	</tr>
    	<tr>
    		<td bgcolor="#FFFFFF" class="STYLE19">新闻内容：</td>
    		<td><textarea rows="4" name="content" style="width:450px;height:200px">${ requestScope.news.content}</textarea></td>
    	</tr>
    	<tr>
    		<td><br><br></td><td><input type="submit" value="保存"></td>
    	</tr>
    	</table>
    </form>
</body>
</html>