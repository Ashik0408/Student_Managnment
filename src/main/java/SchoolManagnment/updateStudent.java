package SchoolManagnment;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.cj.Session;
@WebServlet("/updates")
public class updateStudent extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id=req.getParameter("id");
		String name=req.getParameter("name");
		String fees=req.getParameter("fees");
		
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("prasad");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
	
		student s=new student();
		int id1=Integer.parseInt(id);
		double fees1=Double.parseDouble(fees);
		s.setId(id1);
		s.setName(name);
		s.setFees(fees1);
		Query query=em.createQuery("select b from student b where b.id=?1");
		query.setParameter(1, id1);
		
		List<student> l=query.getResultList();
		if(l.size()>0)
		{
			
		et.begin();
		em.merge(s);
		et.commit();
		
		PrintWriter pw=resp.getWriter();
		pw.write("Student Detail Update Successsfully...");
		resp.setContentType("text/html");
		RequestDispatcher rd=req.getRequestDispatcher("student.html");
		rd.include(req, resp);
		}
		else
		{
			PrintWriter pw=resp.getWriter();
			pw.write("Data not found please enter correct id...");
			resp.setContentType("text/html");
			RequestDispatcher rd=req.getRequestDispatcher("student.html");
			rd.include(req, resp);
		}
}
}