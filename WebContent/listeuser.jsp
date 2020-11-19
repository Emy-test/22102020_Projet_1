<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="package1.Modeluser" %>    
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h1>Liste des utilisateurs</h1>

<jsp:useBean id="modeluser" class="package1.Modeluser"></jsp:useBean>
<jsp:useBean id="user" class="package1.User"></jsp:useBean>
<jsp:setProperty property="*" name="user"/>


<c:if test="${user!=null && user.nom!=null && user.login!=null && user.pwd!=null}">
	${modeluser.ajouterUser(user)}

</c:if>

<table>
<tr>
<th>Id</th><th>Nom</th><th>Mail</th><th>Role</th>

</tr>
<tr>

<jsp:useBean id="model" class="package1.Modeluser"/>

<c:forEach var="part" items="${model.getListe()}">

<tr>
<td>	${part.getId()}</td>
<td>	${part.getNom()}</td>
<td>	${part.getMail()}</td>
<td>	${part.getRole()}</td>

</tr>
</c:forEach>

</table>
<c:url value="/Deconnexion" var="dec">

</c:url>
<nav><a href="ajoutuser.jsp" >Ajouter un utilisateur</a></nav>
<nav><a href="connexionadmin.jsp" >Retour</a></nav>
	<nav><a href="${dec}" >Se déconnecter...</a></nav>

<style>

table {
  width: 70%;
  
}
th,td {
  text-align: left;
}

tr:nth-child(even) {background-color: #f2f2f2;}

</style>

<section>




</body>
</html>