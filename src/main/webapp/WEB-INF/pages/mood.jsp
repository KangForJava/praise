<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: kjy
  Date: 2021/5/29
  Time: 18:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Getting Started: Serving Web Content</title>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8"/>
</head>
<body>
    <div id="moods">
        <b>说说列表:</b><br/>
        <c:forEach items="${moods}" var="mood">
            -------------------------------------
            <br/>
            <b>用户:</b><span id="account">${mood.userName}</span><br/>
            <b>说说内容:</b><span id="content">${mood.content}</span><br/>
            <b>发表时间:</b><span id="publish_time">${mood.publishTime}</span><br/>
            <b>点赞数:</b><span id="praise_num">${mood.praiseNum}</span><br/>
            <div style="margin-left: 350px">
                <%--传统点赞
                <a id="praise" href="${pageContext.request.contextPath}/mood/praise/${mood.id}?userId=${mood.userId}">赞</a>
                --%>
                <%--引入redis后的点赞请求--%>
                <a id="praise" href="${pageContext.request.contextPath}/mood/praiseForRedis/${mood.id}?userId=${mood.userId}">赞</a>
            </div>
        </c:forEach>
    </div>

</body>
<script></script>
</html>
