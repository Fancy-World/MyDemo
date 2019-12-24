/**
 * “点名卡片”的点击事件
 */

function rightClick(){
		//当点击正确时（标明没有旷课）:这个块将会从屏幕左上角飞离
		personNum = personNum-1;
		var card = document.getElementById("card"+personNum);
		var show =document.getElementById("show");
		card.style.transform = "translateY(-400px)";
		card.style.opacity="0";
		window.setTimeout(function(){
			card.style.display="none";
		},1000);
}

function falseClick(){
	//未到人数加一
	personNum =personNum-1;
	//创建隐藏表单
	if(personNum>=0){
		var input = document.createElement("input");
		input.type="checkbox";
		input.value=studentArr[personNum];
		input.name="lateStudents";
		input.checked="checked";
		input.style="display:none";
		var form =document.getElementById("form");
		form.appendChild(input);
	}
	
	lateStudentNum++;
	var card =document.getElementById("card"+personNum);
	card.style.transform = "translate(270px,-114px) scale(0.1,0.1)";
	card.style.opacity="0.4";
	window.setTimeout(function(){
		card.style.opacity="0";
		card.style.display="none";
	},700)
	createLittlecard();
	var lateStudents = document.getElementById("lateStudents")
	if(lateStudentNum!=1){
		lateStudents.innerHTML = "";
	}
	var lateStudentsTextNode =document.createTextNode("翘课人数："+lateStudentNum);
	lateStudentsTextNode.id="lateStudent";
	lateStudents.appendChild(lateStudentsTextNode);
}

//创建小块
function createLittlecard(){
	//创建文本节点存放学生姓名
	var textNodeLittleCard = document.createTextNode(studentArr[personNum]);
	var littleCard = document.createElement("div");
	littleCard.className="littlecard";
	littleCard.appendChild(textNodeLittleCard);
	var cardSet = document.getElementById("cardSet");
	littleCard.style.background=colorArr[colorRandom];
	colorRandom = colorRandom + 1;
	if(colorRandom>=colorNum){
		colorRandom=0;
	}
	//为了防止用户快速点击no，而出现异常，所以将延迟放在这里。
	window.setTimeout(function(){
		cardSet.appendChild(littleCard);
	},600);
}