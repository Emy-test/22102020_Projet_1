<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="package1.Model" %>    
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h1>Liste des bulletins(admin)</h1>



<jsp:useBean id="model" class="package1.Model"/>
<jsp:useBean id="modelper" class="package1.Modelperimetre"/>
<jsp:useBean id="modelpersol" class="package1.Modelperimetre_solution"/>

<jsp:useBean id="Logiciel" class="package1.Logiciels"/>
<jsp:setProperty property="nom" name="Logiciel"/>

<jsp:useBean id="modelbulletin" class="package1.Modelbulletin"></jsp:useBean>
<jsp:useBean id="bulletin" class="package1.Bulletin"></jsp:useBean>
<jsp:setProperty property="*" name="bulletin"/>

<jsp:useBean id="modelsolution" class="package1.Modelsolution"></jsp:useBean>
<jsp:useBean id="solution" class="package1.Solution"></jsp:useBean>
<jsp:setProperty property="*" name="solution"/>

<jsp:useBean id="perbulletin" class="package1.Perimetre"></jsp:useBean>
<jsp:setProperty property="*" name="perbulletin"/>

<c:forEach var="id" items="${modelsolution.getListe()}">
<%-- 	id boulce: ${id.id_solution} --%>
	<c:if test="${id.id_solution==solution.id_solution && id.id_solution!=0}">
		<c:redirect url="/ajoutsolution.jsp">
			<c:param name="test" value="1" />
			<c:param name="id" value="${solution.id_bulletin }" />
		</c:redirect>	
	</c:if>	
</c:forEach>

<c:if test="${solution!=null && solution.getDescription()!=null && solution.getId_solution()!=null}">

	${modelsolution.ajouterSolution(solution)}
	${modelpersol.ajouterperimetre_solution(solution.id_solution, solution.id_bulletin)}
	
</c:if>

<%-- <c:if test="${perbulletin.getId_bulletin()!=null}"> --%>
<c:if test="${perbulletin.id_bulletin!=0}">
	<c:set var="p" value="${model.chercherIDLogiciels(Logiciel.nom)}"/>
	Id logiciel: ${p.id_logiciel}
	Id bulletin: ${perbulletin.id_bulletin }
	${modelper.ajouterPerimetre(p.id_logiciel, perbulletin.id_bulletin)}

</c:if>

<c:if test="${bulletin!=null && bulletin.getNom_bulletin()!=null && bulletin.getDescription()!=null && bulletin.getId()!=null}">
	${modelbulletin.ajouterBulletin(bulletin)}

</c:if>


<table>
<tr>
<th>Id</th><th>Reference du bulletin</th><th>Date</th><th>Priorite</th><th>Synthese</th><th>Logiciels affectes</th><th>Details</th>

</tr>
<tr>

<c:forEach var="menace" items="${modelbulletin.getListe()}">

<tr>
<td>	${menace.getId()}</td>
<td>	${menace.getReference_bulletin()}</td>
<td>	${menace.getDate()}</td>
<td>	${menace.getPriorite()}</td>
<td>	${menace.getSynthese()}</td>

<td>	<c:forEach var="perlog" items="${modelper.getListe()}">
		<c:if test="${menace.id==perlog.id_bulletin}">
			<c:set var="log" value="${model.chercherLogiciels(perlog.id_logiciel)}"/>
			${log.nom} -
		</c:if>
		
	</c:forEach>
	<c:url value="/ajoutperimetrebulletin.jsp" var="per">
			<c:param name="id" value="${menace.id}"/>
		
	</c:url>
	<nav><a href="${per}" > Ajouter un logiciel affecte</a></nav>
	<br></td>
	


<c:url value="/Bulletin.jsp" var="affiche">
	<c:param name="id" value="${menace.id}"/>

</c:url>
<td>	<nav><a href="${affiche}" > Bulletin</a></nav></td>

</tr>

</c:forEach>


</table>
<nav><a href="ajoutbulletin.jsp">Ajouter un bulletin</a></nav>
<c:url value="/Deconnexion" var="dec">

</c:url>
	<nav><a href="${dec}" >Se déconnecter...</a></nav>

<nav><a href="connexionadmin.jsp" >Retour</a></nav>
<%-- <nav><a href="${ajout}" ></a></nav> --%>

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