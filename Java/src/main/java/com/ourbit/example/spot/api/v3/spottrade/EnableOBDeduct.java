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
public class EnableOBDeduct {
    public static ObDeductResp obDeduct(Map<String, String> params) {
        return UserDataClient.post("/api/v3/obDeduct/enable", params, new TypeReference<ObDeductResp>() {
        });
    }

    public static void main(String[] args) {
        //update ob deduct
        ObDeductResp obDeductResp = obDeduct(Maps.newHashMap(ImmutableMap.<String, String>builder()
                .put("obDeductEnable", "true")
                .build()));
        log.info("==>>obDeductResp:{}", JsonUtil.toJson(obDeductResp));
    }
}
