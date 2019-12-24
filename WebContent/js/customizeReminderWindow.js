/**
 * 当用户输入的人数大于excel中的总人数时，弹出弹窗提醒用户输入有误
 */

// 生成弹窗的js代码 -->

	function createLittleWindow(stuNum){
		var wrap =document.getElementById("wrap");
		wrap.className="";
		var div = document.createElement("div");
		div.style.width = "350px";
		div.style.height = "150px";
		div.style.background="white";
		div.style.position="absolute";
		div.style.zIndex="89";
		div.style.borderRadius="8px";
		div.style.boxShadow="0 1px 5px 1px rgba(0,0,0,0.2)";
		div.style.top = "50%";
		div.style.left="50%";
		div.style.marginLeft="-175px";
		div.style.marginTop="-105px";
		
		var p = document.createElement("p");
		p.style.textAlign="center";
		p.style.fontSize="25px";
		p.style.color="#2b3f55";
		p.style.marginTop = "20px";
		var textNodeP = document.createTextNode("您只有"+stuNum+"个学生呦");
		p.appendChild(textNodeP);
		var btn =document.createElement("button");
		var btnTextNode = document.createTextNode("确定");
		btn.appendChild(btnTextNode);
		btn.style.border="none";
		btn.style.cursor="pointer";
		btn.style.width="100px";
		btn.style.height="40px";
		btn.style.fontSize="25px"
		btn.style.lineHeight="25px";
		btn.style.margin="18px 130px";
		btn.style.borderRadius="8px";
		btn.style.fontWeight="lighter";
		btn.style.background="#41b883";
		btn.style.color="white";
		
		div.appendChild(p);
		div.appendChild(btn);
		
		document.body.appendChild(div);
		
		btn.onclick = function(){
			document.body.removeChild(div);
			wrap.className="none";
		}
	}
