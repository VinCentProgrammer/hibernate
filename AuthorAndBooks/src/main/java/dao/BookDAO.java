package dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import model.Books;
import util.HibernateUtil;

public class BookDAO implements DAOInterface<Books> {

	@Override
	public List<Books> selectAll() {
		List<Books> Bookss = new ArrayList<Books>();
		try {
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			if (sessionFactory != null) {
				Session session = sessionFactory.openSession();
				Transaction tr = session.beginTransaction();

				String hql = "from Books";
				Query query = session.createQuery(hql);
				Bookss = query.getResultList();

				tr.commit();
				session.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Bookss;
	}

	@Override
	public Books selectById(Books t) {
		List<Books> books = new ArrayList<Books>();
		try {
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			if (sessionFactory != null) {
				Session session = sessionFactory.openSession();
				Transaction tr = session.beginTransaction();

				String hql = "from Books a where a.BooksId = :id";
				Query query = session.createQuery(hql);
				query.setParameter("id", t.getBookId());
				books = query.getResultList();

				tr.commit();
				session.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (books.size() > 0) {
			return books.get(0);
		} else {
			return null;
		}
	}

	@Override
	public boolean insert(Books t) {
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
	public boolean update(Books t) {
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
	public boolean delete(Books t) {
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
