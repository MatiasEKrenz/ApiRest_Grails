<%--
  Created by IntelliJ IDEA.
  User: mkrenz
  Date: 2019-04-24
  Time: 11:15
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title></title>
</head>

<body>

<select id="select">
    <g:each in="${result}" var="site">
        <option value="${site.id}" data-foo="${site.slug}">${site.name}</option>
    </g:each>
</select>


</body>
</html>