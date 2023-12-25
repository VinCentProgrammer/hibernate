package test;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import dao.CatDAO;
import model.Cat;
import util.HibernateUtil;

public class TestCat {
	public static void main(String[] args) {
		CatDAO catDao = new CatDAO();
		// Transient
		Cat cat = new Cat();
		cat.setId(2);
		
		System.out.println(catDao.selectById(cat));
	}
}
