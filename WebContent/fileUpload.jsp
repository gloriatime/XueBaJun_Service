<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*" isELIgnored="false"%>
<html>
<head>
<title>Spring MVC上传文件示例</title>
</head>
<body>
    <form action="fileUploadPage" method="post" enctype="multipart/form-data">
      	请选择一个文件上传 : 
      <input type="file" name="file" />
        <input type="submit" value="提交上传" />
    </form>
</body>
</html>
