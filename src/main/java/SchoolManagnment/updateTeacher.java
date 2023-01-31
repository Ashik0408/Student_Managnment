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
@WebServlet("/updatet")
public class updateTeacher extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id=req.getParameter("id");
		String name=req.getParameter("name");
		String sal=req.getParameter("sal");
		String sub=req.getParameter("sub");
		
		int id1=Integer.parseInt(id);
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("prasad");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
	
		teacher t= new teacher();
		
		t.setId(id1);
		t.setName(name);
		t.setSal(Double.parseDouble(sal));
		t.setSub(sub);
		Query query=em.createQuery("select b from teacher b where b.id=?1");
		query.setParameter(1, id1);
		
		List<teacher> l=query.getResultList();
		if(l.size()>0)
		{
			
		et.begin();
		em.merge(t);
		et.commit();
		
		PrintWriter pw=resp.getWriter();
		pw.write("Teacher Detail Update Successsfully...");
		resp.setContentType("text/html");
		RequestDispatcher rd=req.getRequestDispatcher("teacher.html");
		rd.include(req, resp);
		}
		else
		{
			PrintWriter pw=resp.getWriter();
			pw.write("Data not found please enter correct id...");
			resp.setContentType("text/html");
			RequestDispatcher rd=req.getRequestDispatcher("teacher.html");
			rd.include(req, resp);
		}

}
}
