package test;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import dao.AuthorDAO;
import model.Author;

public class TestAuthor {
	public static void main(String[] args) {
		AuthorDAO authorDao = new AuthorDAO();
		List<Author> authors = new ArrayList<Author>();
		authors = authorDao.selectAll();
		for (Author author : authors) {
			System.out.println(author);
		}
	}
}
