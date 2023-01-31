<%@page import="javax.persistence.EntityManager"%>
<%@page import="javax.persistence.Persistence"%>
<%@page import="javax.persistence.EntityManagerFactory"%>
<%@page import="SchoolManagnment.teacher" %>
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
		
		teacher t=em.find(teacher.class, id1);
	%>
	<form action="updatet" method="post">
		ID:<input type="text" value="<%=t.getId()%>" name="id"><p>
		Name:<input type="text" value="<%=t.getName()%>" name="name"><p>
		Name:<input type="text" value="<%=t.getSal()%>" name="sal"><p>
		Name:<input type="text" value="<%=t.getSub()%>" name="sub"><p>
		<input type="submit" value="UPDATE">
	</form>
	}
	

</body>
</html>