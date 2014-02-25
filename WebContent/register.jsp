<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="/struts-tags" prefix="s"%>
<%@taglib prefix="display" uri="http://displaytag.sf.net"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration Page</title>

<script type="text/javascript"
	src=" <s:url value="js/jquery-1.9.1.js"/>"></script>
<script type="text/javascript"
	src=" <s:url value="js/bootstrap.min.js"/>"></script>
<script type="text/javascript"
	src=" <s:url value="js/bootstrap-datetimepicker.min.js"/>"></script>
<script type="text/javascript"
	src=" <s:url value="js/bootstrap-datetimepicker.pt-BR.js"/>"></script>
<script type="text/javascript">
	$(document).ready(function() {

		$('#datetimepicker').datetimepicker({
			language : 'en',
			format : 'MM/dd/yyyy',
			pickTime : false
		})

		if ($("#CountryId").val() == "") {
			$("#CityId").val() == "";
		} else {
			$.ajax({
				data : {
					CountryId : $("#CountryId").val()
				},
				type : "POST",
				url : "/Checkpoint/selectCity",
				success : function(data) {

					$("#CityId").html(data);
				}
			});
		}

		$("#CountryId").change(function() {
			alert("asd")
			$.ajax({
				data : {
					CountryId : $("#CountryId").val()
				},
				type : "POST",
				url : "/Checkpoint/selectCity",
				success : function(data) {

					$("#CityId").html(data);
				}
			});
		});
	});
</script>
<s:head />
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

<%-- 	<s:a href="saveOrUpdateCountry" cssClass=".act-info">Add Country</s:a> --%>
<%-- 	<s:a href="saveOrUpdateCity" cssClass=".act-info">Add City</s:a> --%>
<%-- 	<s:a href="saveOrUpdateCouncil" cssClass=".act-info">Add Council</s:a> --%>
<%-- 	<s:a href="saveOrUpdateCompanyType" cssClass=".act-info">Add Company Type</s:a> --%>
	<s:form action="saveOrUpdateUser">
	<s:actionerror/>
	  <s:fielderror />  
		<s:push value="user">
			<s:hidden name="id" />
			<s:textfield name="name" label="User Name" />
			<s:radio name="gender" label="Gender" list="{'Male','Female'}" />
			<s:select list="countryList" listKey="CountryId"
				listValue="CountryName" name="country.CountryId" headerKey=""
				headerValue="Select" label="Select a country" id="CountryId" />
			<s:select list="cityList" listKey="CityId" listValue="CityName"
				name="city.CityId" headerKey="" headerValue="Select"
				label="Select a city" id="CityId" />

			<tr>
				<td class="tdLabel"><label class="label" for="dob">Date
						Of Birth:</label></td>
				<td>
					<div id="datetimepicker" class="input-append date">
						<input type="text" name="dateofbirth" id="dob"></input> <span
							class="add-on"> <i data-time-icon="icon-time"
							data-date-icon="icon-calendar"></i>
						</span>

					</div>
				</td>
			</tr>
			<s:textarea name="aboutYou" label="About You" cols="15" />
			<s:checkbox cssClass="checkbox" name="mailingList"
				label="Would you like to join our mailing list?" />
			<s:submit cssClass="btn btn-success" />
		</s:push>
	</s:form>

	<%-- 	<s:if test="userList.size() > 0">
		<div class="content">
			<table class="table table-striped table-bordered" cellpadding="5px">
				<tr class="even">
					<th>Name</th>
					<th>Gender</th>
					<th>Country</th>
					<th>City</th>
					<th>About You</th>
					<th>Mailing List</th>
					<th>Edit</th>
					<th>Delete</th>
				</tr>
				<s:iterator value="userList" status="userStatus">
					<tr>
						<td><s:property value="name" /></td>
						<td><s:property value="gender" /></td>
						<td><s:property value="country.CountryName" /></td>
						<td><s:property value="city.CityName" /></td>
						<td><s:property value="aboutYou" /></td>
						<td><s:property value="mailingList" /></td>
						<td><s:url id="editURL" action="editUser">
								<s:param name="id" value="%{id}"></s:param>
							</s:url> <s:a href="%{editURL}">Edit</s:a></td>
						<td><s:url id="deleteURL" action="deleteUser">
								<s:param name="id" value="%{id}"></s:param>
							</s:url> <s:a href="%{deleteURL}">Delete</s:a></td>
					</tr>
				</s:iterator>
			</table>
		</div>
	</s:if> --%>
	<display:table name="${userList}" id="userList"
		class="table table-striped table-bordered" list="userList"
		requestURI="/listUser" pagesize="3" export="true">
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
		<display:column property="name" title="User Name" sortable="true"></display:column>
		<display:column property="gender" title="Gender"></display:column>
		<display:column title="Country" sortable="true">${userList.country.countryName}</display:column>
		<display:column title="City" sortable="true">${userList.city.cityName}</display:column>
		<display:column property="aboutYou" title="About You" sortable="true"
			media="html"></display:column>
		<display:column property="mailingList" title="Mailing List"
			sortable="true"></display:column>
		<display:column paramId="id" paramProperty="id" title="Edit"
			href="editUser">Edit</display:column>
		<display:column paramId="id" paramProperty="id" title="Delete"
			href="deleteUser">Delete</display:column>
	</display:table>
</body>
</html>