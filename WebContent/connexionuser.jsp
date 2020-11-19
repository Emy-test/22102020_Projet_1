<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<jsp:useBean id="modeluser" class="package1.Modeluser"></jsp:useBean>
<jsp:useBean id="user" class="package1.User"></jsp:useBean>
<jsp:setProperty property="*" name="user"/>

<c:set var="u" value="${modeluser.chercherUser(user.login, user.pwd)}"/>

${id_session}

<h2>Bonjour, ${u.getNom()}</h2>

<c:url value="/listeloguser.jsp" var="affiche">

</c:url>

<nav><a href="${affiche}">Liste bulletin</a></nav>
<br>

<c:url value="/listeperimetre.jsp" var="perimetre">

</c:url>

<nav><a href="${perimetre}">Liste de vos perimetres</a></nav>
<br>

<c:url value="/Deconnexion" var="dec">

</c:url>
	<nav><a href="${dec}" >Se déconnecter...</a></nav>

</body>
</html>