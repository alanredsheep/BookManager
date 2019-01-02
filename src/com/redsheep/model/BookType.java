package com.redsheep.model;

public class BookType {
	private int id;
	private String bookType;

	public BookType(int id, String bookType) {
		super();
		this.id = id;
		this.bookType = bookType;
	}

	public BookType(String bookType) {
		super();
		this.bookType = bookType;
	}

	public BookType() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBookType() {
		return bookType;
	}

	public void setBookType(String bookType) {
		this.bookType = bookType;
	}

	@Override
	public String toString() {
		return this.bookType;
	}

}
