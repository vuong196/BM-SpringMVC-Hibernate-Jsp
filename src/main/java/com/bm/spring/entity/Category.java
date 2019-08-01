
package com.bm.spring.entity;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
@Entity(name = "entity.Category")
@Table(name = "category", catalog = "dckkgcufb23jta")
public class Category {

	public Category() {
	}

	public Set<Book> getCategoryBookSet() {

		return _categoryBookSet;
	}

	public int getCategoryId() {

		return _categoryId;
	}

	public String getCategoryName() {

		return _categoryName;
	}

	public void setCategoryBookSet(Set<Book> categoryBookSet) {

		_categoryBookSet = categoryBookSet;
	}

	public void setCategoryId(int categoryId) {

		_categoryId = categoryId;
	}

	public void setCategoryName(String categoryName) {

		_categoryName = categoryName;
	}

	@ManyToMany(fetch = FetchType.EAGER, mappedBy = "_bookCategorySet")
	private Set<Book> _categoryBookSet = new HashSet<>(0);

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "category_id")
	private int _categoryId;

	@Column(name = "category_name", length = 50, nullable = false)
	private String _categoryName;
}
