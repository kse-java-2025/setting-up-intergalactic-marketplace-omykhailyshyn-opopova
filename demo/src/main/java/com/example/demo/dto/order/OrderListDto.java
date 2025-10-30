package com.example.demo.dto.order;

import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;
import java.util.List;

@Value
@Builder(toBuilder = true)
@Jacksonized
public class OrderListDto {
    int page;                 
    int size;                 
    int totalElements;       
    List<OrderEntryDto> orders;  
}
