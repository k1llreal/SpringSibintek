package ru.golovan.service;

import ru.golovan.model.Author;

import java.util.List;

public interface AuthorService {
    List<Author> allAuthors();

    Author getById(int id);

    Author getByName(String name);

    List<Integer> getAuthorBooksIdByFullName(String name, String surname);

    List<Author> getAuthorsByRangeId(int first, int last);
}
