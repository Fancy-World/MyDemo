/**
 * 初始化结果页（生成“点名卡片”）
 */

//初始化结果页（生成“点名卡片”）
	//获得人数/卡片数
	var card = document.getElementById("card");
	for(var i =0;i<personNum;i++){
		//获得字符串：将字符串分割成单个字符
		var str = studentArr[i];
		//var str = "张子枫";
		var len = str.length;
		var s1,s2,s3,s4;
		if(len===3){
			s1 = str[0];
			s2 = "";
			s3 = str[1];
			s4 = str[2];
		}else if(len===4){
			s1 = str[0];
			s2 = str[1];
			s3 = str[2];
			s4 = str[3];
		}else if(len ===2){
			s1 = str[0];
			s4 = str[1];
			s2 = "";
			s3 = "";
		}
		
		var div = document.createElement("DIV");
		div.className="cards";
		var table = document.createElement("TABLE");
		
		var tr1 = document.createElement("tr");
		var tr2 = document.createElement("tr");
		var td1 = document.createElement("td");
		var textNode1 = document.createTextNode(s1);
		td1.appendChild(textNode1);
		var td2 = document.createElement("td");
		var textNode2 = document.createTextNode(s2);
		td2.appendChild(textNode2);
		var td3 = document.createElement("td");
		var textNode3 = document.createTextNode(s3);
		td3.appendChild(textNode3);
		var td4 = document.createElement("td");
		var textNode4 = document.createTextNode(s4);
		td4.appendChild(textNode4);
		
		tr1.appendChild(td1);
		tr1.appendChild(td2);
		tr2.appendChild(td3);
		tr2.appendChild(td4);
		
		table.appendChild(tr1);
		table.appendChild(tr2);
		
		div.appendChild(table);
		div.id ="card"+i;
		card.appendChild(div);
	}
	//每个card都有一个最大为personNum-1的id值