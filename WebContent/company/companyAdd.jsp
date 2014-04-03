<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="/struts-tags" prefix="s"%>
<%@taglib prefix="display" uri="http://displaytag.sf.net"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Council</title>
</head>
<style type="text/css">
@import url(css/bootstrap/css/bootstrap.css);


@import url(css/bootstrap/css/bootstrap-responsive.css);

@import url(css/bootstrap/css/docs.css);

@import url(css/bootstrap/css/bootstrap-combined.min.css);

@import url(css/bootstrap/css/bootstrap-datetimepicker.min.css);

@IMPORT url("js/bootstrap.min.js");

</style>
<body>

	<s:form action="saveOrUpdateCompany"  method="post" enctype="multipart/form-data">
	<s:actionerror/>
	  <s:fielderror />  
		
			<s:hidden name="companyId" />
			<s:textfield name="companyName" label="Company Name" />
			<s:select list="companyTypeList" listKey="companyTypeId"
 				listValue="companyTypeName" name="companyType.CompanyTypeId" headerKey=""
 				headerValue="Select" label="Select CompanyType" />
 			<s:submit cssClass="btn btn-success" />
		
	</s:form>
</body>
</html>