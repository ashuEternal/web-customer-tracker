package com.luv2code.springdemo.dao;

import com.luv2code.springdemo.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class CustomerDAOImpl implements CustomerDAO {


    @Autowired
    private SessionFactory sessionFactory;



    @Override
    public List<Customer> getCustomers() {
        //get current Hibernate Session
        Session session = sessionFactory.getCurrentSession();
        //create query
        Query<Customer> query = session.createQuery("from Customer order by lastName",Customer.class);
        //execute query and get result  list
        List<Customer> customers = query.getResultList();
        //return the results
        return customers;
    }

    @Override
    public void saveCustomer(Customer customer) {
        Session session = sessionFactory.getCurrentSession();
        //save/update the customer
        session.saveOrUpdate(customer);
    }

    @Override
    public Customer getCustomer(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Customer.class,id);
    }

    @Override
    public void deleteCustomer(int id) {
        Session session = sessionFactory.getCurrentSession();

        session.remove(session.get(Customer.class,id));
    }
}
