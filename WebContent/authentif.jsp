<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Authentification</title>
</head>

<body>

	<form action="Authentification" name="informations">
            <h3> Connexion</h3>
           	<table>
            <fieldset>
    		
    		<tr>
    		<td>
            <label>Login :</label></td><td>  <input type= "text"  name="login"> </td><br>
            <tr>
    		<td>
            <label>Password :</label></td><td> <input type= "text" name="pwd"></td> <br>
			<tr>
    		<td>
            <input type="submit" value="Valider">
            </td>
			</tr>
			
            
            </fieldset>
            </table>   
	</form>
       

</body>
</html>