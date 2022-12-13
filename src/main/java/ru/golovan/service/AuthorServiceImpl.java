package ru.golovan.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.golovan.dao.AuthorDAO;
import ru.golovan.model.Author;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {
    private AuthorDAO authorDAO;

    @Autowired
    public void setAuthorDAO(AuthorDAO authorDAO) {
        this.authorDAO = authorDAO;
    }


    @Override
    @Transactional
    public List<Author> allAuthors() {
        return authorDAO.allAuthors();
    }

    @Override
    @Transactional
    public Author getById(int id) {
        return authorDAO.getById(id);
    }

    @Override
    @Transactional
    public Author getByName(String name) {
        return authorDAO.getByName(name);
    }

    @Override
    @Transactional
    public List<Integer> getAuthorBooksIdByFullName(String name, String surname) {
        return authorDAO.getAuthorBooksIdByFullName(name, surname);
    }

    @Override
    @Transactional
    public List<Author> getAuthorsByRangeId(int first, int last) {
        return authorDAO.getAuthorsByRangeId(first, last);
    }


}
