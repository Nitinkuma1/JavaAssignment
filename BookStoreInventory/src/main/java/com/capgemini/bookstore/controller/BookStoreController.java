package com.capgemini.bookstore.controller;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.query.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.bookstore.model.Book;
import com.capgemini.bookstore.service.BookService;

@RestController
@RequestMapping("/api/books")
public class BookStoreController {
	BookService service;

	public BookStoreController(BookService service) {
		super();
		this.service = service;
	}
	@GetMapping("/author")
	public List<Book> findByAuthor(@RequestParam String author){
		return service.findByAuthor(author);
	}
	@GetMapping("/genrePage")
    public List<Book> byGenreWithPage(
            @RequestParam String genre,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size) {

        return service.getGenreWithPage(genre, page, size);
    }
	@GetMapping("/genre")
	public List<Book> bygenre(@RequestParam String genre){
		return service.getByGenre(genre);
	}
	@GetMapping("/cheaper")
	public List<Book> cheaper(@RequestParam Double price){
		return service.cheaperThan(price);
	}
	@GetMapping("/expensive")
	public List<Book> Greater(@RequestParam Double price){
		return service.greaterThan(price);
	}
	@GetMapping("/publishedAfter")
	public List<Book> publishedAfter(@RequestParam LocalDate date){
		return service.publishDateAfter(date);
	}
	@GetMapping("/publishedBefore")
	public List<Book> publishedBefore(@RequestParam LocalDate date){
		return service.publishDateBefore(date);
	}
	@GetMapping("/titleContain")
	public List<Book> titleContain(@RequestParam String title){
		return service.titleContaining(title);
	}
	@GetMapping("/titleStartsWith")
	public List<Book> titleStartsWith(@RequestParam String title){
		return service.titleStartsWith(title);
	}
	@GetMapping("/titleEndsWith")
	public List<Book> titleEndssWith(@RequestParam String title){
		return service.titleEndsWith(title);
	}
	@GetMapping("/GenreAndAuthor")
	public List<Book> GenreAndAuthor(@RequestParam String Genre,  @RequestParam String Author){
		return service.genreAndAuthor(Genre, Author);
	}
	@GetMapping("/GenreOrAuthor")
	public List<Book> GenreOrAuthor(@RequestParam String Genre,  @RequestParam String Author){
		return service.genreOrAuthor(Genre, Author);
	}
	@GetMapping("/PriceBetween")
	public List<Book> PriceBetween(Double minPrice, Double maxPrice){
		return service.priceBetween(minPrice, maxPrice);
	}
	@GetMapping("/GenreAndPriceLessThan")
	public List<Book> GenreAndPriceLessThan(String genre,Double price){
		return service.genreAndPriceLessThan(genre, price);
	}
	@GetMapping("/OrderPublishDateDesc")
	public List<Book> OrderPublishDateDesc(){
		return service.orderByPublishedDateDesc();
	}
	@GetMapping("/OrderPriceAsc")
	public List<Book> OrderPriceAsc(){
		return service.orderByPriceAsc();
	}
	@GetMapping
	public List<Book> getAll(){
		return service.getAll();
	}
}
