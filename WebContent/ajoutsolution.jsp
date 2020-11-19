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

<form action="listelogadmin.jsp">
            <h3> Ajout d'une solution (admin)</h3>
            
           	
            <fieldset>
    		<table>
    		<tr>
            	<td><label>Id :</label></td>  <td><input type= "text"  name="id_solution"></td> 
            </tr>

            <tr>
           <td> <label>Description :</label></td><td><textarea rows="10" cols="30" name="description"></textarea></td>
            </tr>
  			  <tr>
<!--            <td> <label>Bulletins concernés :</label></td><td> -->
           	
<!-- 	            <select name="id_bulletin" value=id_bulletin multiple> -->
<%-- 	            	<c:forEach var="bull" items="${modelbulletin.getListe()}"> --%>
<%-- 						<option value="${bull.id_bulletin}">${bull.id_bulletin}</option> --%>
<%-- 					</c:forEach> --%>
<!-- 				</select></td>   -->
           <td> <label>Id bulletin :</label></td><td>
           	
	            <select name="id_bulletin" value=id_bulletin >
	            
							<option value="${param.id}">${param.id}</option>
					
				</select></td>  
            </tr>
           
			</table>
			<c:if test="${param.test==1}">
 				<font color="red">Cet id est déjà attribué</font>
			</c:if><br>
            <input type="submit" value="Ajouter">

                
            </fieldset>
            
            </form>

	<nav><a href="listelogadmin.jsp">Retour liste logiciels</a></nav>

</body>
</html>