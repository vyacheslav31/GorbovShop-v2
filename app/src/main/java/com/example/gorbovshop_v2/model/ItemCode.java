package com.example.gorbovshop_v2.model;

public enum ItemCode {
    PADTHAI, SALTPPRCHKN, AVCADOSLD, TMPURASHRMP, SUSHIPLAT, BEEFDUMPLINGS, CHKNTACOS, BEEFSTRGNOFF,
    POUTINE, BEEFCURRY;

    private final int BASE_VALUE = 32240000;
    private int completeValue;

    ItemCode() {
        completeValue = BASE_VALUE + this.ordinal();
    }

    int getCode() {
        return completeValue;
    }


}
