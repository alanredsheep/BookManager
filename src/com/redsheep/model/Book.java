package com.redsheep.model;

/**
 * Book
 * 
 * @author Redsheep
 *
 */
public class Book {
	private int id;
	private String bookName;
	private String author;
	private boolean isDomestic;
	private Float grade;
	private Float price;
	private Integer bookTypeId;
	private String bookTypeName;

	public Book(int id, String bookName, String author, boolean isDomestic, Float grade, Float price,
			Integer bookTypeId) {
		super();
		this.id = id;
		this.bookName = bookName;
		this.author = author;
		this.isDomestic = isDomestic;
		this.grade = grade;
		this.price = price;
		this.bookTypeId = bookTypeId;
	}

	public Book(String bookName, String author, Integer bookTypeId) {
		super();
		this.bookName = bookName;
		this.author = author;
		this.bookTypeId = bookTypeId;
	}

	public Book(String bookName, String author, boolean isDomestic, Float grade, Float price, Integer bookTypeId) {
		super();
		this.bookName = bookName;
		this.author = author;
		this.isDomestic = isDomestic;
		this.grade = grade;
		this.price = price;
		this.bookTypeId = bookTypeId;
	}

	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public boolean isDomestic() {
		return isDomestic;
	}

	public void setDomestic(boolean isDomestic) {
		this.isDomestic = isDomestic;
	}

	public Float getGrade() {
		return grade;
	}

	public void setGrade(Float grade) {
		this.grade = grade;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public Integer getBookTypeId() {
		return bookTypeId;
	}

	public void setBookTypeId(Integer bookTypeId) {
		this.bookTypeId = bookTypeId;
	}

	public String getBookTypeName() {
		return bookTypeName;
	}

	public void setBookTypeName(String bookTypeName) {
		this.bookTypeName = bookTypeName;
	}
}
