package dao;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import model.Blog;
import utility.HibernateConnectionManager;

public class BlogDaoImpl implements BlogDaoInterface{

	private SessionFactory sessionFactory = HibernateConnectionManager.getSessionFactory();

	
	@Override
	public void insertBlog(Blog blog) throws SQLException, Exception {
		Session session = this.sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(blog);
		transaction.commit();
		session.close();
		
	}

	@Override
	public Blog selectBlog(int blogid) throws Exception {
		Session session = this.sessionFactory.openSession();
		Blog blog=session.get(Blog.class, blogid);
		session.close();
		return blog;
	}

	@Override
	public List<Blog> selectAllBlogs() throws Exception {
		Session session = this.sessionFactory.openSession();
		CriteriaBuilder builder=session.getCriteriaBuilder();
		CriteriaQuery<Blog> query=builder.createQuery(Blog.class);
		Root<Blog> root=query.from(Blog.class);
		query.select(root);
		Query<Blog> q=session.createQuery(query);
		List<Blog> listblog=q.getResultList();
		return listblog;
	}

	@Override
	public void deleteBlog(int id) throws SQLException, Exception {
		Session session = this.sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Blog blog=session.get(Blog.class,id);
		session.delete(blog);
		transaction.commit();
		session.close();
	}

	@Override
	public void updateBlog(Blog blog) throws SQLException, Exception {
		Session session = this.sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.update(blog);
		transaction.commit();
		session.close();
	}
	
	
}