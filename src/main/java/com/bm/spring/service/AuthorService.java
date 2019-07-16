
package com.bm.spring.service;

import java.util.List;
import com.bm.spring.model.Author;
public interface AuthorService {

	public void addAuthor(Author a) throws Exception;

	public void editAuthor(Author a) throws Exception;

	public void deleteAuthor(String id) throws Exception;

	public List<Author> getAuthorList() throws Exception;

	public Author getAuthorById(String id) throws Exception;
}
