package com.springrest.springrest.constants;

import org.springframework.stereotype.Component;

@Component
public class AppConstant {
    private int defaultCount = 5;

    public int getDefaultCount() {
        return defaultCount;
    }

    public void setDefaultCount(int defaultCount) {
        this.defaultCount = defaultCount;
    }
}
