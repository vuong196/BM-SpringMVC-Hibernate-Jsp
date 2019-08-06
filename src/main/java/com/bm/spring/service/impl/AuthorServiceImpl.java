
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

	@Override
	@Transactional
	public void addAuthor(Author a) throws Exception {

		_authorDAO.addAuthor(a);
	}

	@Override
	@Transactional
	public void deleteAuthor(int id) throws Exception {

		_authorDAO.deleteAuthor(id);
	}

	@Override
	@Transactional
	public Author getAuthorById(int id) throws Exception {

		return _authorDAO.getAuthorById(id);
	}

	@Override
	@Transactional
	public List<Author> getAuthorList() throws Exception {

		return _authorDAO.getAuthorList();
	}

	@Override
	@Transactional
	public void updateAuthor(Author a) throws Exception {

		_authorDAO.updateAuthor(a);
	}

	@Autowired
	private AuthorDAO _authorDAO;
}
