
package com.bm.spring.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.bm.spring.entity.Author;
import com.bm.spring.service.AuthorService;

@Component
public class BookAuthorToAuthor implements Converter<Object, Author> {

	@Override
	public Author convert(Object element) {
		
		int id = Integer.parseInt((String) element);
		Author author = new Author();
		try {
			author = _authorService.getAuthorById(id);
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("AUthor: " + author);
		return author;
	}
	
	@Autowired
	private AuthorService _authorService;

}
