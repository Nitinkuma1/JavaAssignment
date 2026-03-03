package com.capgemini.bookstore.service;
import org.springframework.data.domain.Sort;
import java.time.LocalDate;
import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.capgemini.bookstore.exception.BookNotFoundException;
import com.capgemini.bookstore.model.Book;
import com.capgemini.bookstore.repository.BookRepository;

@Service
public class BookService {
	BookRepository repository;
	public BookService(BookRepository repository) {
		super();
		this.repository = repository;
	}
	private void checkEmpty(List<Book> books) {
        if (books.isEmpty()) {
            throw new BookNotFoundException("No books found.");
        }
    }
	public List<Book> findByAuthor(String author) {
	    List<Book> books = repository.findByAuthor(author);
	    checkEmpty(books);
	    return books;
	}

	public List<Book> getByGenre(String genre) {
	    List<Book> books = repository.findByGenre(genre);
	    checkEmpty(books);
	    return books;
	}
	public List<Book> getGenreWithPage(String genre, int page, int size) {
	    List<Book> books = repository.findByGenre(genre, PageRequest.of(page, size));
	    checkEmpty(books);
	    return books;
	}

	public List<Book> cheaperThan(Double price) {
	    List<Book> books = repository.findByPriceLessThan(price);
	    checkEmpty(books);
	    return books;
	}

	public List<Book> greaterThan(Double price) {
	    List<Book> books = repository.findByPriceGreaterThan(price);
	    checkEmpty(books);
	    return books;
	}

	public List<Book> publishDateAfter(LocalDate date) {
	    List<Book> books = repository.findByPublishedDateAfter(date);
	    checkEmpty(books);
	    return books;
	}

	public List<Book> publishDateBefore(LocalDate date) {
	    List<Book> books = repository.findByPublishedDateBefore(date);
	    checkEmpty(books);
	    return books;
	}

	public List<Book> titleContaining(String title) {
	    List<Book> books = repository.findByTitleContaining(title);
	    checkEmpty(books);
	    return books;
	}

	public List<Book> titleStartsWith(String title) {
	    List<Book> books = repository.findByTitleStartsWith(title);
	    checkEmpty(books);
	    return books;
	}

	public List<Book> titleEndsWith(String title) {
	    List<Book> books = repository.findByTitleEndsWith(title);
	    checkEmpty(books);
	    return books;
	}

	public List<Book> genreAndAuthor(String genre, String author) {
	    List<Book> books = repository.findByGenreAndAuthor(genre, author);
	    checkEmpty(books);
	    return books;
	}

	public List<Book> genreOrAuthor(String genre, String author) {
	    List<Book> books = repository.findByGenreOrAuthor(genre, author);
	    checkEmpty(books);
	    return books;
	}

	public List<Book> priceBetween(Double minPrice, Double maxPrice) {
	    List<Book> books = repository.findByPriceBetween(minPrice, maxPrice);
	    checkEmpty(books);
	    return books;
	}

	public List<Book> genreAndPriceLessThan(String genre, Double price) {
	    List<Book> books = repository.findByGenreAndPriceLessThan(genre, price);
	    checkEmpty(books);
	    return books;
	}

	public List<Book> orderByPublishedDateDesc() {
		Sort sort = Sort.by("publishedDate").descending();
	    List<Book> books = repository.findAll(sort);
	    checkEmpty(books);
	    return books;
	}

	public List<Book> orderByPriceAsc() {
		Sort sort = Sort.by("price").ascending();
	    List<Book> books = repository.findAll(sort);
	    checkEmpty(books);
	    return books;
	}

	public List<Book> getAll() {
	    List<Book> books = repository.findAll();
	    checkEmpty(books);
	    return books;
	}
	
}
