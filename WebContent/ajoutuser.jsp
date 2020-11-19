<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action="listeuser.jsp">
            <h3> Ajout d'un bulletin (user)</h3>
            
           	
            <fieldset>
    		<table>

            <tr>
            	<td><label>login :</label></td><td> <input type= "text" name="login"></td> 
            </tr>
            <tr>
            	<td><label>Mot de passe :</label> </td><td><input type= "text" name="pwd"> </td>
            </tr>
            <tr>
            	<td><label>Nom :</label></td><td> <input type= "text" name="nom"></td> 
            </tr>
            <tr>
            
            	<td><label>role :</label></td><td> <input type= "text" name="role"> </td>
            </tr>
            <tr>
           <td> <label>Mail :</label></td><td> <input type= "text" name="mail"></td> 
            </tr>
     
           
			</table>
            <input type="submit" value="Ajouter">

                
            </fieldset>
            
            </form>

</body>
</html>