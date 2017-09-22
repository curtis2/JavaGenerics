package com.simon.javagenerics.generics;

/**
 * auther: Simon zhang
 * Emaill:18292967668@163.com
 */

public class A extends Apple<String> {
    @Override
    public void setInfo(String info) {
        super.setInfo(info);
    }

    @Override
    public String getInfo() {
        return super.getInfo();
    }
}
