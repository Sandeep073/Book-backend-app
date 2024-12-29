package com.example.bookApplication1.Service;

import java.util.stream.Collectors;
import com.example.bookApplication1.Entity.Book;
import com.example.bookApplication1.Repository.BookRepository;
import com.example.bookApplication1.exception.BookNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;

    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    public Book getBookById(Integer id) {
        Optional<Book> book = bookRepository.findById(id);
        return book.orElseThrow(() -> new BookNotFoundException("Book with id " + id + " not found"));
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll().stream()
                .filter(book -> book.getTitle() != null)
                .collect(Collectors.toList());
    }

    public Book updateBook(Book book) {
        return bookRepository.save(book);
    }

    public ResponseEntity<String> deleteBook(Integer id) {
        if (!bookRepository.existsById(id)) {
            throw new BookNotFoundException("Book with id " + id + " not found");
        }
        bookRepository.deleteById(id);
        return ResponseEntity.ok("Book successfully deleted");
    }
}
