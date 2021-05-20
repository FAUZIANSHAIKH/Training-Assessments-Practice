package com.sapient.dao;


import java.util.List;
import java.util.ListIterator;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.QueryProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sapient.model.Post;
import com.sapient.model.User;

@Repository(value="HybernateDAOImpl")
public class HybernateDAOImpl implements UserDAO
{
	@Autowired
    private SessionFactory sessionFactory;



	public void saveUser(User user) {
		System.out.println("hello");
		Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(user);
	}

	
	public List<User> listAll() {
		System.out.println("hello");
		Session currentSession = sessionFactory.getCurrentSession();
        return currentSession.createQuery("from User ").list();
	}


	public User findById(int id) {
		System.out.println("hello");
		return sessionFactory.getCurrentSession().get(User.class, id);
	}

	
	public void deleteUser(int id) {
		System.out.println("hello");
		Session session = sessionFactory.getCurrentSession();
        User user = session.byId(User.class).load(id);
        session.delete(user);
	}

	
	public void updateUser(int id, User user) {
		System.out.println("hello");
		Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(user);
        
	}
	
	public void savePost(Post post) {
		System.out.println("hello");
		Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(post);
        
	}

	
	public List<Post> listAllPost() {
		System.out.println("hello");
		Session currentSession = sessionFactory.getCurrentSession();
        return currentSession.createQuery("from Post ").list();
	}

	
	public List<Post> findPostById(int id)
	{
	 User user = sessionFactory.getCurrentSession().get(User.class,id);
	 return user.getPost();
	}

	
	public void deletePostById(int id) {
		System.out.println("hello");
		Session session=sessionFactory.getCurrentSession();
		User user=session.byId(User.class).load(id);
		List<Post> list=user.getPost();
		for(Post post:list)
		{
			session.delete(post);
		}
		user.setPost(null);
		session.saveOrUpdate(user);
		
	}
	
public void deletePost() {
//		Session session = sessionFactory.getCurrentSession();
//        Post post = session.byId("from Post").list();
//        session.delete(post);
	}
	
	
	public void updatePost(int id, User post) {
		System.out.println("hello");
		Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(post);
        
	}


	




	public void deletePost(int id) {
		((QueryProducer) sessionFactory).createSQLQuery("truncate table Post");
		}

}
	
	


