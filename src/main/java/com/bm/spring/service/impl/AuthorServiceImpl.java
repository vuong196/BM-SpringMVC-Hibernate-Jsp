
package com.bm.spring.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.bm.spring.dao.AuthorDAO;
import com.bm.spring.entity.Author;
import com.bm.spring.service.AuthorService;
@Service
public class AuthorServiceImpl implements AuthorService {

	@Autowired
	private AuthorDAO _authorDAO;

	@Override
	@Transactional
	public List<Author> getAuthorList() throws Exception {

		return this._authorDAO.getAuthorList();
	}

	@Override
	@Transactional
	public void addAuthor(Author a) throws Exception {

		this._authorDAO.addAuthor(a);
	}

	@Override
	@Transactional
	public void editAuthor(Author a) throws Exception {

		this._authorDAO.editAuthor(a);
	}
	
	@Override
	@Transactional
	public void deleteAuthor(int id) throws Exception {

		this._authorDAO.deleteAuthor(id);
	}

	@Override
	@Transactional
	public Author getAuthorById(int id) throws Exception {

		return this._authorDAO.getAuthorById(id);
	}
}
