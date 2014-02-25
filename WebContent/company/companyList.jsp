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

	<s:form action="saveOrUpdateCompany">
	<s:actionerror/>
	  <s:fielderror />  
		<s:push value="company">
			<s:hidden name="companyId" />
			<s:textfield name="companyName" label="Company Name" />
			<s:select list="companyTypeList" listKey="companyTypeId"
 				listValue="companyTypeName" name="companyType.CompanyTypeId" headerKey=""
 				headerValue="Select" label="Select CompanyType" /> --%>
 			<s:submit cssClass="btn btn-success" /> --%>
		</s:push>
	</s:form>
	
<%-- 	<s:form action="searchCompany"> --%>
<%-- 		<s:textfield name="companyName" label="Search the Company Name"/> --%>
<%-- 		<s:submit cssClass="btn btn-success" /> --%>
<%-- 	</s:form> --%>
	
<%-- 	<display:table name="${companyList}" id="companyList" --%>
<%-- 		class="table table-striped table-bordered" list="companyList" --%>
<%-- 		requestURI="/ListCompany" pagesize="3" export="true"> --%>
<%-- 		<display:setProperty name="export.pdf.filename" value="example.pdf" /> --%>
<%-- 		<display:setProperty name="decorator.media.rtf" --%>
<%-- 			value="org.displaytag.sample.decorators.ItextTotalWrapper" /> --%>
<%-- 		<display:setProperty name="export.rtf.filename" value="example.rtf" /> --%>
<%-- 		<display:setProperty name="decorator.media.excel" --%>
<%-- 			value="org.displaytag.sample.decorators.HssfTotalWrapper" /> --%>
<%-- 		<display:setProperty name="export.excel.filename" value="example.xls" /> --%>
<%-- 		<display:setProperty name="export.pdf" value="true" /> --%>
<%-- 		<display:setProperty name="export.xml" value="true" /> --%>
<%-- 		<display:setProperty name="export.csv" value="true" /> --%>
<%-- 		<display:column property="companyName" title="Company Name" sortable="true"></display:column> --%>
<%-- 		<display:column title="Company Type" sortable="true">${companyList.companyType.CompanyTypeName}</display:column> --%>
<%-- 		<display:column paramId="companyId" paramProperty="companyId" title="Edit" --%>
<%-- 			href="editCompany">Edit</display:column> --%>
<%-- 		<display:column paramId="companyId" paramProperty="companyId" title="Delete" --%>
<%-- 			href="deleteCompany">Delete</display:column> --%>
<%-- 	</display:table> --%>
</body>
</html>