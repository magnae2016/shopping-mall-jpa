package com.shop.constant;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ItemSellStatus {
    SELL("판매 중"), SOLD_OUT("재고 없음");

    private final String description;
}
