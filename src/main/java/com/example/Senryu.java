package com.example;

import org.springframework.validation.annotation.Validated;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity
@Validated
@Data
class Senryu {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long id;
	
	@Column(length = 30)
	@NotBlank(message = "Content must not be blank")
	public String content;
	
	public Senryu() {}
	public Senryu(String content) {
		this.content = content;
	}
}
