package com.ourbit.example.spot.api.v3.spottrade;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import com.ourbit.example.common.JsonUtil;
import com.ourbit.example.common.UserDataClient;
import com.ourbit.example.spot.api.v3.pojo.Order;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

@Slf4j
public class QueryOrder {
    public static Order getOrder(Map<String, String> params) {
        return UserDataClient.get("/api/v3/order", params, new TypeReference<Order>() {
        });
    }

    public static void main(String[] args) {
        //get order
        Order order = getOrder(Maps.newHashMap(ImmutableMap.<String, String>builder()
                .put("symbol", "BTCUSDT")
                .put("orderId", "150751023827259392")
                .put("recvWindow", "60000")
                .build()));
        log.info("==>>order:{}", JsonUtil.toJson(order));
    }
}
