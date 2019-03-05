<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*" isELIgnored="false"%>
<html>
<head>
<title>Spring MVC上传文件示例</title>
</head>
<body>
    <form:form method="POST" modelAttribute="fileUpload"
        enctype="multipart/form-data">
      成功
      <input type="file" name="file" />
        <input type="submit" value="提交上传" />
    </form:form>
</body>
</html>
