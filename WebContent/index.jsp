<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>主页</title>
	<link rel="stylesheet" href="/Random_row_call/css/index-master.css" type="text/css"/>
	<!-- 引入切换底部poem的js脚本 -->
	<script type="text/javascript" src="/Random_row_call/js/changepoems.js"></script>
	
	<!-- 引入提醒用户上传文件的弹窗js脚本 -->
	<script type="text/javascript" src="/Random_row_call/js/indexReminderWindow.js"></script>
	
	<!-- 解决文件上传框点击问题的脚本 -->
	<script type="text/javaScript">
		function fileClick(){
			var file = document.getElementById("file");
			file.click();
		}
	</script>

</head>
<body>
<%
	//System.out.println("这个路径为:"+request.getContextPath());
	//   /Random_row_call  -->项目绝对路径
	//判断是否是没有选择文件
	String msg = request.getParameter("msg");
	if(msg!=null){
		if(msg.equals("1")){
%>

	<div id="wrap" class="none">
	</div>
<script type="text/javascript">
	//当用于没有上传文件，却点击了提交按钮时，执行下面的js脚本：弹出弹窗。
	noname();
</script>
<%
		}
	}
%>

<!-- ************************************* -->
	<div class="total">
		<h1>随&nbsp;机&nbsp;点&nbsp;名&nbsp;</h1>
		<div class="container">
			<div class="label">
				<h2>请上传花名册</h2>
			</div>

			<div class="upload">
				<form action="HandleUploadServlet" method="post" enctype="multipart/form-data">
					<div class="file-wrap">
						<p style="font-size:18px;line-height:35px;color:white;z-index:2;" onclick="fileClick()">上传Excel</p>
						<input type="file" name="file" value="上传Excel文件" class="file" id="file"/>
					</div>
					<input type="submit" value="提&nbsp;&nbsp;&nbsp;&nbsp;交" class="btn"/>
				</form>
			</div>
		</div>	

		<footer>
			<p id="poem">望从斜阳欲尽时，不见西飞燕</p>
		</footer>
	</div>
	
	<!-- 执行切换底部poem的函数 -->
	<script type="text/javaScript">
		changePoems();
	</script>
</body>
</html>    