package com.ourbit.example.spot.api.v3.subaccount;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import com.ourbit.example.common.JsonUtil;
import com.ourbit.example.common.UserDataClient;
import com.ourbit.example.spot.api.v3.pojo.SubAccount;
import com.ourbit.example.spot.api.v3.pojo.SubAccountApiKey;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

@Slf4j
public class CreateSubAccountApiKey {

    public static SubAccountApiKey createSubAccountApiKey(Map<String, String> params) {
        return UserDataClient.post("/api/v3/sub-account/apiKey", params, new TypeReference<SubAccountApiKey>() {
        });
    }

    public static void main(String[] args) {
        //create subAccount
        SubAccountApiKey subAccountApiKey = createSubAccountApiKey(Maps.newHashMap(ImmutableMap.<String, String>builder()
                .put("subAccount", "subAccount0421")
                .put("permissions", "SPOT_ACCOUNT_READ")
                .put("note", "note1")
                .put("ip", "127.0.0.1")
                .build()));

        log.info("==>>subAccountApiKey:{}", JsonUtil.toJson(subAccountApiKey));
    }
}
