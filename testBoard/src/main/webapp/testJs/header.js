/**
 * 
 */
$(document).ready(function() {
		$("#register").click(function() {
			$("#frm").attr("action", "/test/mInsert.do");
			$("#frm").submit();
		});
		$("#loginmember").click(function() {
			$("#frm").attr("action", "/test/Login.do");
			$("#frm").submit();
		});
		$("#logout").click(function() {
			$("#frm").attr("action", "/test/logout.do");
			$("#frm").submit();
		});
		$("#memberView").click(function() {
			$("#frm").attr("action", "/test/mView.do");
			$("#frm").submit();
		});
});