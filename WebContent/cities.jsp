<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>City Master</title>

<s:head />
<style type="text/css">
@import url(css/style.css);
</style>
</head>
<body>

<%-- 	<s:a href="listUser">All Users</s:a> --%>
<%-- 	<s:a href="listCountry">All Countries</s:a> --%>

	<s:form action="saveOrUpdateCity">
		<s:push value="city">
			<s:hidden name="CityId" />
			<s:textfield name="CityName" label="City Name" />
			<s:select list="countryList" listKey="CountryId"
				listValue="CountryName" name="country.CountryId" headerKey=""
				headerValue="Select" label="Select a country" />
			<s:submit />
		</s:push>
	</s:form>

	<s:if test="cityList.size() > 0">
		<div class="content">
			<table class="cityTable" cellpadding="5px">
				<tr class="even">
					<th>City Name</th>
					<th>Country Name</th>
					<th>Edit</th>
					<th>Delete</th>
				</tr>
				<s:iterator value="CityList" status="cityStatus">
					<tr
						class="<s:if test="#cityStatus.odd == true ">odd</s:if><s:else>even</s:else>">
						<td><s:property value="CityName" /></td>
						<td><s:property value="country.CountryName" /></td>
						<td><s:url id="editURL" action="editCity">
								<s:param name="CityId" value="%{CityId}"></s:param>
							</s:url> <s:a href="%{editURL}">Edit</s:a></td>
						<td><s:url id="deleteURL" action="deleteCity">
								<s:param name="CityId" value="%{CityId}"></s:param>
							</s:url> <s:a href="%{deleteURL}">Delete</s:a></td>
					</tr>
				</s:iterator>
			</table>
		</div>
	</s:if>
</body>
</html>