
package com.bm.spring.dao;

import java.util.List;
import com.bm.spring.entity.Author;
public interface AuthorDAO {

	public void addAuthor(Author a) throws Exception;

	public void editAuthor(Author a) throws Exception;

	public void deleteAuthor(int id) throws Exception;

	public List<Author> getAuthorList() throws Exception;

	public Author getAuthorById(int id) throws Exception;
}
