<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
 <%@page import="package1.Model" %>  
 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<jsp:useBean id="modelperuser" class="package1.Modelperimetre_user"/>
<jsp:useBean id="model" class="package1.Model"/>

<jsp:useBean id="perimetre" class="package1.perimetre_user"></jsp:useBean>
<jsp:setProperty property="id_utilisateur" name="perimetre"/>


<jsp:useBean id="logiciel" class="package1.Logiciels"></jsp:useBean>
<jsp:setProperty property="nom" name="logiciel"/>

<c:if test="${logiciel.getNom()!=null}">
	Id user: ${perimetre.id_utilisateur }
	Nom log: ${logiciel.nom}
	Id log: ${model.chercherIDLogiciels(logiciel.nom).getId_logiciel()}
	<c:set var="l" value="${model.chercherIDLogiciels(logiciel.nom)}"/>
	${modelperuser.ajouterperimetre_user(perimetre.id_utilisateur, l.id_logiciel)}

	
</c:if>

<h1>Liste des perimètres</h1>
<table>
<tr>
<th>Id logiciel</th><th>Nom du logiciel</th>

</tr>
<tr>

<c:forEach var="per" items="${modelperuser.getListe()}">

<tr>
<td>	${per.getId_logiciel()}</td>
<td>
<c:set var="c" value="${model.chercherLogiciels(per.id_logiciel)}"></c:set>	

${c.nom}</td>


</tr>
</c:forEach>
</tr>
</table>

<c:url value="/ajoutsperimetreuser.jsp" var="affiche">				
	<c:param name="id_user" value="${param.id}"/>
</c:url>
						
						
<nav><a href="${affiche}" > Ajouter un perimetre</a></nav></td>

<c:url value="/connexionuser.jsp" var="retour">				
	<c:param name="id_user" value="${param.id}"/>
</c:url>

<nav><a href="${retour}" >Retour</a></nav>

<c:url value="/Deconnexion" var="dec">

</c:url>
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

</body>
</html>