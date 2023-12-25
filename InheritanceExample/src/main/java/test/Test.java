package test;

import java.sql.Date;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import model.Student;
import model.Teacher;
import util.HibernateUtil;

public class Test {
	public static void main(String[] args) {
		try {
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			if (sessionFactory != null) {
				Session session = sessionFactory.openSession();
				Transaction tr = session.beginTransaction();

				Teacher t1 = new Teacher(111, "Giao Vien", new Date(300, 11, 12), true, "Toan Roi Rac");
				Student st1 = new Student(12, "Hoc Sinh", new Date(300, 10, 14), true, 9.8);
				session.save(t1);
				session.save(st1);

				tr.commit();
				session.close();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
