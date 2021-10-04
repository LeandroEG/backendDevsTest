package com.backend.devstest.dto;

import java.math.BigDecimal;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
public class ProductDetailsDTO {

	@NotBlank
	@Min(1)
	@Schema(description = "product id")
	private String id;

	@NotBlank
	@Schema(description = "product name")
	private String name;

	@NotBlank
	@Schema(description = "product price")
	private BigDecimal price;

	@NotBlank
	@Schema(description = "product availability")
	private boolean availability;

}
