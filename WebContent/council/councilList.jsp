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
	<s:a href="saveOrUpdateCountry" cssClass=".act-info">Add Country</s:a>
	<s:a href="saveOrUpdateCity" cssClass=".act-info">Add City</s:a>
	<s:form action="saveOrUpdateCouncil">
	<s:actionerror/>
	  <s:fielderror />  
		<s:push value="council">
			<s:hidden name="councilId" />
			<s:textfield name="councilName" label="Council Name" />
			<s:textfield name="phoneNumber" label="Phone Number" />
			<s:textfield name="email" label="Email" />
			<s:submit cssClass="btn btn-success" />
		</s:push>
	</s:form>
	
	<s:form action="searchCouncil">
		<s:textfield name="councilName" label="Search the Council Name"/>
		<s:submit cssClass="btn btn-success" />
	</s:form>
	
	<s:form action="importCouncils" enctype="multipart/form-data">
		<s:file name="councilCSV"/>
		<s:submit cssClass="btn btn-success"></s:submit>
	</s:form>
	
	<display:table name="${councilList}" id="councilList"
		class="table table-striped table-bordered" list="councilList"
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
		<display:column property="councilName" title="Council Name" sortable="true"></display:column>
		<display:column property="phoneNumber" title="Phone Number" sortable="true"></display:column>
		<display:column property="email" title="Email" sortable="true"
			media="html"></display:column>
		<display:column paramId="councilId" paramProperty="councilId" title="Edit"
			href="editCouncil">Edit</display:column>
		<display:column paramId="councilId" paramProperty="councilId" title="Delete"
			href="deleteCouncil">Delete</display:column>
	</display:table>
</body>
</html>