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
<jsp:useBean id="bulletin" class="package1.Bulletin"></jsp:useBean>
<jsp:setProperty property="*" name="bulletin"/>

${bulletin.getId()}
<form action="listelogadmin.jsp">
            <h3> Ajout d'un bulletin (admin)</h3>
            
           	
            <fieldset>
    		<table>
    		<tr>
            	<td><label>Id :</label></td>  <td><input type= "text"  name="id"></td> 
            </tr>
            <tr>
            	<td><label>Nom du bulletin :</label></td><td> <input type= "text" name="nom_bulletin"></td> 
            </tr>
            <tr>
            	<td><label>Synthese :</label> </td><td><input type= "text" name="synthese"> </td>
            </tr>
            <tr>
            	<td><label>Date :</label></td><td> <input type= "text" name="date"></td> 
            </tr>
            <tr>
            
            	<td><label>Reference du bulletin :</label></td><td> <input type= "text" name="reference_bulletin"> </td>
            </tr>
            <tr>
           <td> <label>Priorite :</label></td><td> <input type= "text" name="priorite"></td> 
            </tr>
<!--             <tr> -->
<!--            <td> <label>Logiciels affectés :</label></td><td> -->
           	
<!-- 	            <select name="logiciels_affectes" value=logiciels_affectes multiple> -->
<%-- 	            	<c:forEach var="log" items="${model.getListe()}"> --%>
<%-- 						<option value="${log.nom}">${log.nom}</option> --%>
<%-- 					</c:forEach> --%>
<!-- 				</select></td>   -->
<!--             </tr> -->
            <tr>
           <td> <label>Description :</label></td><td><textarea rows="10" cols="30" name="description"></textarea></td>
            </tr>
            <tr>
            <td><label>Source :</label> </td><td><input type= "text" name="references_liees_bulletin"></td> 
           	</tr>
           
			</table>
			
			<c:if test="${param.var==1}">
 				<font color="red">Cet id est déjà attribué</font>
			</c:if><br>
            <input type="submit" value="Ajouter">

                
            </fieldset>
            
            </form>

	<nav><a href="listelogadmin.jsp">Retour liste logiciels</a></nav>

</body>
</html>