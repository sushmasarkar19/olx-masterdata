package com.sushma.olxmasterdata.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sushma.olxmasterdata.dto.AdvertiseStatusResponse;
import com.sushma.olxmasterdata.dto.CategoryDto;
import com.sushma.olxmasterdata.repository.AdvertiseStatusRepository;
import com.sushma.olxmasterdata.repository.CategoryRepository;
import com.sushma.olxmasterdata.service.MasterdataService;

@Service
public class MasterdataServiceImpl implements MasterdataService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private AdvertiseStatusRepository advertiseStatusRepository;

    @Override
    public List<CategoryDto> getAllCategories() {
        return categoryRepository.findAll()
                .stream()
                .map(cat -> new CategoryDto(cat.getId(), cat.getName()))
                .collect(Collectors.toList());
    }

    @Override
    public List<AdvertiseStatusResponse> getAllStatuses() {
        return advertiseStatusRepository.findAll()
                .stream()
                .map(s -> new AdvertiseStatusResponse(s.getId(), s.getStatus()))
                .collect(Collectors.toList());
    }
}
