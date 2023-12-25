package test;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import dao.AuthorDAO;
import dao.BookDAO;
import model.Author;
import model.Books;

public class TestBook {
	public static void main(String[] args) {
		BookDAO bookDao = new BookDAO();
		AuthorDAO authorDao = new AuthorDAO();
		Author author = authorDao.selectById(new Author("002"));
		Books book1 = new Books("B005", "Lap trinh C", 178000, author);
		Books book2 = new Books("B006", "Lap trinh Java", 155000, author);
		
		bookDao.insert(book1);
		bookDao.insert(book2);
	}
}
