package com.sushma.olxmasterdata.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StatusListResponse {
	
	private List<AdvertiseStatusResponse> statusList;

}
