package com.example.demo.domain;

import java.util.UUID;
import lombok.Builder;
import lombok.Value;

@Value
@Builder(toBuilder = true)
public class Card {
    UUID cardId;
    String cardNumber;
    String expirationDate;
    Integer cvv;
    UUID customerId;
    UUID orderId;
}