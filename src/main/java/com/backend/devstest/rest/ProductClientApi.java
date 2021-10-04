package com.backend.devstest.rest;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.backend.devstest.dto.ProductDetailsDTO;

@FeignClient(value = "productclientservice", url = "http://localhost:3001")
public interface ProductClientApi {
	@RequestMapping(method = RequestMethod.GET, value = "/product/{productId}/similarids")
	List<Integer> getProductSimilarIds(@PathVariable("productId") String productId);

	@RequestMapping(method = RequestMethod.GET, value = "/product/{productId}", produces = "application/json")
	ProductDetailsDTO getProductDetailsById(@PathVariable("productId") String productId);
}
