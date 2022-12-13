package ru.golovan.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.golovan.model.Author;
import ru.golovan.model.BookAuthor;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AuthorDAOImpl implements AuthorDAO {
    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Author> allAuthors() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Author").list();
    }

    @Override
    public Author getById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Author.class, id);
    }

    @Override
    public Author getByName(String name) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Author where name = :name");
        query.setParameter("name", name);
        return (Author) query.list().get(0);
    }

    @Override
    public List<Integer> getAuthorBooksIdByFullName(String name, String surname) {
        List<Integer> booksId = new ArrayList<>();
        Session session = sessionFactory.getCurrentSession();
        Query query1 = session.createQuery("from Author as aut " +
                "where aut.name = :name " +
                "and aut.surname = :surname");
        query1.setParameter("name", name);
        query1.setParameter("surname", surname);
        Author author = (Author) query1.getResultList().get(0);
        Query query2 = session.createQuery("from BookAuthor as bkaut " +
                "where bkaut.authorId = :authorId");
        query2.setParameter("authorId", author.getId());

        for (int i = 0; i < query2.getResultList().size(); i++) {
            BookAuthor bkAuth = (BookAuthor) query2.getResultList().get(i);
            booksId.add(bkAuth.getBookId());
        }
        return booksId;
    }

    @Override
    public List<Author> getAuthorsByRangeId(int first, int last) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Author as aut where aut.id between :first and :last");
        query.setParameter("first", first);
        query.setParameter("last", last);
        return query.getResultList();
    }
}
