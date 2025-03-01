//package com.example.bookApplication1.Controller;
//
//import com.example.bookApplication1.Entity.Book;
//import com.example.bookApplication1.Service.BookService;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//
//import java.util.Arrays;
//import java.util.List;
//
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.when;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//
//public class BookControllerTest {
//
//    private MockMvc mockMvc;
//
//    @Mock
//    private BookService bookService;
//
//    @InjectMocks
//    private BookController bookController;
//
//    @BeforeEach
//    public void setUp() {
//        MockitoAnnotations.openMocks(this);
//        mockMvc = MockMvcBuilders.standaloneSetup(bookController).build();
//    }
//
//    private String asJsonString(final Object obj) {
//        try {
//            return new ObjectMapper().writeValueAsString(obj);
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    @Test
//    public void testAddBook() throws Exception {
//        Book book = new Book();
//        book.setId(1);
//        book.setTitle("Harry Potter");
//        book.setAuthor("J.K. Rowling");
//        book.setGenre("Fantasy");
//
//        when(bookService.addBook(any(Book.class))).thenReturn(book);
//
//        mockMvc.perform(post("/api/books/addBook")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(asJsonString(book)))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.id").value(1))
//                .andExpect(jsonPath("$.title").value("Harry Potter"))
//                .andExpect(jsonPath("$.author").value("J.K. Rowling"))
//                .andExpect(jsonPath("$.genre").value("Fantasy"));
//    }
//
//    @Test
//    public void testGetBookById() throws Exception {
//        Book book = new Book();
//        book.setId(1);
//        book.setTitle("Harry Potter");
//        book.setAuthor("J.K. Rowling");
//        book.setGenre("Fantasy");
//
//        when(bookService.getBookById(1)).thenReturn(book);
//
//        mockMvc.perform(get("/api/books/getBook/1"))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.id").value(1))
//                .andExpect(jsonPath("$.title").value("Harry Potter"))
//                .andExpect(jsonPath("$.author").value("J.K. Rowling"))
//                .andExpect(jsonPath("$.genre").value("Fantasy"));
//    }
//
//    @Test
//    public void testGetAllBooks() throws Exception {
//        Book book1 = new Book();
//        book1.setId(1);
//        book1.setTitle("Harry Potter");
//        book1.setAuthor("J.K. Rowling");
//        book1.setGenre("Fantasy");
//
//        Book book2 = new Book();
//        book2.setId(2);
//        book2.setTitle("Lord of the Rings");
//        book2.setAuthor("J.R.R. Tolkien");
//        book2.setGenre("Fantasy");
//
//        List<Book> books = Arrays.asList(book1, book2);
//
//        when(bookService.getAllBooks()).thenReturn(books);
//
//        mockMvc.perform(get("/api/books"))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$[0].id").value(1))
//                .andExpect(jsonPath("$[0].title").value("Harry Potter"))
//                .andExpect(jsonPath("$[1].id").value(2))
//                .andExpect(jsonPath("$[1].title").value("Lord of the Rings"));
//    }
//
//    @Test
//    public void testUpdateBook() throws Exception {
//        Book book = new Book();
//        book.setId(1);
//        book.setTitle("Harry Potter");
//        book.setAuthor("J.K. Rowling");
//        book.setGenre("Fantasy");
//
//        when(bookService.updateBook(any(Book.class))).thenReturn(book);
//
//        mockMvc.perform(put("/api/books/updateBook")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(asJsonString(book)))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.id").value(1))
//                .andExpect(jsonPath("$.title").value("Harry Potter"))
//                .andExpect(jsonPath("$.author").value("J.K. Rowling"))
//                .andExpect(jsonPath("$.genre").value("Fantasy"));
//    }
//
//    @Test
//    public void testDeleteBook() throws Exception {
//        int bookId = 1;
//
//        mockMvc.perform(delete("/api/books/deleteBook/1"))
//                .andExpect(status().isOk());
//    }
//}
