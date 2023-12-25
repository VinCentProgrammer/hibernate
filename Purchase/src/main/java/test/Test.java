package test;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import model.Customer;
import model.MyOrder;
import util.HibernateUtil;

public class Test {
	public static void main(String[] args) {
		try {
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			if(sessionFactory != null) {
				Session session = sessionFactory.openSession();
				Transaction tr = session.beginTransaction();
				
//				Customer c1 = new Customer("C002", "Van Dung Ha", true, "dungken2112@gmail.com");
//				session.save(c1);
//				
//				Customer c1 = session.find(Customer.class, "C001");
//				
//				MyOrder o1 = new MyOrder("O001", "Hieu ve trai tim", new Date(System.currentTimeMillis()), c1);
//				MyOrder o2 = new MyOrder("O002", "Dac nhan tam", new Date(System.currentTimeMillis()), c1);
//				MyOrder o3 = new MyOrder("O003", "Thoi quen nho", new Date(System.currentTimeMillis()), c1);
//				
//				List<MyOrder> orders = new ArrayList<MyOrder>();
//				orders.add(o1);
//				orders.add(o2);
//				orders.add(o3);
//				
//				c1.setMyOrders(orders);
//				session.save(o1);
//				session.save(o2);
//				session.save(o3);
				
				String hql = "FROM Customer c WHERE size(c.myOrders) > 0";
				Query query = session.createQuery(hql);
				List<Customer> customers = new ArrayList<Customer>();
				customers = query.getResultList();
				for (Customer c : customers) {
					System.out.println(c);
				}
				
				
				tr.commit();
				session.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
