
package com.bm.spring.entity;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
@Entity(name = "entity.Category")
@Table(name = "category", catalog = "bookmanagement")
public class Category {

	public Category() {

	}

	public Set<Book> getCategoryBookSet() {

		return categoryBookSet;
	}

	public String getCategoryId() {

		return categoryId;
	}

	public String getCategoryName() {

		return categoryName;
	}

	public void setCategoryBookSet(Set<Book> categoryBookSet) {

		this.categoryBookSet = categoryBookSet;
	}

	public void setCategoryId(String categoryId) {

		this.categoryId = categoryId;
	}

	public void setCategoryName(String categoryName) {

		this.categoryName = categoryName;
	}

	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "_bookCategorySet")
	private Set<Book> categoryBookSet = new HashSet<>(0);

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "category_id")
	private String categoryId;

	@Column(name = "category_name", length = 50, nullable = false)
	private String categoryName;
}
