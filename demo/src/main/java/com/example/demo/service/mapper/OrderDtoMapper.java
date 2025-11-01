package com.example.demo.service.mapper;

import com.example.demo.domain.Order;
import com.example.demo.dto.order.OrderDto;
import com.example.demo.dto.order.OrderEntryDto;
import java.util.UUID;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import java.util.List;

@Mapper(componentModel = "spring", imports = {UUID.class})
public interface OrderDtoMapper {
    @Mapping(target = "orderId", expression = "java(UUID.randomUUID())")
    Order toOrder(OrderDto orderDto);

    OrderEntryDto toOrderEntryDto(Order order); // correct??

    default List<OrderEntryDto> toOrderEntryDtoList(List<Order> orders) { // correct??
        return orders.stream()
                .map(this::toOrderEntryDto)
                .toList();
    }
}