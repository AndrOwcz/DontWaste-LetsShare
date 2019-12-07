<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<head>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <meta http-equiv="X-UA-Compatible" content="ie=edge"/>
    <title>Document</title>
    <link rel="stylesheet" href="<c:url value="${pageContext.request.contextPath}/resources/css/style.css"/>"/>
</head>
<body>

<%--          <li class="logged-user">--%>
<%--            Witaj Agata--%>
<%--            <ul class="dropdown">--%>
<%--              <li><a href="#">Profil</a></li>--%>
<%--              <li><a href="#">Ustawienia</a></li>--%>
<%--              <li><a href="#">Moje zbiórki</a></li>--%>
<%--              <li><a href="#">Wyloguj</a></li>--%>
<%--            </ul>--%>
<%--          </li>--%>
<%--        </ul>--%>
<%@ include file="header.jsp" %>

<div class="slogan container container--90">
    <div class="slogan--item">
        <h1>
            Oddaj rzeczy, których już nie chcesz<br/>

            <span class="uppercase">potrzebującym</span>
        </h1>

        <div class="slogan--steps">
            <div class="slogan--steps-title">Wystarczą 4 proste kroki:</div>
            <ul class="slogan--steps-boxes">
                <li>
                    <div><em>1</em><span>Wybierz rzeczy</span></div>
                </li>
                <li>
                    <div><em>2</em><span>Spakuj je w worki</span></div>
                </li>
                <li>
                    <div><em>3</em><span>Wybierz fundację</span></div>
                </li>
                <li>
                    <div><em>4</em><span>Zamów kuriera</span></div>
                </li>
            </ul>
        </div>
    </div>
</div>
</header>

<section class="form--steps">
    <div class="form--steps-instructions">
        <div class="form--steps-container">
            <h3>Ważne!</h3>
            <p data-step="1" class="active">
                Uzupełnij szczegóły dotyczące Twoich rzeczy. Dzięki temu będziemy
                wiedzieć komu najlepiej je przekazać.
            </p>
            <p data-step="2">
                Uzupełnij szczegóły dotyczące Twoich rzeczy. Dzięki temu będziemy
                wiedzieć komu najlepiej je przekazać.
            </p>
            <p data-step="3">
                Wybierz jedną, do
                której trafi Twoja przesyłka.
            </p>
            <p data-step="4">Podaj adres oraz termin odbioru rzeczy.</p>
        </div>
    </div>

    <div class="form--steps-container">
        <div class="form--steps-counter">Krok <span>3</span>/4</div>


        <form:form method="get" modelAttribute="donation" action="/donation/addStep4">

        <!-- STEP 3 -->
        <div data-step="3" class="active">
            <h3>Wybierz organizacje, której chcesz pomóc:</h3>

            <c:forEach items="${institutions}" var="institution">

                <div class="form-group form-group--checkbox">
                    <label>
                        <form:radiobutton path="institutionDtoId" value="${institution.id}"/>
                        <span class="checkbox radio"></span>
                        <span class="description">
                  <div class="title">${institution.name}</div>
                  <div class="subtitle">
                          ${institution.description}
                  </div>
                </span>
                    </label>
                </div>
            </c:forEach>

            <div class="form-group form-group--buttons">
                <a href="/donation/addStep2" class="btn prev-step">Wstecz</a>
                <button type="submit" class="btn next-step">Dalej</button>
            </div>
        </div>
    </div>
    </form:form>
    </div>
</section>

<%@ include file="footer.jsp" %>

<script src="<c:url value="resources/js/app.js" />"></script>

</body>
</html>
