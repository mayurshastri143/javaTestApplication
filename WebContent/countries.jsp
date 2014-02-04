<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration Page</title>
<s:head />
<style type="text/css">
@import url(css/style.css);
</style>
</head>
<body>

	<s:a href="listUser">All Users</s:a>

	<s:form action="saveOrUpdateCountry">
		<s:push value="country">
			<s:hidden name="CountryId" />
			<s:textfield name="CountryName" label="Country Name" />
			<s:submit />
		</s:push>
	</s:form>

	<s:if test="countryList.size() > 0">
		<div class="content">
			<table class="countryTable" cellpadding="5px">
				<tr class="even">
					<th>Name</th>
					<th>Edit</th>
					<th>Delete</th>
				</tr>
				<s:iterator value="countryList" status="countryStatus">
					<tr
						class="<s:if test="#countryStatus.odd == true ">odd</s:if><s:else>even</s:else>">
						<td><s:property value="CountryName" /></td>
						<td><s:url id="editURL" action="editCountry">
								<s:param name="CountryId" value="%{CountryId}"></s:param>
							</s:url> <s:a href="%{editURL}">Edit</s:a></td>
						<td><s:url id="deleteURL" action="deleteCountry">
								<s:param name="CountryId" value="%{CountryId}"></s:param>
							</s:url> <s:a href="%{deleteURL}">Delete</s:a></td>
					</tr>
				</s:iterator>
			</table>
		</div>
	</s:if>
</body>
</html>