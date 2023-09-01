<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>유저리스트</h3>
	<table border="1">
	<thead>
		<tr>
			<th>번호</th>
			<th>이름</th>
			<th>아이디</th>
		
		</tr>
	</thead>
	<tbody id="tBody"></tbody>
	
	</table>
	<script>
	function goPage(num){
	      location.href='/views/one?num='+num;
		}
	const loadFunc =function(){
		let url='/user-info/list';
		const xhr =new XMLHttpRequest();
		xhr.open('GET',url);
		xhr.onreadystatechange=function(){
			if(xhr.readyState===4){
				if(xhr.status===200){
					const list =JSON.parse(xhr.responseText);
					let html='';
					for(const user of list){
						html+='<tr>'
						html+='<td>'+user.uiNum+'</td>';
						html+='<td><a href="/views/user-info/view?uiNum='+user.uiNum+'">'+user.uiName+'</a></td>';
						html+='<td>'+user.uiId+'</td>';
						
							html+='</tr>'
					}
					  document.querySelector('#tBody').innerHTML=html;
				}
			}
		}
		xhr.send();
	}
	window.addEventListener('load',loadFunc);
	
	</script>


</body>
</html>