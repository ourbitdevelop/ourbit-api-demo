package com.ourbit.example.spot.api.v3.spottrade;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.collect.ImmutableMap;
import com.ourbit.example.common.JsonUtil;
import com.ourbit.example.common.UserDataClient;

import java.util.Map;

public class BatchOrders {
    public static Object placeBatchOrder(Map<String, String> params) {
        return UserDataClient.postEmptyBody("/api/v3/batchOrders", params, new TypeReference<Object>() {
        });
    }

    public static void main(String[] args) {
        //  place BatchOrder
        Object o = placeBatchOrder(ImmutableMap.<String, String>builder()
                .put("batchOrders", "[{\"type\": \"LIMIT\",\"price\": \"0.5\",\"quantity\": \"20\",\"symbol\": \"BTCUSDT\",\"side\": \"BUY\",\"newClientOrderId\": 388744},{\"type\": \"LIMIT\",\"price\": \"0.5\",\"quantity\": \"20\",\"symbol\": \"BTCUSDT\",\"side\": \"BUY\",\"newClientOrderId\": 457984375843}]")
                .put("recvWindow", "60000")
                .build());
        System.out.println(JsonUtil.toJson(o));
    }
}
