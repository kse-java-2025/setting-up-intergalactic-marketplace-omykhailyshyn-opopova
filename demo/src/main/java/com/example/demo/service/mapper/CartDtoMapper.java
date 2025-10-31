package com.example.demo.service.mapper;
import com.example.demo.domain.Cart;
import com.example.demo.dto.cart.CartDto;
import com.example.demo.dto.cart.CartEntryDto;
import java.util.UUID;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import java.util.List;

@Mapper(componentModel = "spring")
public interface CartDtoMapper {
    @Mapping(target = "cartId", expression = "java(UUID.randomUUID())")
    Cart toCart(CartDto cartDto);

    CartEntryDto toCartEntryDto(Cart cart);

    default List<CartEntryDto> toCartEntryDtoList(List<Cart> carts) {
        return carts.stream()
                .map(this::toCartEntryDto)
                .toList();
    }
}