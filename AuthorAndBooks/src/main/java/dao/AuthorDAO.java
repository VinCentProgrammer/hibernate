package dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import model.Author;
import util.HibernateUtil;

public class AuthorDAO implements DAOInterface<Author> {

	@Override
	public List<Author> selectAll() {
		List<Author> authors = new ArrayList<Author>();
		try {
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			if (sessionFactory != null) {
				Session session = sessionFactory.openSession();
				Transaction tr = session.beginTransaction();

				String hql = "from Author";
				Query query = session.createQuery(hql);
				authors = query.getResultList();

				tr.commit();
				session.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return authors;
	}

	@Override
	public Author selectById(Author t) {
		List<Author> authors = new ArrayList<Author>();
		try {
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			if (sessionFactory != null) {
				Session session = sessionFactory.openSession();
				Transaction tr = session.beginTransaction();

				String hql = "from Author a where a.authorId = :id";
				Query query = session.createQuery(hql);
				query.setParameter("id", t.getAuthorId());
				authors = query.getResultList();

				tr.commit();
				session.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (authors.size() > 0) {
			return authors.get(0);
		} else {
			return null;
		}
	}

	@Override
	public boolean insert(Author t) {
		try {
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			if (sessionFactory != null) {
				Session session = sessionFactory.openSession();
				Transaction tr = session.beginTransaction();

				session.save(t);

				tr.commit();
				session.close();
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean update(Author t) {
		try {
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			if (sessionFactory != null) {
				Session session = sessionFactory.openSession();
				Transaction tr = session.beginTransaction();

				session.saveOrUpdate(t);

				tr.commit();
				session.close();
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean delete(Author t) {
		try {
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			if (sessionFactory != null) {
				Session session = sessionFactory.openSession();
				Transaction tr = session.beginTransaction();

				session.delete(t);

				tr.commit();
				session.close();
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
