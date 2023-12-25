package test;

import java.sql.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import dao.CatDAO;
import model.Cat;
import util.HibernateUtil;

public class TestCat2 {
	public static void main(String[] args) {
		// Transient
		Cat newCat = new Cat("Long Xu", new Date(2023, 12, 1), true);
		
		try {
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			if (sessionFactory != null) {
				Session session = sessionFactory.openSession();
				Transaction tr = session.beginTransaction();
				
				// Persistent
				session.save(newCat);
				
				// Detached => Persistent
				// session.refresh(newCat);
				
				// Detached
				tr.commit();
				session.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println(newCat);
	}
}
