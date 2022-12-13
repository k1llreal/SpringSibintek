package ru.golovan.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.golovan.dao.BookDAO;
import ru.golovan.model.Book;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private BookDAO bookDAO;

    @Autowired
    public void setBookDAO(BookDAO bookDAO) {
        this.bookDAO = bookDAO;
    }

    @Override
    @Transactional
    public List<Book> allBooks() {
        return bookDAO.allBooks();
    }

    @Override
    @Transactional
    public Book getById(int id) {
        return bookDAO.getById(id);
    }

    @Override
    @Transactional
    public Book getByTitle(String title) {
        return bookDAO.getByTitle(title);
    }

}
