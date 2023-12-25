package test;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import dao.CatDAO;
import model.Cat;

public class TestCat {
	public static void main(String[] args) {
		CatDAO catDao = new CatDAO();
		List<Cat> cats = new ArrayList<Cat>();
		cats = catDao.selectAll();
		
		for (Cat cat : cats) {
			System.out.println(cat);
		}
		
//		Cat catFind = new Cat();
//		catFind.setId(2);
//		
//		System.out.println(catDao.selectById(catFind));
		
//		Cat newCat = new Cat("Mun New Update", new Date(2023, 12, 23), false);
//		newCat.setId(3);
//		System.out.println(catDao.update(newCat));
	}
}
