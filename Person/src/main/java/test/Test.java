package test;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import dao.PersonDAO;
import model.Person;

public class Test {
	public static void main(String[] args) {
		PersonDAO personDao = new PersonDAO();
//		Person findPerson = new Person();
//		findPerson.setId(1);
//		Person husband = personDao.selectById(findPerson);
//		Person wife = new Person("Nguyen Thi B", new Date(System.currentTimeMillis()), husband);
//		personDao.insert(wife);
		
		
//		List<Person> persons = new ArrayList<Person>();
//		persons = personDao.selectAll();
//		for (Person person : persons) {
//			System.out.println(person);
//		}
		
		Person findWife = new Person();
		findWife.setId(2);
		Person wife = personDao.selectById(findWife);
		
		Person findHusband = new Person();
		findHusband.setId(1);
		Person husband = personDao.selectById(findHusband);
		
		husband.setSpouse(wife);
		
		personDao.update(husband);
		
//		Person findPerson = new Person();
//		findPerson.setId(1);
//		System.out.println(personDao.selectById(findPerson).toString());
	}
}
