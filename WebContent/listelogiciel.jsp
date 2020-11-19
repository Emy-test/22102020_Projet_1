<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="package1.User" import="package1.Model" %>    
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<jsp:useBean id="model" class="package1.Model"></jsp:useBean>
<jsp:useBean id="logiciel" class="package1.Logiciels"></jsp:useBean>
<jsp:setProperty property="*" name="logiciel"/>


<%-- <c:if test="${participant!=null && participant.getNom()!=null && participant.getLogin()!=null}"> --%>
<%-- ${model.ajouterLogiciel(participant)} --%>
<%-- </c:if> --%>

<h1>Liste des logiciels- Administrateur</h1>


<table>
<tr>
<th>Id Logiciel</th><th>Nom</th><th>Supprimer</th>

</tr>
<tr>


<c:forEach var="part" items="${model.getListe()}">

<tr>
<td>	${part.getId_logiciel()}</td>
<td>	${part.getNom()}</td>


<c:url value="/Suppression" var="sup">
	<c:param name="code" value="${part.id_logiciel}"/>
	
</c:url>
<td>	<nav><a href="${sup}" >Supprimer</a></nav></td>



</tr>
</c:forEach>

</table>


<style>

table {
  width: 70%;
  
}
th {
  text-align: left;
}

tr:nth-child(even) {background-color: #f2f2f2;}


</style>
<section>
<c:url value="/Deconnexion" var="dec">

</c:url>
	<nav><a href="connexionadmin.jsp" >Retour</a></nav>
	<nav><a href="${dec}" >Se déconnecter...</a></nav>

<%-- <c:url value="/ajout.jsp" var="ajout"> --%>

<%-- </c:url> --%>
<%-- 	<nav><a href="${ajout}" >Ajouter un participant...</a></nav> --%>
</section>
</section>

</body>
</html>