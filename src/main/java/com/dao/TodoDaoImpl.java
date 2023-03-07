package com.dao;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.stereotype.Component;

import com.entities.Todo;

@Component
public class TodoDaoImpl implements TodoDao{
	 
	Configuration con=new Configuration().configure("/com/dao/hibernate.cfg.xml").addAnnotatedClass(com.entities.Todo.class);
	

	public void saveTodo(Todo todo) {

		SessionFactory sf=con.buildSessionFactory();
		Session session =sf.openSession();
		session.getTransaction().begin();
		session.save(todo);
		session.getTransaction().commit();
		session.close();
		sf.close();
		return ;
	}
	
	
	@SuppressWarnings("unchecked")
	public List<Todo> getAllDoneTodo() {
		SessionFactory sf=con.buildSessionFactory();
		Session session =sf.openSession();
		session.getTransaction().begin();
		List<Todo>li=session.createQuery("from Todo t where t.done=false").list();
		session.getTransaction().commit();
		session.close();
		sf.close();
		for(Todo t:li) {
			System.out.println(t);
		}
		return li;
	}
	
	@SuppressWarnings("unchecked")
	public List<Todo> getAllNotDoneTodo() {
		SessionFactory sf=con.buildSessionFactory();
		Session session =sf.openSession();
		session.getTransaction().begin();
		List<Todo>li=session.createQuery("from Todo t where t.done=true").list();
		session.getTransaction().commit();
		session.close();
		sf.close();
		for(Todo t:li) {
			System.out.println(t);
		}
		return li;
	}

	public void doneTodo(String title) {
		SessionFactory sf=con.buildSessionFactory();
		Session session =sf.openSession();
		session.getTransaction().begin();
		
		
		String qry = "update Todo t set t.done=true where t.title=:tle";
	    Query query = session.createQuery(qry);
	    query.setParameter("tle", title);
	   query.executeUpdate();
	   
	   
		session.getTransaction().commit();
		session.close();
		sf.close();
		
	}


	public void deleteTodo(String title) {
		SessionFactory sf=con.buildSessionFactory();
		Session session =sf.openSession();
		session.getTransaction().begin();
		
		
		String qry = "delete Todo t where t.title=:tle";
	    Query query = session.createQuery(qry);
	    query.setParameter("tle", title);
	   query.executeUpdate();
	   
	   
		session.getTransaction().commit();
		session.close();
		sf.close();
	
		
	}

}
