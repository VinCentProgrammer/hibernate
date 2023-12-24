package test;

import java.sql.Date;

import javax.transaction.Transaction;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import model.Cat;
import util.HibernateUtil;

public class TestCat {
	public static void main(String[] args) {
		try {
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			if(sessionFactory != null) {
				Session session = sessionFactory.openSession();
				
				try {
					Transaction tr = (Transaction) session.beginTransaction();
					Cat cat = new Cat();
					cat.setName("Tom");
					cat.setSex(true);
					cat.setDateOfBirth(new Date(2050, 12, 21));
					
					session.save(cat);
					tr.commit();
					
				} finally {
					session.close();
				}
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
