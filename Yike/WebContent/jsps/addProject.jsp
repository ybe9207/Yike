<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加工程案例</title>
<style type="text/css">
body {
	margin-left: 3px;
	margin-top: 0px;
	margin-right: 3px;
	margin-bottom: 0px;
}

.STYLE1 {
	color: #e1e2e3;
	font-size: 25px;
}

.STYLE19 {
	color: #344b50;
	font-size: 12px;
}

form {
	margin-top: 40px;
}
/* 图片预览功能的样式  */
#preview {
	width: 150px;
	height: 150px;
	border: 1px solid #000;
	overflow: hidden;
	display: inline;
	position: absolute;
	top: 20%;
	left:70%;
}

#imghead {
	filter: progid : DXImageTransform.Microsoft.AlphaImageLoader (
	sizingMethod = image );
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
                <td width="6%" height="19" valign="bottom"><div align="center"><img src="/backimages/tb.gif" width="14" height="14" /></div></td>
                <td width="94%" valign="bottom" style="text-align: center"><span class="STYLE1">添加工程案例</span></td>
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
    <form action="addproject.action" method="post" enctype="multipart/form-data">
    	<table width="500px;" class="form_table" align="center">
    	<tr>
    		<td bgcolor="#FFFFFF" class="STYLE19">工程标题：</td>
    		<td><input type="text" name="projectname" style="width:300px;height:20px" ></td>
    	</tr>
    	<tr>
    		<td bgcolor="#FFFFFF" class="STYLE19">图片：</td>
    		<td>
    		   <input type="file" name="file" onchange="previewImage(this)"/>
    		   <!-- 显示图片预览区域 -->
			   <div id="preview">
					<img id="imghead" alt="   预览图片区域    "/>
			   </div>
			</td>
    	</tr>
    	<tr>
    		<td bgcolor="#FFFFFF" class="STYLE19">工程类别：</td>
    		<td>
    		<select name="category" style="height:30px;width:90px">
    		<option value="体育设施">体育设施</option>
    		<option value="交通设施">交通设施</option>
    		<option value="文化设施">文化设施</option>
    		<option value="商业设施">商业设施</option>
    		<option value="工业设施">工业设施</option>
    		<option value="景观设施">景观设施</option>
    		</select>
    		</td>
    	</tr>
    	<tr>
    		<td bgcolor="#FFFFFF" class="STYLE19">描述：</td>
    		<td><textarea rows="4" name="description" style="width:300px;height:200px"></textarea></td>
    	</tr>
    	<tr>
    		<td><br><br></td><td><input type="submit" value="保存"></td>
    	</tr>
    	</table>
    </form>
    <!--脚本实现：跨浏览器实现图片预览 -->
    <script type="text/javascript">
	function previewImage(file) {
		var MAXWIDTH = 150;
		var MAXHEIGHT = 150;
		var div = document.getElementById('preview');
		if (file.files && file.files[0]) {
			div.innerHTML = '<img id=imghead>';
			var img = document.getElementById('imghead');
			img.onload = function() {
				var rect = clacImgZoomParam(MAXWIDTH, MAXHEIGHT,
						img.offsetWidth, img.offsetHeight);
				img.width = rect.width;
				img.height = rect.height;
				img.style.marginLeft = rect.left + 'px';
				img.style.marginTop = rect.top + 'px';
			}
			var reader = new FileReader();
			reader.onload = function(evt) {
				img.src = evt.target.result;
			}
			reader.readAsDataURL(file.files[0]);
		} else {
			var sFilter = 'filter:progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=scale,src="';
			file.select();
			var src = document.selection.createRange().text;
			div.innerHTML = '<img id=imghead>';
			var img = document.getElementById('imghead');
			img.filters.item('DXImageTransform.Microsoft.AlphaImageLoader').src = src;
			var rect = clacImgZoomParam(MAXWIDTH, MAXHEIGHT, img.offsetWidth,
					img.offsetHeight);
			status = ('rect:' + rect.top + ',' + rect.left + ',' + rect.width
					+ ',' + rect.height);
			div.innerHTML = "<div id=divhead style='width:" + rect.width
					+ "px;height:" + rect.height + "px;margin-top:" + rect.top
					+ "px;margin-left:" + rect.left + "px;" + sFilter + src
					+ "\"'></div>";
		}
	}
	function clacImgZoomParam(maxWidth, maxHeight, width, height) {
		var param = {
			top :0,
			left :0,
			width :width,
			height :height
		};
		if (width > maxWidth || height > maxHeight) {
			rateWidth = width / maxWidth;
			rateHeight = height / maxHeight;

			if (rateWidth > rateHeight) {
				param.width = maxWidth;
				param.height = Math.round(height / rateWidth);
			} else {
				param.width = Math.round(width / rateHeight);
				param.height = maxHeight;
			}
		}

		param.left = Math.round((maxWidth - param.width) / 2);
		param.top = Math.round((maxHeight - param.height) / 2);
		return param;
	}
</script>
</body>
</html>