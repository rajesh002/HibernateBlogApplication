package dao;

import javax.transaction.SystemException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import model.User;
import utility.HibernateConnectionManager;

public class UserDAO implements UserDaoInterface {
	
	private SessionFactory sessionFactory = HibernateConnectionManager.getSessionFactory();

	public int signUp(User user){
		Session session = this.sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		if(session.save(user)!=null) {
			transaction.commit();
			session.close();
			return 1;
		}
		else {
			return 0;
		}
	}
	
	
	
	
	
	
	
	public boolean loginUser(User user) throws SystemException  {
		Session session = this.sessionFactory.openSession();
		Transaction tx=null;
		try{
			tx=(Transaction) session.getTransaction();
			tx.begin();
			Query query = session.createQuery("from User where email='"+user.getEmail()+"'"+"and password='"+user.getPassword()+"'");
			user=(User)query.uniqueResult();
			tx.commit();
		}catch (Exception e) {
			if(tx!=null) {
				try {
					tx.rollback();
				}catch(IllegalStateException e1) {
					e1.printStackTrace();
				}
		}
		e.printStackTrace();
		}
		finally {
			session.close();
		}
		return true;
	}
}