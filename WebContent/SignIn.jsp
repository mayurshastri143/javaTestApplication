<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sign In</title>
<script type="text/javascript"
	src=" <s:url value="js/jquery-1.9.1.js"/>"></script>
<script type="text/javascript"
	src=" <s:url value="js/bootstrap.min.js"/>"></script>
<script type="text/javascript"
	src=" <s:url value="js/bootstrap-datetimepicker.min.js"/>"></script>
<script type="text/javascript"
	src=" <s:url value="js/bootstrap-datetimepicker.pt-BR.js"/>"></script>
<style type="text/css">
@import url(css/bootstrap/css/bootstrap.css);

@import url(css/bootstrap/css/bootstrap-responsive.css);

@import url(css/bootstrap/css/docs.css);

@import url(css/bootstrap/css/bootstrap-combined.min.css);

@import url(css/bootstrap/css/bootstrap-datetimepicker.min.css);

@IMPORT url("js/bootstrap.min.js");
</style>
</head>
<body>
	<s:form action="signin">
	<s:actionerror/>
	  <s:fielderror />  
			<s:textfield name="name" label="User Name" />
			<s:password name="password" label="Password"></s:password>
			<s:submit cssClass="btn btn-success" />
	</s:form>
</body>
</html>