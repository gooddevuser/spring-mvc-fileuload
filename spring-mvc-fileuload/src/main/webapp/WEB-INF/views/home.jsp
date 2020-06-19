<%@ page session="false" pageEncoding="UTF-8" %>

<html>
<head>
	<title>Home</title>	
</head>
<body>
	<br /><br /><br />
	<div style="padding-left:20px">
		
		<h2>Spring MVC File Upload Download Demo</h2>
		
		<img id="myfile1" style="width:150px;height:150px;margin:10px">
		<img id="myfile2" style="width:150px;height:150px;margin:10px">		
		<form action="/spring-mvc-fileupload/demo/upload" 
			  method="post" enctype="multipart/form-data">
			<input type="file" name="myfile" data-idx="1">
			<br><br>
			<input type="file" name="myfile" data-idx="2">
			<br><br>
			<input type="submit" value="업로드" />
		</form>		
		<hr>		
		<a href="/spring-mvc-fileupload/demo/download">다운로드</a>		
	</div>
	<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
	<script type="text/javascript">
	$(function() {
		$('input[name=myfile]').on('change', function(event) {
			var idx = $(this).attr('data-idx');

			if (this.files && this.files[0]) { //파일선택기의 파일 선택 확인
				var reader = new FileReader();

				//파일을 다 읽었을 때 호출할 함수 지정
				reader.onload = function(e) {
					$('#myfile' + idx).attr('src', e.target.result);
				};

				reader.readAsDataURL(this.files[0]); // 파일 읽기
			}
			
		});
	});
	</script>
</body>
</html>










