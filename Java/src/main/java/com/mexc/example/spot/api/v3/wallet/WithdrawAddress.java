package com.ourbit.example.spot.api.v3.wallet;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import com.ourbit.example.common.JsonUtil;
import com.ourbit.example.common.UserDataClient;
import com.ourbit.example.spot.api.v3.pojo.WithdrawAddressResp;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

@Slf4j
public class WithdrawAddress {
    public static WithdrawAddressResp getWithdrawAddress(Map<String, String> params) {
        return UserDataClient.get("/api/v3/capital/withdraw/address", params, new TypeReference<WithdrawAddressResp>() {
        });
    }

    public static void main(String[] args) {
        //get withdraw address
        WithdrawAddressResp withdrawAddress = getWithdrawAddress(Maps.newHashMap(ImmutableMap.<String, String>builder()
                .put("coin", "USDT")
                .build()));
        log.info("==>>withdrawAddress:{}", JsonUtil.toJson(withdrawAddress));
    }
}
