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

<%-- <jsp:useBean id="model" class="pac1.Model"/> --%>
<%-- <c:set var="p" value="${model.chercherLogiciels(param.id)}"/> --%>
<%-- Code: ${param.code} --%>


<jsp:useBean id="model" class="package1.Model"></jsp:useBean>
<jsp:useBean id="modelbulletin" class="package1.Modelbulletin"></jsp:useBean>
<jsp:useBean id="bulletin" class="package1.Bulletin"></jsp:useBean>
<jsp:setProperty property="*" name="bulletin"/>

<form action="listeperimetre.jsp">
            <h3> Ajout d'une solution (admin)</h3>
            
           	
            <fieldset>
    		<table>
    		<tr>
            <td><label>Nom logiciel :</label></td> 
            <td><select name="nom" value=nom>
	            	<c:forEach var="log" items="${model.getListe()}">
						<option value="${log.nom}">${log.nom}</option>
					</c:forEach></td>
				</select>
            </tr>
			 <td> <label>Id user :</label></td><td>
           	
	            <select name="id_utilisateur" value=id_utilisateur >
	            
							<option value="${id_session}">${id_session}</option>
					
				</select></td>  
            </tr>

			</table>
<%-- 			<c:if test="${param.test==1}"> --%>
<!--  				<font color="red">Cet id est déjà attribué</font> -->
<%-- 			</c:if><br> --%>
            <input type="submit" value="Ajouter">

                
            </fieldset>
            
            </form>
            
<c:url value="/listeperimetre.jsp" var="perimetre">
	<c:param name="id" value="${param.id_user}"/>
</c:url>

<nav><a href="${perimetre}">Retour liste perimetres</a></nav>
	

</body>
</html>