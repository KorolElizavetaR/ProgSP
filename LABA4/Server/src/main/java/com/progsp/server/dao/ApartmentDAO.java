package com.progsp.server.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.progsp.server.model.Apartment;

//singleton
public class ApartmentDAO {
	Session session = null;
	
	public ApartmentDAO() {
		Configuration conf = new Configuration().addAnnotatedClass(Apartment.class);
		SessionFactory sessionFactory = conf.buildSessionFactory();
		session = sessionFactory.getCurrentSession();
	}
	
	public List<Apartment> fetchByMinMaxCost(Integer min, Integer max) {
		session.beginTransaction();
		List<Apartment> apartments = session.
				createQuery("FROM Apartment WHERE price BETWEEN :min AND :max", Apartment.class).
				setParameter("min", min).setParameter("max", max).
				getResultList();
		session.getTransaction().commit();
		return apartments;
	}
}
