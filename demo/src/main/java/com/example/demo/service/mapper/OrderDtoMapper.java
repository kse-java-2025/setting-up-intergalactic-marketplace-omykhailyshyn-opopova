package com.example.demo.service.mapper;

import com.example.demo.domain.Order;
import com.example.demo.dto.order.OrderDto;
import com.example.demo.dto.order.OrderEntryDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import java.util.List;
import java.util.UUID;

@Mapper(componentModel = "spring", uses = ProductDtoMapper.class, imports = {UUID.class})
public interface OrderDtoMapper {
    @Mapping(target = "orderId", expression = "java(UUID.randomUUID())")
    
    Order toOrder(OrderDto dto);

    OrderEntryDto toOrderEntryDto(Order order);

    List<OrderEntryDto> toOrderEntryDtoList(List<Order> orders);
}