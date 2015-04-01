<%--
  Created by IntelliJ IDEA.
  User: loki
  Date: 3/31/15
  Time: 6:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
  <title>Person Page</title>
  <style type="text/css">
    .tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
    .tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}
    .tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
    .tg .tg-4eph{background-color:#f9f9f9}
  </style>
</head>
<body>
<h1>
  Add a Location
</h1>

<c:url var="addAction" value="/gpss/add" ></c:url>

<form:form action="${addAction}" commandName="gps">
  <table>
    <c:if test="${!empty gps.longitude}">
      <tr>
        <td>
          <form:label path="id">
            <spring:message text="ID"/>
          </form:label>
        </td>
        <td>
          <form:input path="id" readonly="true" size="8"  disabled="true" />
          <form:hidden path="id" />
        </td>
      </tr>
    </c:if>
    <tr>
      <td>
        <form:label path="longitude">
          <spring:message text="longitude"/>
        </form:label>
      </td>
      <td>
        <form:input path="longitude" />
      </td>
    </tr>
    <tr>
      <td>
        <form:label path="latitude">
          <spring:message text="Latitude"/>
        </form:label>
      </td>
      <td>
        <form:input path="latitude" />
      </td>
    </tr>
    <tr>
      <td colspan="2">
        <c:if test="${!empty gps.longitude}">
          <input type="submit"
                 value="<spring:message text="Edit Location"/>" />
        </c:if>
        <c:if test="${empty gps.longitude}">
          <input type="submit"
                 value="<spring:message text="Add Location"/>" />
        </c:if>
      </td>
    </tr>
  </table>
</form:form>
<br>
<h3>Persons List</h3>
<c:if test="${!empty listGpss}">
  <table class="tg">
    <tr>
      <th width="80">Location ID</th>
      <th width="120">Longitude</th>
      <th width="120">Latitude</th>
      <th width="60">Edit</th>
      <th width="60">Delete</th>
    </tr>
    <c:forEach items="${listGpss}" var="gps">
      <tr>
        <td>${gps.id}</td>
        <td>${gps.longitude}</td>
        <td>${gps.latitude}</td>
        <td><a href="<c:url value='/gpss/edit/${gps.id}' />" >Edit</a></td>
        <td><a href="<c:url value='/gpss/remove/${gps.id}' />" >Delete</a></td>
      </tr>
    </c:forEach>
  </table>
</c:if>
</body>
</html>
