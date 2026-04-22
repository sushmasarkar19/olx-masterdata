package com.sushma.olxmasterdata.service;

import java.util.List;

import com.sushma.olxmasterdata.dto.AdvertiseStatusResponse;
import com.sushma.olxmasterdata.dto.CategoryDto;

public interface MasterdataService {
    List<CategoryDto> getAllCategories();
    List<AdvertiseStatusResponse> getAllStatuses();
}
