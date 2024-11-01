package com.progsp.server.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.progsp.server.model.Apartment;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ApartmentDAO {

	@PersistenceContext
	private final EntityManager session;

	public List<Apartment> fetchByMinMaxCost(Integer min, Integer max) {
		return session.createQuery("FROM Apartment WHERE price BETWEEN :min AND :max", Apartment.class)
				.setParameter("min", min).setParameter("max", max).getResultList();
	}
}
