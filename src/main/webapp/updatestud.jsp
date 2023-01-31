<%@page import="javax.persistence.EntityManager"%>
<%@page import="javax.persistence.Persistence"%>
<%@page import="javax.persistence.EntityManagerFactory"%>
<%@page import="SchoolManagnment.student" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String id=request.getParameter("id");
		int id1=Integer.parseInt(id);
		
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("prasad");
		EntityManager em=emf.createEntityManager();
		
		student s=em.find(student.class, id1);
	
	
	%>
	
	<form action="updates" method="post">
		ID: <input type="text" value="<%=s.getId()%>" name="id"><p>
		NAME: <input type="text" value="<%=s.getName()%>" name="name"><p>
		FEES: <input type="text" value="<%=s.getFees()%>" name="fees"><p>
		
		<input type="submit">
	</form>
</body>
</html>