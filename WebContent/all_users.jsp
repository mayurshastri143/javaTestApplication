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
<script type="text/javascript">
	$(document).ready(function() {

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
</style>
</head>
<body>

	<display:table name="${userList}" id="userList" class="table table-striped table-bordered" list="userList" requestURI="/allUser"
		pagesize="10" >
		<display:column property="name" title="User Name" sortable="true"></display:column>
		<display:column property="gender" title="Gender" sortable="true"></display:column>
		<display:column title="Country" sortable="true">${userList.country.countryName}</display:column>
		<display:column title="City" sortable="true">${userList.city.cityName}</display:column>
		<display:column property="aboutYou" title="About You" sortable="true"></display:column>
		<display:column property="mailingList" title="Mailing List" sortable="true"></display:column>
		<display:column href="%{editURL}" title="Edit">
			${userList.id}
		</display:column>
		<display:column property="mailingList" title="Mailing List"></display:column>
	</display:table>

</body>
</html>