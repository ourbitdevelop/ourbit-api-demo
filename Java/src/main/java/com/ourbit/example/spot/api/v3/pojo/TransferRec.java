package com.ourbit.example.spot.api.v3.pojo;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class TransferRec {
    private List<TransferRows> rows;
    private Integer total;
}
