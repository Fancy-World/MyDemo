<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>自定义</title>
	<link rel="stylesheet" href="/Random_row_call/css/customize-master.css" type="text/css"/>

	<!-- 引入底部切换poem的js脚本 -->
	<script type="text/javascript" src="/Random_row_call/js/changepoems.js"></script>

	<!-- 引入提醒当用户输入大于excel中的总人数时，弹出弹窗提醒用户输入有误 -->
	<script type="text/javascript" src="/Random_row_call/js/customizeReminderWindow.js"></script>
</head>
<body>
<%
request.setCharacterEncoding("utf-8");
//当用于输入的人数大于excel中的总人数时，重新回到这个页面，并且带着总人数
//（用于提醒用户）。
String num = request.getParameter("num");
System.out.println(num);
int stuNum = -1;
if(num!=null){
	stuNum = Integer.parseInt(num);
}

%>
	<div class="none" id="wrap">
	<!-- 一个半透的黑色蒙版 -->
	</div>
	<div class="header">
		<span>随机点名</span>
		<a href="index.jsp"><span>首页</span></a>
	</div>
	<div class="container-wrap">
		<div class="title">请输入人数</div>
		<div class="container">
			<form method="get" action="HandleInputNum">
				<div class="label">人数</div	><input type="text" name="number"  class="number"/><br/>
				<input type="submit" name="" value="生&nbsp;&nbsp;成" class="btn"/>
			</form>
		</div>
	</div>
	
	<div class="footer">
		<p id="poem">“南朝四百八十寺，多少楼台烟雨中”</p>
	</div>
	
<%
//当用户输入的人数大于excel中的总人数时，弹出弹窗提醒用户。
//js可以套在java的选择语句中，反之不可（会出现意想不到的问题）。
if(num!=null){
	if(stuNum>0){
		
%>
<script type="text/javascript">
	var stuNum = <%=stuNum%>;
	createLittleWindow(stuNum);
</script>
<%
	}
}
%>

<!-- 执行切换poem的脚本(当重新加载本页时) -->
<script type="text/javascript">	
changePoems();
</script>

</body>
</html>