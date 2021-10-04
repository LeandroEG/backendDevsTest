package com.backend.devstest.controller;

import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.backend.devstest.dto.ProductDetailsDTO;
import com.backend.devstest.rest.ProductClientApi;
import com.backend.devstest.rest.ProductRestApi;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@Tag(name = "Product Similar Rest Api", description = "Product Similar Rest Api functions")
public class ProductSimilarController implements ProductRestApi {

	@Autowired
	private ProductClientApi productClientApi;

	@Operation(summary = "List of similar products to a given one ordered by similarity", responses = {
			@ApiResponse(responseCode = "200", description = "The service has been able to find products", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ProductDetailsDTO.class))),
			@ApiResponse(responseCode = "404", description = "Not Found"),
			@ApiResponse(responseCode = "500", description = "Internal Server Error") })
	@Override
	public ResponseEntity<Set<ProductDetailsDTO>> findSimilarProducts(@Valid @PathVariable String productId) {

		Set<ProductDetailsDTO> similarProducts = this.productClientApi.getProductSimilarIds(productId).stream()
				.map(product -> this.productClientApi.getProductDetailsById(product.toString()))
				.collect(Collectors.toSet());

		return ResponseEntity.ok(similarProducts);
	}
}
