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


        <form:form method="post" modelAttribute="donation">
            <!-- STEP 5 -->
            <div data-step="5" class="active">
                <h3>Podsumowanie Twojej darowizny</h3>

                <div class="summary">
                    <div class="form-section">
                        <h4>Oddajesz:</h4>
                        <ul>
                            <li>
                                <span class="icon icon-bag"></span>
                                <span class="summary--text">
                                    <c:choose>
                                        <c:when test="${donation.quantity =='1'}">
                                            ${donation.quantity} worek zawierający:
                                        </c:when>
                                        <c:when test="${donation.quantity >= '5'}">
                                            ${donation.quantity} worków zawierających:
                                        </c:when>
                                        <c:otherwise>
                                            ${donation.quantity} worki zawierające:
                                        </c:otherwise>
                                    </c:choose>

                                     <c:forEach items="${donation.categoriesDto}" var="category">
                                         ${category.name}
                                     </c:forEach>
                                </span>
                            </li>

                            <li>
                                <span class="icon icon-hand"></span>
                                <span class="summary--text"
                                >${donation.institutionDto.name}</span
                                >
                            </li>
                        </ul>
                    </div>

                    <div class="form-section form-section--columns">
                        <div class="form-section--column">
                            <h4>Adres odbioru:</h4>
                            <ul>
                                <li>${donation.street}</li>
                                <li>${donation.city}</li>
                                <li>${donation.zipCode}</li>
                            </ul>
                        </div>

                        <div class="form-section--column">
                            <h4>Termin odbioru:</h4>
                            <ul>
                                <li>${donation.pickUpDate}</li>
                                <li>${donation.pickUpTime}</li>
                                <li>${donation.pickUpComment}</li>
                            </ul>
                        </div>
                    </div>
                </div>

                <div class="form-group form-group--buttons">
                    <a href="/donation/addStep4" class="btn prev-step">Wstecz</a>
                    <button type="submit" class="btn">Potwierdzam</button>
                </div>
        </form:form>
    </div>
</section>

<%@ include file="footer.jsp" %>

<script src="<c:url value="resources/js/app.js" />"></script>

</body>
</html>
