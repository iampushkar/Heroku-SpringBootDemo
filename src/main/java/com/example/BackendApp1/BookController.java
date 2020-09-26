package com.example.BackendApp1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BookController {

    @Autowired
    BookRepository repository;
    //  BookRepository repository = new BookRepository();

    @GetMapping("/books")
    public List<Book> getAllBooks() {
        return repository.findAll();
    }

    @GetMapping("/books/{id}")
    public Book getABook(@PathVariable int id) {
        Optional<Book> object = repository.findById(id);
        if (object.isPresent()) {
            return object.get();
        }
        System.out.println("Could not find the book");
        return null;
        /*
        Book book = repository.findById(id);
        print(book.getName()); */
    }

    @PostMapping("/books")
    public boolean createABook(@RequestBody Book book) {
        repository.save(book);
        return true;
    }

    @PutMapping("/books")
    public boolean updateABook(@RequestBody Book book){
        repository.save(book);
        return true;
    }

    @DeleteMapping("/books/{id}")
    public boolean deleteABook(@PathVariable int id) {
        repository.deleteById(id);
        return true;
    }

    @GetMapping("/booksSorted")
    public List<Book> getAllBooksInSortedOrder(){
        return  repository.findAll(Sort.by(Sort.Direction.ASC, "author"));
    }

    @GetMapping("/booksA/{author}")
    public List<Book> getAllBooksOfGivenAuthor(@PathVariable String author){
        List<Book> bookList1 = repository.findByAuthor(author);
        List<Book> bookList2 = repository.getBooksByAuthorName(author);
        if(bookList1.equals(bookList2)){
            System.out.println("They are same");
        }
        return bookList1;
    }

    @GetMapping("/searchBookByName/{bookName}")
    public List<Book> searchBookByName(@PathVariable String bookName) {
        return repository.findByBookName(bookName);
    }

}
