package com.example.demo.service.mapper;

import com.example.demo.domain.Cart;
import com.example.demo.dto.cart.CartDto;
import com.example.demo.dto.cart.CartEntryDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import java.util.List;
import java.util.UUID;

@Mapper(componentModel = "spring", uses = ProductDtoMapper.class, imports = UUID.class)
public interface CartDtoMapper {
    @Mapping(target = "cartId", expression = "java(UUID.randomUUID())")
    @Mapping(target = "totalPrice", ignore = true)
    Cart toCart(CartDto dto);

    CartEntryDto toCartEntryDto(Cart cart);

    List<CartEntryDto> toCartEntryDtoList(List<Cart> carts);
}