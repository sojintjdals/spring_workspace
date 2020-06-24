<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	if (${resultDelete.seqno} == "") {
		response.sendRedirect("/test/list.do");
	} else {
		response.sendRedirect("/test/list.do");
	}
</script>
</head>
</html>