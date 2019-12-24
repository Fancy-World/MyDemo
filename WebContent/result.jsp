<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>结果页</title>
	<link rel="stylesheet" type="text/css" href="/Random_row_call/css/result-master.css">

	<!-- 引入切换底部poem的脚本 -->
	<script type="text/javascript" src="/Random_row_call/js/changepoems.js"></script>

	<!-- 引入“点名卡片”的点击事件脚本 -->
	<script type="text/javascript" src="/Random_row_call/js/selectCard.js"></script>
</head>

<!-- 用于小小卡片的颜色显示 -->
<script type="text/javascript">
	//这里需要一个颜色数组
	var colorArr = ["#394a6d","#3c9d9b","#52de97","#f6da63","#36b5b0",
		"#6ba8a9","#f09595","#1f6650"],colorNum = colorArr.length;
	var colorRandom = 0;  //用于随机（顺序）显示颜色
</script>
<body>
<%
String [] studentsArr = (String[])request.getAttribute("studentsArr");
int personNum = (Integer)session.getAttribute("personNum");
%>

<!-- 顶部超链接 -->
	<div class="header">
		<span>随机点名</span>
		<a href="index.jsp" id="index"><span>首页</span></a>
		<a href="">重点</a>
		<a href="customize.jsp">重置人数</a>
		<a href="javascript:saveStudent();" style="margin-left:407px;">保存名单</a>
		<span id="lateStudents"></span>
	</div>
	
	
	<div class="cardSet" id="cardSet">
		<!-- 这里有许多的card -->
		<div class="littlecard"  id="theFirstLittleCard">幸运名单</div>
	</div>
	
	<div class="outputWrap">
		<div class="output">
			
			<div class="card" id="card">
				
			</div>
			<span id="show"></span>
			<div class="select">
				<div class="false" id="cuowu">NO</div>
				<div class="right" id="right">YES</div>
			</div>		
		</div>
	</div>
	<footer>
		<p id="poem">天南地北双飞客，老翅几回寒暑</p>
	</footer>

<!-- 将java脚本中的数据传入js数组中 -->
<script type="text/javascript">
	var personNum = <%=personNum%>;
	var cardNum = personNum;   //用于准确地删除卡片
	//将姓名数组传递到js中
    var studentArr = new Array();

<%
	for(int i = 0;i<personNum;i++){
%>
		studentArr[<%=i%>] = "<%=studentsArr[i]%>";
<%		
	}
%>	
</script>

<!-- 初始化结果页（生成“点名卡片”） -->
<script type="text/javascript" src="/Random_row_call/js/initResult.js"></script>

<!-- 定义两个彩色按钮的单击事件 -->
<script type="text/javascript">
	//记录未到学生人数.
	var lateStudentNum = 0;
	//分别定义right和false的单击事件
	var right =document.getElementById("right");
	var cuowu = document.getElementById("cuowu");
	
	right.onclick = rightClick;
	
	cuowu.onclick = falseClick;
</script>

<form action="HandleLateStudentServlet" method="post" id="form">
	<input type="submit" id="submit" value="提交" style="display:none;"/>
</form> 

<!-- 用于保存翘课学生名单的脚本(其指向一个表单，表单指向处理学生的servlet -->
<script type="text/javascript">
//模拟点击提交
function saveStudent(){
	if((personNum<1)&&(lateStudentNum!=0)){
		var submit = document.getElementById("submit");
		submit.click();
	}
}
</script>

<!-- 执行切换poem的脚本 -->
<script type="text/javascript">
	changePoems();
</script>
</body>
</html>    