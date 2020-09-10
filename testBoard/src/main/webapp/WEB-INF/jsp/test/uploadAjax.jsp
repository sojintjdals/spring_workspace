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
</head>
<body>
	<h3>Ajax File Upload</h3>
	<div class="fileDrop"></div>

	<div class="uploadedList"></div>
</body>
<script src="https://code.jquery.com/jquery-3.5.1.min.js"
	integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0="
	crossorigin="anonymous"></script>
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

						function checkImageType(fileName) {

							var pattern = /jpg|gif|png|jpeg/i;

							return fileName.match(pattern);
						}

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

										if (checkImageType(data)) {
											str = "<div>"
													+ "<img src='/test/displayFile.do?fileName="
													+ data + "'/>" + data
													+ "</div>";
											alert("1");
										} else {
											str = "<div>" + data + "</div>";
											alert("2");
										}
										$(".uploadedList").append(str);
									}
								})

					});
</script>
</html>