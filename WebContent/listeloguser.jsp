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

<h1>Liste des bulletins(user)</h1>



<jsp:useBean id="model" class="package1.Model"/>
<jsp:useBean id="modelper" class="package1.Modelperimetre"/>
<jsp:useBean id="modelpersol" class="package1.Modelperimetre_solution"/>

<jsp:useBean id="Logiciel" class="package1.Logiciels"/>

<jsp:useBean id="modelbulletin" class="package1.Modelbulletin"></jsp:useBean>
<jsp:useBean id="bulletin" class="package1.Bulletin"></jsp:useBean>
<jsp:setProperty property="*" name="bulletin"/>

<jsp:useBean id="modelsolution" class="package1.Modelsolution"></jsp:useBean>
<jsp:useBean id="solution" class="package1.Solution"></jsp:useBean>
<jsp:setProperty property="*" name="solution"/>

<jsp:useBean id="modelperuser" class="package1.Modelperimetre_user"/>

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

Id user: ${id_session}<br>

<c:if test="${bulletin!=null && bulletin.getNom_bulletin()!=null && bulletin.getDescription()!=null && bulletin.getId()!=null}">
	${modelbulletin.ajouterBulletin(bulletin)}
	<c:set var="p" value="${model.chercherIDLogiciels(bulletin.logiciels_affectes)}"/>
	${modelper.ajouterPerimetre(p.id_logiciel, bulletin.id)}

</c:if>

<table>
<tr>
<th>Id bulletin</th><th>Reference du bulletin</th><th>Date</th><th>Priorite</th><th>Synthese</th><th>Logiciels affectes</th><th>Details</th>

</tr>
<tr>


<c:forEach var="iduser" items="${modelperuser.getListe()}">
	<c:if test="${id_session==iduser.id_utilisateur}">
<%-- 		${iduser.id_logiciel} --%>
		<c:forEach var="l" items="${modelper.getListe()}">
			<c:if test="${l.id_logiciel==iduser.id_logiciel}">
<%-- 				${l.id_bulletin} --%>
				<c:forEach var="log" items="${modelbulletin.getListe()}">
					<c:if test="${l.id_bulletin==log.id}">

					<tr>
					<td>	${l.id_bulletin}</td>
					<td>	${log.getReference_bulletin()}</td>
					<td>	${log.getDate()}</td>
					<td>	${log.getPriorite()}</td>
					<td>	${log.getSynthese()}</td>
					<td>
					<c:set var="logic" value="${model.chercherLogiciels(iduser.id_logiciel)}"/>
									${logic.nom} -
									</td>
					<c:url value="/Bulletinuser.jsp" var="affiche">
							<c:param name="id" value="${l.id_bulletin}"/>
							<c:param name="id_user" value="${id_session}"/>
						
						</c:url>
						
						
						<td>	<nav><a href="${affiche}" > Bulletin</a></nav></td>
						
							</td>
					</tr>
					</c:if>
				</c:forEach>
			</c:if>
		</c:forEach>
	</c:if>
</c:forEach>


<td>	<c:forEach var="perlog" items="${modelper.getListe()}">
		<c:if test="${menace.id==perlog.id_bulletin}">
			<c:set var="log" value="${model.chercherLogiciels(perlog.id_logiciel)}"/>
			${log.nom} -
		</c:if>
	</c:forEach><br></td>


</table>

<c:url value="/Deconnexion" var="dec">

</c:url>
	<nav><a href="${dec}" >Se déconnecter...</a></nav>

<nav><a href="connexionuser.jsp" >Retour</a></nav>
<nav><a href="${ajout}" ></a></nav>

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