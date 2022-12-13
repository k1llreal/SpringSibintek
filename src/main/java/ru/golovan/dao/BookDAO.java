package ru.golovan.dao;

import ru.golovan.model.Book;

import java.util.List;

public interface BookDAO {
    List<Book> allBooks();

    Book getById(int id);

    Book getByTitle(String title);
}
