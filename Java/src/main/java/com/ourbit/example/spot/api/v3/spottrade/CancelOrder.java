package com.ourbit.example.spot.api.v3.spottrade;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import com.ourbit.example.common.JsonUtil;
import com.ourbit.example.common.UserDataClient;
import com.ourbit.example.spot.api.v3.pojo.OrderCancelResp;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

@Slf4j
public class CancelOrder {
    public static OrderCancelResp cancelOrder(Map<String, String> params) {
        return UserDataClient.delete("/api/v3/order", params, new TypeReference<OrderCancelResp>() {
        });
    }

    public static void main(String[] args) {
        //cancel order
        OrderCancelResp cancelResp = cancelOrder(Maps.newHashMap(ImmutableMap.<String, String>builder()
                .put("symbol", "BTCUSDT")
                .put("orderId", "150751023827259392")
                .put("recvWindow", "60000")
                .build()));
        log.info("==>>cancelResp:{}", JsonUtil.toJson(cancelResp));
    }
}
