package com.ourbit.example.spot.api.v3.pojo;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;


@Setter
@Getter
public class ObDeductResp {
    private Map<String, Boolean> data;
    private int code;
    private long timestamp;
    private String msg;
}
