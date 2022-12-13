package ru.golovan.service;

import ru.golovan.model.Book;

import java.util.List;

public interface BookService {
    List<Book> allBooks();

    Book getById(int id);

    Book getByTitle(String title);
}
