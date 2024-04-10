package com.ourbit.example.spot.api.v3.spottrade;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import com.ourbit.example.common.JsonUtil;
import com.ourbit.example.common.UserDataClient;
import com.ourbit.example.spot.api.v3.pojo.MyTrades;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Map;

@Slf4j
public class AccountTradeList {
    public static List<MyTrades> myTrades(Map<String, String> params) {
        return UserDataClient.get("/api/v3/myTrades", params, new TypeReference<List<MyTrades>>() {
        });
    }

    public static void main(String[] args) {
        //get my trades
        List<MyTrades> myTrades = myTrades(Maps.newHashMap(ImmutableMap.<String, String>builder()
                .put("symbol", "OBUSDT")
                .build()));
        log.info("==>>myTrades:{}", JsonUtil.toJson(myTrades));
    }
}
