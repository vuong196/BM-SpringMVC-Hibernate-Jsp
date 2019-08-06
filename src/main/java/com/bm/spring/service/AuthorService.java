
package com.bm.spring.service;

import java.util.List;

import com.bm.spring.entity.Author;

public interface AuthorService {

	public void addAuthor(Author a) throws Exception;

	public void deleteAuthor(int id) throws Exception;

	public Author getAuthorById(int id) throws Exception;

	public List<Author> getAuthorList() throws Exception;

	public void updateAuthor(Author a) throws Exception;
}
