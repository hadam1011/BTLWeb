package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Orders;
import com.example.demo.repository.OrderRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Service
public class OrderService {
	@Autowired
	private OrderRepository orderRepo;
	
	@PersistenceContext
    private EntityManager entityManager;
	
	public List<Orders> getAll() {
		return orderRepo.findAll();
	}
	
	public List<Orders> getAllByUserid(int id) {
		String sql = "select s from Orders s where s.userid = :id";
		return entityManager.createQuery(sql, Orders.class)
				.setParameter("id", id)
				.getResultList();
	}
	
	public Orders create (Orders order) {
		return orderRepo.save(order);
	}
	
	public void delete (int id) {
		orderRepo.deleteById(id);
	}
	
	public List<Orders> getAllByBookid(int id){
		return orderRepo.findByBookid(id);
	}
}
