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

	<s:form action="saveOrUpdateCompanyType">
	<s:actionerror/>
	  <s:fielderror />  
		<s:push value="companyType">
			<s:hidden name="companyTypeId" />
			<s:textfield name="companyTypeName" label="Company Type Name" />
			<s:submit cssClass="btn btn-success" />
		</s:push>
	</s:form>
	
	<s:form action="searchCompanyType">
		<s:textfield name="companyTypeName" label="Search the Company Type Name"/>
		<s:submit cssClass="btn btn-success" />
	</s:form>
	
	<display:table name="${companyTypeList}" id="companyTypeList"
		class="table table-striped table-bordered" list="companyTypeList"
		requestURI="/ListCouncil" pagesize="3" export="true">
		<display:setProperty name="export.pdf.filename" value="example.pdf" />
		<display:setProperty name="decorator.media.rtf"
			value="org.displaytag.sample.decorators.ItextTotalWrapper" />
		<display:setProperty name="export.rtf.filename" value="example.rtf" />
		<display:setProperty name="decorator.media.excel"
			value="org.displaytag.sample.decorators.HssfTotalWrapper" />
		<display:setProperty name="export.excel.filename" value="example.xls" />
		<display:setProperty name="export.pdf" value="true" />
		<display:setProperty name="export.xml" value="true" />
		<display:setProperty name="export.csv" value="true" />
		<display:column property="companyTypeName" title="Company Type Name" sortable="true"></display:column>
		<display:column paramId="companyTypeId" paramProperty="companyTypeId" title="Edit"
			href="editCompanyType">Edit</display:column>
		<display:column paramId="companyTypeId" paramProperty="companyTypeId" title="Delete"
			href="deleteCompanyType">Delete</display:column>
	</display:table>
</body>
</html>