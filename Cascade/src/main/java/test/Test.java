package test;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import model.MyOrder;
import model.OrderDetail;
import util.HibernateUtil;

public class Test {
	public static void main(String[] args) {
		try {
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			if(sessionFactory != null) {
				Session session = sessionFactory.openSession();
				Transaction tr = session.beginTransaction();
////				
//				MyOrder o1 = new MyOrder("Don hang 1", "Ha Van Dung", false);
//				OrderDetail od1 = new OrderDetail("Suc manh cua thoi quen", 1, 70000, o1);
//				OrderDetail od2 = new OrderDetail("Nha gia kim", 1, 80000, o1);
//				o1.addOrderDetail(od1);
//				o1.addOrderDetail(od2);
//				
//				session.save(o1);
//				session.save(od1);
//				session.save(od2);
				
				MyOrder o1 = session.load(MyOrder.class, 2);
				session.remove(o1);
				
				
				tr.commit();
				session.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
