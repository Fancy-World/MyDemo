/**
 * 此js脚本用于当用于没有上传文件却点击了提交按钮时弹出弹窗
 */
// 提醒输入的小弹窗 
function noname(){
		var wrap =document.getElementById("wrap");
		wrap.className ="";
		var div = document.createElement("DIV");
		var p =document.createElement("P");
		var btn = document.createElement("BUTTON");
		
		div.style.width = "350px";
		div.style.height = "150px";
		div.style.position = "absolute";
		div.style.top = "50%";
		div.style.left="50%";
		div.style.marginLeft="-175px";
		div.style.marginTop="-105px";
		div.style.background ="white";
		div.style.borderRadius="9px";
		div.style.boxShadow="0 1px 5px 1px rgba(0,0,0,0.2)";
		div.style.zIndex="10";
		
		p.style.textAlign="center";
		p.style.fontSize="30px";
		p.style.color="#2b3f55";
		var textNode = document.createTextNode("请选择Excel文件"),
			btnText =document.createTextNode("确定");
		btn.appendChild(btnText);
		btn.style.border="none";
		btn.style.cursor="pointer";
		p.appendChild(textNode);
		div.appendChild(p);
		p.style.marginTop = "20px";
		
		btn.style.width="100px";
		btn.style.height="40px";
		btn.style.fontSize="25px"
		btn.style.lineHeight="25px";
		btn.style.margin="18px 130px";
		btn.style.borderRadius="8px";
		btn.style.fontWeight="lighter";
		btn.style.background="#41b883";
		btn.style.color="white";
		div.appendChild(btn);
		document.body.appendChild(div);
		
		btn.onclick = function(){
			document.body.removeChild(div);
			wrap.className = "none";
		}
	}