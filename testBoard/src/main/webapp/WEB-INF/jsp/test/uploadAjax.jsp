<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	$(document).ready(
		$(".fileDrop").on("dragenter dragover", function(event) {
			event.preventDefault();
		})
		
			function checkImageType(fileName) {
			
			var pattern = /jpg|gif|png|jped/i;
			
			return fileName.match(pattern);
			
		}
		
		$(".fileDrop").on("drop", function(event) {
			event.preventDefault();
			
			$.ajax({
				url: '/uploadAjax',
				data: formData,
				dataType: 'text',
				processData: false,
				contentType: false,
				type: 'POST',
				success: function(data) {
				
					var str ="";
					
					console.log(data);
					console.log(checkImageType(data));
					
					if(checkImageType(data)){
						str = "<div>"
							+"<img src='displayFile?fileName="+data+"'/>"
							+data+"</div>";
					}else{
						str = "<div><a href='displayFile?fileName="
							+ data + "'>" + getOriginalName(data)+"</a></div>";
					}
					
					$(".uploadedList").append(str);
				}
			});
		})
		
		$(".uploadedList").on("click", "small", function(event) {
			
			var that = $(this);
			
			$.ajax({
				url:"deleteFile",
				type:"post",
				data: {fileName:$(this).attr("data-src")},
				dataType:"text",
				success: function(result) {
					if(result == 'deleted'){
						alert("deleted");
						that.parent("div").remove();
					}
				}
			})
		})
		
		function getImageLink(fileName) {
			
			if(!checkImageType(fileName)){
				return;
			}
			var front = fileName.substr(0,12);
			var end = fileName.substr(14);
			
			return front + end;
		}
		
		)
</script>
</head>
<body>
	<h3>Ajax File Upload</h3>
	<div class="fileDrop"></div>

	<div class="uploadedList"></div>
</body>
</html>