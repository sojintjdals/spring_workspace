<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.fileDrop {
	width: 100%;
	height: 800px;
	border: 1px solid black;
}
</style>
<script src="https://code.jquery.com/jquery-3.5.1.min.js"
	integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0="
	crossorigin="anonymous"></script>
</head>
<body>
	<h3>Ajax File Upload</h3>
	<div class="fileDrop"></div>

	<div class="uploadedList"></div>
</body>
<script type="text/javascript">
	$(".fileDrop").on("dragenter dragover", function(event) {
		event.preventDefault();
	});

	$(".fileDrop")
			.on(
					"drop",
					function(event) {
						event.preventDefault();

						var files = event.originalEvent.dataTransfer.files;
						var file = files[0];
						var formData = new FormData();

						formData.append("file", file);

						$
								.ajax({
									url : '/test/uploadAjax.do',
									data : formData,
									dataType : 'text',
									processData : false,
									contentType : false,
									type : 'POST',
									success : function(data) {

										var str = "";
										console.log(data);
										console.log(checkImageType);
										if (checkImageType(data)) {
											str = "<div>"
													+ "<img src='/test/displayFile.do?fileName="
													+ getImageLink(data)
													+ "'/><small data-src="+data+">X</small></div>";
										} else {
											str = "<div><a href='/test/displayFile.do?fileName="
													+ data
													+ "'>"
													+ getOriginalName(data)
													+ "</a><small data-src="+data+">X</small></div>";
											alert(data);
										}

										$(".uploadedList").append(str);
									}
								});
					});
	$(".uploadedList").on("click", "small", function(event) {

		var that = $(this);

		$.ajax({
			url : "/test/deleteFile.do",
			type : "post",
			data : {
				fileName : $(this).attr("data-src")
			},
			dataType : "text",
			success : function(result) {
				if (result == 'deleted') {
					that.parent("div").remove();
				}
			}
		});
	});

	function checkImageType(fileName) {

		var pattern = /jpg|gif|png|jpeg/i;

		return fileName.match(pattern);
	}

	//ㅋㅋ ppt에 안나오누
	function getOriginalName(fileName) {

		if (checkImageType(fileName)) {
			return;
		}

		var idx = fileName.indexOf("_") + 1;
		return fileName.substr(idx);

	}

	function getImageLink(fileName) {
		if (!checkImageType(fileName)) {
			return;
		}
		var front = fileName.substr(0, 12);
		var end = fileName.substr(14);

		return front + end;
	}
</script>
</html>