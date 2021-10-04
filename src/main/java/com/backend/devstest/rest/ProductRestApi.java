package com.backend.devstest.rest;

import java.util.Set;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.devstest.dto.ProductDetailsDTO;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("product")
@AllArgsConstructor
public interface ProductRestApi {

	@GetMapping("/{productId}/similar")
	public ResponseEntity<Set<ProductDetailsDTO>> findSimilarProducts(@Valid @PathVariable String productId);
}
