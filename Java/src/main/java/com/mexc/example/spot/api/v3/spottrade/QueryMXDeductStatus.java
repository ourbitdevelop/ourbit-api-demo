package com.ourbit.example.spot.api.v3.spottrade;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import com.ourbit.example.common.JsonUtil;
import com.ourbit.example.common.UserDataClient;
import com.ourbit.example.spot.api.v3.pojo.ObDeductResp;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

@Slf4j
public class QueryOBDeductStatus {
    public static ObDeductResp getObDeductStatus(Map<String, String> params) {
        return UserDataClient.get("/api/v3/obDeduct/enable", params, new TypeReference<ObDeductResp>() {
        });
    }

    public static void main(String[] args) {
        //get ob deduct status
        ObDeductResp obDeductStatus = getObDeductStatus(Maps.newHashMap(ImmutableMap.<String, String>builder()
                .put("recvWindow", "60000")
                .build()));
        log.info("==>>obDeductStatus:{}", JsonUtil.toJson(obDeductStatus));
    }
}
