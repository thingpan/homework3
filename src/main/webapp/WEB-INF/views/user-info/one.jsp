<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	번호:
	<span id="num">${param.num}</span>
	<br> 이름:
	<span id="name"></span>
	<br> 아이디:
	<span id="id"></span>
	<button onclick="goPage('/views/update?num=${param.num}')">수정</button>
	<button onclick="deleteObj()">삭제</button>
	<script>
function deleteObj(){
	const xhr= new XMLHttpRequest();
	xhr.open('POST','/list/delete?num=${param.num}');
	xhr.onreadystatechange=function(){
		if(xhr.readyState ===4){
			if(xhr.status ===200){
				if(xhr.responseText==='1'){
					alert('삭제완료');
					
				}else{
					alert('삭제불가');
			
				}
				location.href='/views/list';
				}			
			}
		}
	xhr.send()
	}
function goPage(url){
	location.href=url;
}
		window.addEventListener('load',function(){
			const xhr = new XMLHttpRequest
			xhr.open('GET','/list/one?num='+${param.num});
			xhr.onreadystatechange=function(){
				if(xhr.readyState ===4){
					if(xhr.status ===200){
						const obj =JSON.parse(xhr.responseText);
					for(const key in obj){
						document.querySelector('#'+key).innerText=obj[key];
					}
						
					}
				}
			}
			xhr.send();
		})
</script>
</body>
</html>