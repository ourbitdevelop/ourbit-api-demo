package com.ourbit.example.spot.api.v3.wallet;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import com.ourbit.example.common.JsonUtil;
import com.ourbit.example.common.UserDataClient;
import com.ourbit.example.spot.api.v3.pojo.DepositHisRec;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Map;

@Slf4j
public class DepositHistory {
    public static List<DepositHisRec> getDepositHisRec(Map<String, String> params) {
        return UserDataClient.get("/api/v3/capital/deposit/hisrec", params, new TypeReference<List<DepositHisRec>>() {
        });
    }

    public static void main(String[] args) {
        //get deposit history record
        List<DepositHisRec> depositHisRec = getDepositHisRec(Maps.newHashMap(ImmutableMap.<String, String>builder()
                .put("coin", "USDT-TRX")
                .build()));
        log.info("==>>depositHisRec:{}", JsonUtil.toJson(depositHisRec));
    }
}
