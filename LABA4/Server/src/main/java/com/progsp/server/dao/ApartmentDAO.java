package com.progsp.server.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Component;

import com.progsp.server.model.Apartment;


//singleton
@Component ("apartmentDAO")
public class ApartmentDAO {
	Configuration conf = new Configuration().addAnnotatedClass(Apartment.class);
	// EntityManager
	private Session SessionBuilder()
	{
		SessionFactory sessionFactory = conf.buildSessionFactory(); //только 1 раз
		Session session = sessionFactory.getCurrentSession();
		return session;
	}
	
	public List<Apartment> fetchByMinMaxCost(Integer min, Integer max) {
		Session session = SessionBuilder();
		Transaction transaction = session.beginTransaction();
		List<Apartment> apartments = session.
				createQuery("FROM Apartment WHERE price BETWEEN :min AND :max", Apartment.class).
				setParameter("min", min).setParameter("max", max).
				getResultList();
		transaction.commit();
		return apartments;
	}
}
