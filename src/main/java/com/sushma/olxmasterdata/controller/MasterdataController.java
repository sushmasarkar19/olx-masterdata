package com.sushma.olxmasterdata.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sushma.olxmasterdata.dto.CategoryDto;
import com.sushma.olxmasterdata.dto.StatusDto;

@RestController
@RequestMapping("/advertise")
public class MasterdataController {
	
	@GetMapping("/category")
	public ResponseEntity<List<CategoryDto>> fetchAdvertisementCategories(){
		List<CategoryDto> categoryDtosList = List.of(
				new CategoryDto(1, "Real Estate"),
				new CategoryDto(2, "Furniture"),
				new CategoryDto(3, "Electronic goods")
				);
		
		return new ResponseEntity<List<CategoryDto>>(categoryDtosList,HttpStatus.OK);
	}
	
	@GetMapping("/status")
	public ResponseEntity<List<StatusDto>> fetchAdvertisementStatus(){
		List<StatusDto> statusDtosList = List.of(
				new StatusDto(1, "OPEN"),
				new StatusDto(2, "OPEN"),
				new StatusDto(3, "CLOSED")
				);
		
		return new ResponseEntity<List<StatusDto>>(statusDtosList,HttpStatus.OK);
	}
	

}
