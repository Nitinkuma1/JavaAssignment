package com.capgemini.bookstore.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.bookstore.model.Book;
@Repository
public interface BookRepository extends JpaRepository<Book, Long>{
	public List<Book> findByAuthor(String author);
	public List<Book> findByGenre(String genre);
	public List<Book> findByGenre(String genre, PageRequest pageRequest);
	public List<Book> findByPriceLessThan(Double price);
	public List<Book> findByPriceGreaterThan(Double Price);
	
	public List<Book> findByPublishedDateAfter(LocalDate date);
	public List<Book> findByPublishedDateBefore(LocalDate date);
	public List<Book> findByTitleContaining(String keyword);
	public List<Book> findByTitleStartsWith(String keyword);
	
	public List<Book> findByTitleEndsWith(String keyword);
	public List<Book> findByGenreAndAuthor(String genre, String author);
	public List<Book> findByGenreOrAuthor(String genre, String author);
	
	public List<Book> findByPriceBetween(Double minPrice, Double maxPrice);
	public List<Book> findByGenreAndPriceLessThan(String genre,Double price);
	public List<Book> findByOrderByPublishedDateDesc();
	public List<Book> findByOrderByPriceAsc();
	
}
