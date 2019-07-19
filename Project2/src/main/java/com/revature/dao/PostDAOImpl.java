package com.revature.dao;

import java.util.ArrayList;
import java.util.List;



import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

//import com.revature.config.HibernateUtil;
import com.revature.entity.Post;

@Repository("postDAO")
public class PostDAOImpl implements PostDAO{
	@Autowired
		SessionFactory sessionFact;
	
	public java.util.List<Post> getAllPosts(){
		
		System.out.println("dao");
		
		ArrayList<Post> postlist = new ArrayList<>();
		
		Query query = sessionFact.getCurrentSession().createQuery("From Post");
		//query.setMaxResults(3);
		postlist =  (ArrayList<Post>) query.list();
		System.out.println("List in dao " + postlist);
		
		return postlist;
		
	}
	
	
	@Override
	public void addPost(Post post) {
	
		sessionFact.getCurrentSession().save(post);
		System.out.println(post + " saved");
		
	}
//		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
//			session.beginTransaction();
//			session.persist(book);
//			/*
//			 * System.out.println("Book Id in Service: "+book); 
//			 * session.persist(book);
//			 */
//			//Integer id = (Integer)session.save(book);
////			System.out.println("Book is created with Id: "+id);
//			session.getTransaction().commit();
//		} catch (HibernateException e) {
//			e.printStackTrace();
//		}
//		
//	}
//
	@Override
	public Post fetchPostbyId(int postId) {
//		try (Session session = HibernateUtil.getSessionFactory().openSession()){
//			/*
//			 * book = session.get(Book.class, BookId); //always hits database Book b1 =
//			 * session.load(Book.class, BookId); //loads return fake object
//			 */			
//			Book book = session.get(Book.class, bookId); //returns null pointer
//			//Book b1 = session.load(Book.class,  new Integer(100)); //returns null
//			System.out.println("Book Id is " + bookId);
//			if(book != null) {
//				System.out.println("Book title is " + book.getTitle());
//				return book;
//			} 
//			else {
//				System.out.println("Book does not exist");
//			}
//		} catch (HibernateException e) {
//			System.out.println("Book with the provided ID does not exist");
//			e.printStackTrace();
//		}
//		return null;
		
		Session currentSession = sessionFact.getCurrentSession();
		Post thepost = currentSession.get(Post.class, postId);
		return thepost;
		
	}
//
	@Override
	public void deletePostById(int PostId) {
	
		Session currentSession = sessionFact.getCurrentSession();
		Post post = currentSession.byId(Post.class).load(PostId);
		System.out.println(" Delete this book: " + post);
		currentSession.delete(post);
	}
//		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
//			
//			Book book = session.get(Book.class,  BookId);
//			if(book != null) {
//				session.beginTransaction();
//				session.delete(book);
//				session.getTransaction().commit();
//			}else {
//				System.out.println("The book with an id of "+BookId+" does not exist");	
//			}
//		} catch(HibernateException e) {
//			e.printStackTrace();
//		}
//		
//	}
//
//	@Override
//	public void updateBookById(int BookId, Float price) {
//		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
//			
//			Book book = session.get(Book.class,  BookId);
//			if(book != null) {
//				session.beginTransaction();
//				book.setPrice(price);
//				session.getTransaction().commit();
//				System.out.println(BookId + " price update, price is now " + price);
//			}else {
//				System.out.println("The book with an id of "+BookId+" does not exist");	
//			}
//		} catch(HibernateException e) {
//			e.printStackTrace();
//		}
//		
//	}

}
