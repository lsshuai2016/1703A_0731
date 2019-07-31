<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="/resource/css/bootstrap.min.css" rel="stylesheet">
<script type="text/javascript" src="/resource/js/jquery-3.2.1.js"></script>

</head>
<body>
<div class="container">
<h3>发布图片集</h3>
<form action="/pics/publishpic" method="post" enctype="multipart/form-data" id="form1">
	<div>
		<button type="button" class="btn btn-warning" onclick="add()">增加</button>
		<button type="button" class="btn btn-success" onclick="publish()">发布</button>
	</div>
	<div class="form-group">
		<label>标题</label>
		<input type="text" class="form-control" name="title">
	</div>
	<div id="mdiv" class="card">
		<div class="card-body" style="float: left;width: 400px;">
			<div class="form-group">
				<input type="file" name="files">
			</div>
			<div class="form-group" style="float: left;">
				<textarea rows="5" cols="40" name="picContents"></textarea>
			</div>
		</div>
	</div>
</form>
</div>
<script type="text/javascript">
	function add(){
		$("#mdiv").append("<div class='card-body' style='float:left;width: 400px;'> <div class='form-group'> <input type='file' name='files'> </div> <div class='form-group' style='float: left;'> <textarea rows='5' cols='40' name='picContents'></textarea> </div> </div>");
	}
	function publish(){
		$("#form1").submit();
	}
</script>
</body>
</html>