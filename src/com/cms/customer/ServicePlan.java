package com.cms.customer;

public enum ServicePlan {
    SILVER(1000),GOLD(2000),DIAMOND(5000),PLATINUM(10000);

    private int charges;

    ServicePlan(int charges){
        this.charges = charges;
    }
}
