package com.sistemi.service;

import com.sistemi.entity.Book;

public interface BookService {
	
	public void saveOrUpdateBook(Book book);
	
	public void removeBook(long isbn);
	
	public void findAllBooks();
	
	public void findAllBooksByGenre(String string);

}
