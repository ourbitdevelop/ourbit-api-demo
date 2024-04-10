package com.ourbit.example.spot.api.v3.subaccount;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import com.ourbit.example.common.JsonUtil;
import com.ourbit.example.common.UserDataClient;
import com.ourbit.example.spot.api.v3.pojo.SubAccountApiKey;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

@Slf4j
public class DelSubAccountApiKey {

    public static SubAccountApiKey deleteSubAccountApiKey(Map<String, String> params) {
        return UserDataClient.delete("/api/v3/sub-account/apiKey", params, new TypeReference<SubAccountApiKey>() {
        });
    }

    public static void main(String[] args) {
        //delete subAccount apiKey
        SubAccountApiKey delSubAccountApiKey = deleteSubAccountApiKey(Maps.newHashMap(ImmutableMap.<String, String>builder()
                .put("subAccount", "subAccount0421")
                .put("apiKey", "apiKey")
                .build()));
        log.info("==>>delSubAccountApiKey:{}", JsonUtil.toJson(delSubAccountApiKey));
    }
}
