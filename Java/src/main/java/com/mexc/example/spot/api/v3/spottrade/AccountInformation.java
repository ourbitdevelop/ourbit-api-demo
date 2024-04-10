package com.ourbit.example.spot.api.v3.spottrade;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import com.ourbit.example.common.JsonUtil;
import com.ourbit.example.common.UserDataClient;
import com.ourbit.example.spot.api.v3.pojo.Account;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

@Slf4j
public class AccountInformation {
    public static Account account(Map<String, String> params) {
        return UserDataClient.get("/api/v3/account", params, new TypeReference<Account>() {
        });
    }

    public static void main(String[] args) {
        //get account
        Account account = account(Maps.newHashMap(ImmutableMap.<String, String>builder()
                .put("recvWindow", "60000")
                .build()));
        log.info("==>>account:{}", JsonUtil.toJson(account));
    }
}
