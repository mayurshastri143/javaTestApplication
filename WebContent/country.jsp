<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="/struts-tags" prefix="s"%>
<html>
<body>
	<s:select list="cityList" listKey="CityId"
				listValue="CityName" name="city.CityId" headerKey=""
				headerValue="Select" label="Select a city" id="CityId"/>z
</body>
</html>