package com.ourbit.example.spot.api.v3.wallet;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import com.ourbit.example.common.JsonUtil;
import com.ourbit.example.common.UserDataClient;
import com.ourbit.example.spot.api.v3.pojo.ConvertResp;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

@Slf4j
public class DustTransfer {
    public static ConvertResp convert(Map<String, String> params) {
        return UserDataClient.post("/api/v3/capital/convert", params, new TypeReference<ConvertResp>() {
        });
    }

    public static void main(String[] args) {
        //dust transfer
        ConvertResp convertResp = convert(Maps.newHashMap(ImmutableMap.<String, String>builder()
                .put("asset", "GPT")
                .build()));
        log.info("==>>convertResp:{}", JsonUtil.toJson(convertResp));
    }

}
