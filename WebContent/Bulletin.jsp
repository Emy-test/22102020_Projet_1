<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@page import="package1.Bulletin" import="package1.Model" %>    
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%-- <td>	Code: ${empty param.code}</td> --%>
<center>
<h2>Liste des bulletins(admin)</h2>
</center>

<c:set var="p" value="${model.chercherLogiciels(param.id)}"/>
<jsp:useBean id="model" class="package1.Model"></jsp:useBean>
<jsp:useBean id="bulletin" class="package1.Bulletin"></jsp:useBean>
<jsp:setProperty property="*" name="bulletin"/>

<jsp:useBean id="modelperimetre" class="package1.Modelperimetre"></jsp:useBean>
<jsp:useBean id="perimetre" class="package1.Perimetre"></jsp:useBean>
<jsp:setProperty property="*" name="perimetre"/>

<jsp:useBean id="modelperimetre_solution" class="package1.Modelperimetre_solution"></jsp:useBean>
<jsp:useBean id="perimetre_solution" class="package1.perimetre_solution"></jsp:useBean>
<jsp:setProperty property="*" name="perimetre_solution"/>

<jsp:useBean id="modelsolution" class="package1.Modelsolution"></jsp:useBean>
<jsp:useBean id="solution" class="package1.Solution"></jsp:useBean>
<jsp:setProperty property="*" name="solution"/>

<jsp:useBean id="modelbulletin" class="package1.Modelbulletin"></jsp:useBean>

<c:set var="bul" value="${modelbulletin.chercherBulletin(param.id)}"/>

				
	<center><br><h3>Bulletin(id): ${param.id}</h3></center>
	<h3>Synthese</h3>
	Date: ${bul.date}<br>
	Reference: ${bul.reference_bulletin}<br>
	Priorite: ${bul.priorite}<br><br>
	${bul.synthese}<br>
	<h3>Logiciels affectés</h3>
	<c:forEach var="perlog" items="${modelperimetre.getListe()}">
		<c:if test="${param.id==perlog.id_bulletin}">
			<c:set var="log" value="${model.chercherLogiciels(perlog.id_logiciel)}"/>
			${log.nom}<br>
		</c:if>
	</c:forEach><br>
	
	<h3>Description</h3>
	${bul.description}
	<h3>Solutions</h3>

	<c:forEach var="persol" items="${modelperimetre_solution.getListe()}">

		<c:if test="${param.id==persol.id_bulletin}">

							
			<c:forEach var="sol" items="${modelsolution.getListe()}">

				<c:if test="${persol.id_solution==sol.id_solution}">
					- ${sol.getDescription()}<br>
					<c:url value="/Suppression" var="sup">
					<c:param name="solid" value="${sol.id_solution}"/>
					<c:param name="bulsolid" value="${persol.id_bulletin}"/>
										
					</c:url>
					<nav><a href="${sup }">Supprimer cette solution</a></nav>
				</c:if>
								
			</c:forEach><br>
		</c:if>
	</c:forEach>
	<c:url value="/ajoutsolution.jsp" var="aj_sol">
		<c:param name="id" value="${bul.id}"/>
						
	</c:url>
	<nav><a href="${aj_sol}">Ajouter une solution</a></nav>
				
	<h3>References</h3>
	${bul.getReferences_liees_bulletin()}<br>
					
					<c:url value="/Suppression" var="sup">
						<c:param name="bulid" value="${bul.id}"/>
						
					</c:url>
					<nav><a href="${sup }">Supprimer ce bulletin</a></nav>
					<hr>
				
				<c:set var="i" value="${i+1}" />
				


<br>




<nav><a href="listelogadmin.jsp">Retour liste logiciels</a></nav>

</body>
</html>
</html>