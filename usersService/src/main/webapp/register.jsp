<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="regForm" method="post">
	Name: <input type="text" name="name" /> <br/> <br/>
	Email: <input type="text" name="email" /> <br/> <br/>
	Password: <input type="password" name="pass" /> <br/> <br/>
	Gender: <input type="radio" name="gender" value="male" /> Male <input type="radio" name="gender" value="female" /> Female <br/> <br/>
	City : <select name="city">
			<option>Select City</option>
			<option>Delhi</option>
			<option>Mumbai</option>
			<option>Pune</option>
			<option>Bangalore</option>
		</select>
	<input type="submit" value="Register" />
</form>
</body>
</html>