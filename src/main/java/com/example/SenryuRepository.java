package com.example;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SenryuRepository extends JpaRepository<Senryu, Long> {
	public Senryu findById(int id);
	java.util.List<Senryu> findByContentContaining(String substring);
}
