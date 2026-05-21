package com.sushma.olxmasterdata.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sushma.olxmasterdata.dto.AdvertiseStatusResponse;
import com.sushma.olxmasterdata.dto.CategoryDto;
import com.sushma.olxmasterdata.dto.CategoryResponse;
import com.sushma.olxmasterdata.dto.StatusListResponse;
import com.sushma.olxmasterdata.service.MasterdataService;

import lombok.extern.log4j.Log4j2;


@RestController
@RequestMapping("/advertise")
@Log4j2
public class MasterdataController {

    @Autowired
    private MasterdataService masterdataService;

    /**
     * Endpoint 6: GET /advertise/category
     * Returns all advertisement categories.
     * No authentication required.
     */
    @GetMapping("/category")
    public ResponseEntity<CategoryResponse> getAllCategories() {
        List<CategoryDto> categories = masterdataService.getAllCategories();
        log.info("categories"+categories);
        CategoryResponse categoryResponse = new CategoryResponse(categories);      
        return ResponseEntity.status(HttpStatus.OK).body(categoryResponse);
    }

    /**
     * Endpoint 7: GET /advertise/status
     * Returns all possible advertise statuses.
     * No authentication required.
     */
    @GetMapping("/status")
    public ResponseEntity<StatusListResponse> getAllStatuses() {
        List<AdvertiseStatusResponse> statusList = masterdataService.getAllStatuses();
        StatusListResponse response = new StatusListResponse(statusList);
//        Map<String, Object> response = new HashMap<>();
//        response.put("statusList", statusList);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
