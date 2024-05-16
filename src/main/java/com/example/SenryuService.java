package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SenryuService {
	@Autowired
	private final SenryuRepository senryuRepository;

	public SenryuService(SenryuRepository senryuRepository) {
		this.senryuRepository = senryuRepository;
	}
	
	public void saveSenryu(String content) {
		Senryu senryu = new Senryu(content);
		senryuRepository.save(senryu);
	}
	public void deleteSenryu(Long id) {
        senryuRepository.deleteById(id);
    }
	public void updateSenryu(Senryu senryu) {
        senryuRepository.save(senryu);
    }
	public java.util.List<Senryu> findSenryuByContentContaining(String content) {
        return senryuRepository.findByContentContaining(content);
    }
}