<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href='<c:url value="${pageContext.request.contextPath}/resources/css/style.css"/>' rel="stylesheet" type="text/css">
</head>
<body>

<footer>
    <div class="contact">
        <h2>Skontaktuj się z nami</h2>
        <h3>Formularz kontaktowy</h3>
        <form class="form--contact">
            <div class="form-group form-group--50"><input type="text" name="name" placeholder="Imię"/></div>
            <div class="form-group form-group--50"><input type="text" name="surname" placeholder="Nazwisko"/></div>

            <div class="form-group"><textarea name="message" placeholder="Wiadomość" rows="1"></textarea></div>

            <button class="btn" type="submit">Wyślij</button>
        </form>
    </div>
    <div class="bottom-line">
        <span class="bottom-line--copy">Copyright &copy; 2019</span>
        <div class="bottom-line--icons">
            <a href="#" class="btn btn--small"><img src="<c:url value="${pageContext.request.contextPath}/resources/images/icon-facebook.svg"/>"/></a>
            <a href="#" class="btn btn--small"><img src="<c:url value="${pageContext.request.contextPath}/resources/images/icon-instagram.svg"/>"/></a>
        </div>
    </div>
</footer>
</body>
</html>