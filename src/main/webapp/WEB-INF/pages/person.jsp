<%--
  Created by IntelliJ IDEA.
  User: loki
  Date: 3/31/15
  Time: 1:32 PM
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
  Add a Person
</h1>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>

<script>
  //var mydate ="M008,D005,1234567890123456,113.559819148548850,28.3895138 19383120";
  var mydate = {
    "name":"ajaxdate",
    "country":"dateajax"
  }
  test = function(){
    $.ajax({
      type:"POST",
      url:"add",
      dataType:"json",
      contentType:"application/json",
      data: JSON.stringify(mydate),
      success: function (date) {
        console.log('success');
        console.log(date);
      },
      error: function(date){
        console.log('failed');
        console.log(date);
      }
    });
  };
  begin = function(){stop=setInterval("test()",500)};
  function end(){
    window.clearInterval(stop);
  }
  // var oAjax;
  // function test(){
  // oAjax = new XMLHttpRequest();
  // // oAjax.onreadystatechange=function(){
  // // if(oAjax.readyState==4&&oAjax.status==200){
  // // alert('success');
  // // }
  // // }
  // oAjax.onreadystatechange = forFun;
  // oAjax.open('POST','http://gfive.demo.com/post',true);
  // oAjax.setRequestHeader("Content-type","application/x-www-form-urlencoded");
  // oAjax.send(mydate);
  // }

  // function forFun(){
  // if(oAjax.readyState==4&&oAjax.status==200){
  // var b = xmlHttpRequest.responseText;
  // if(b == "true"){
  // alert("登录成功！");
  // }else{
  // alert("登录失败！");
  // }
  // }
  // }

</script>
<button onclick="begin();">发送数据</button>
<button onclick="end();">停止发送</button>


<c:url var="addAction" value="/persons/add" ></c:url>

<form:form action="${addAction}" commandName="person">
  <table>
    <c:if test="${!empty person.name}">
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
        <form:label path="name">
          <spring:message text="Name"/>
        </form:label>
      </td>
      <td>
        <form:input path="name" />
      </td>
    </tr>
    <tr>
      <td>
        <form:label path="country">
          <spring:message text="Country"/>
        </form:label>
      </td>
      <td>
        <form:input path="country" />
      </td>
    </tr>
    <tr>
      <td colspan="2">
        <c:if test="${!empty person.name}">
          <input type="submit"
                 value="<spring:message text="Edit Person"/>" />
        </c:if>
        <c:if test="${empty person.name}">
          <input type="submit"
                 value="<spring:message text="Add Person"/>" />
        </c:if>
      </td>
    </tr>
  </table>
</form:form>
<br>
<h3>Persons List</h3>
<c:if test="${!empty listPersons}">
  <table class="tg">
    <tr>
      <th width="80">Person ID</th>
      <th width="120">Person Name</th>
      <th width="120">Person Country</th>
      <th width="60">Edit</th>
      <th width="60">Delete</th>
    </tr>
    <c:forEach items="${listPersons}" var="person">
      <tr>
        <td>${person.id}</td>
        <td>${person.name}</td>
        <td>${person.country}</td>
        <td><a href="<c:url value='/persons/edit/${person.id}' />" >Edit</a></td>
        <td><a href="<c:url value='/persons/remove/${person.id}' />" >Delete</a></td>
      </tr>
    </c:forEach>
  </table>
</c:if>
</body>
</html>

