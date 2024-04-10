package com.ourbit.example.spot.api.v3.marketdata;

import com.fasterxml.jackson.core.type.TypeReference;
import com.ourbit.example.common.JsonUtil;
import com.ourbit.example.common.MarketDataClient;
import com.ourbit.example.spot.api.v3.pojo.Symbols;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;
@Slf4j
public class ApiDefaultSymbol {
    public static Symbols defaultSymbols(Map<String, String> params) {
        return MarketDataClient.get("/api/v3/defaultSymbols", params, new TypeReference<Symbols>() {
        });
    }

    public static void main(String[] args) {
        //api default symbols
        log.info("=>>defaultSymbols:{}", JsonUtil.toJson(defaultSymbols(new HashMap<>())));
    }
}
