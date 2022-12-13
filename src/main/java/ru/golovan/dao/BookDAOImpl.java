package ru.golovan.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.golovan.model.Book;

import java.util.List;

@Repository
public class BookDAOImpl implements BookDAO {
    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @Override
    public List<Book> allBooks() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Book").list();
    }


    @Override
    public Book getById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Book.class, id);
    }

    @Override
    public Book getByTitle(String title) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Book where title = :title");
        query.setParameter("title", title);
        return (Book) query.list().get(0);
    }
}
