package test;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import model.Employee;
import model.Meeting;
import util.HibernateUtil;

public class Test {
	public static void main(String[] args) {
		try {
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			if(sessionFactory != null) {
				Session session = sessionFactory.openSession();
				Transaction tr = session.beginTransaction();
				
				// Tao cuoc hop
				Meeting m2 = new Meeting("Cuoc hop 2", "Phong IT", new Date(2022 - 1900, 12 - 1, 15));
				session.save(m2);
				Meeting m3 = new Meeting("Cuoc hop 3", "Phong IT", new Date(2022 - 1900, 12 - 1, 15));
				session.save(m3);
				Meeting m4 = new Meeting("Cuoc hop 4", "Phong IT", new Date(2022 - 1900, 12 - 1, 15));
				session.save(m4);
				// Tao nhan vien
				Set<Meeting> mettings = new HashSet<Meeting>();
				mettings.add(m2);
				mettings.add(m3);
				mettings.add(m4);
				Employee e3 = new Employee("E03", "Nguyen Van A", "vana@gmail.com", mettings);
				session.save(e3);
				
				
				
				tr.commit();
				session.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
