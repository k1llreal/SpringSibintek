package ru.golovan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ru.golovan.model.Author;
import ru.golovan.model.Book;
import ru.golovan.service.AuthorService;
import ru.golovan.service.BookService;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
public class MainController {

    private BookService bookService;
    private AuthorService authorService;

    @Autowired
    public void setBookService(BookService bookService) {
        this.bookService = bookService;
    }

    @Autowired
    public void setAuthorService(AuthorService authorService) {
        this.authorService = authorService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView allTasks() {
        Set<Author> authors = new HashSet<>(authorService.allAuthors());
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("mainpage");
        modelAndView.addObject("authorsList", authors);
        return modelAndView;
    }

    @RequestMapping(value = "/info", method = RequestMethod.GET)
    public ModelAndView allBooksAndAuthors() {
        List<Book> books = bookService.allBooks();
        List<Author> authors = authorService.allAuthors();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("info");
        modelAndView.addObject("booksList", books);
        modelAndView.addObject("authorsList", authors);
        return modelAndView;
    }

    @RequestMapping(value = "/getByName", method = RequestMethod.GET)
    public ModelAndView getAuthorByName(@RequestParam("name") String name) {
        Author author = authorService.getByName(name);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("getByName");
        modelAndView.addObject("author", author);
        return modelAndView;
    }

    @RequestMapping(value = "/getByTitle", method = RequestMethod.GET)
    public ModelAndView getBookByTitle(@RequestParam("title") String title) {
        Book book = bookService.getByTitle(title);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("getByTitle");
        modelAndView.addObject("book", book);
        return modelAndView;
    }

    @RequestMapping(value = "/getAuthorBooks", method = RequestMethod.GET)
    public ModelAndView getAuthorBooks(@RequestParam("name") String name,
                                       @RequestParam("surname") String surname) {
        List<Integer> booksId = authorService.getAuthorBooksIdByFullName(name, surname);
        List<Book> books = new ArrayList<>();
        for (int i = 0; i < booksId.size(); i++) {
            Book book = bookService.getById(booksId.get(i));
            books.add(book);
        }
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("getAuthorBooks");
        modelAndView.addObject("booksList", books);
        return modelAndView;
    }

    @RequestMapping(value = "/getByRange", method = RequestMethod.GET)
    public ModelAndView getAuthorByRange(@RequestParam("first") int first,
                                         @RequestParam("last") int last) {

        List<Author> authors = authorService.getAuthorsByRangeId(first, last);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("getByRangeId");
        modelAndView.addObject("authorsList", authors);
        return modelAndView;
    }
}
