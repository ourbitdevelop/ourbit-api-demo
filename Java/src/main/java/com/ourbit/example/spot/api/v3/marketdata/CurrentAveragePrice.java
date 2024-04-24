package com.ourbit.example.spot.api.v3.marketdata;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import com.ourbit.example.common.JsonUtil;
import com.ourbit.example.common.MarketDataClient;
import com.ourbit.example.spot.api.v3.pojo.AvgPrice;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;
@Slf4j
public class CurrentAveragePrice {
    public static AvgPrice avgPrice(Map<String, String> params) {
        return MarketDataClient.get("/api/v3/avgPrice", params, new TypeReference<AvgPrice>() {
        });
    }

    public static void main(String[] args) {
        HashMap<String, String> symbolParams = Maps.newHashMap(ImmutableMap.<String, String>builder()
                .put("symbol", "BTCUSDT")
                .build());
        //current average price
        log.info("=>>avgPrice:{}", JsonUtil.toJson(avgPrice(symbolParams)));
    }
}
