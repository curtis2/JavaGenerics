package com.simon.javagenerics.generics;

/**
 * auther: Simon zhang
 * Emaill:18292967668@163.com
 */
public class Apple<T> {
    public T info;

    public Apple(){
    }

    public void setInfo(T info) {
        this.info = info;
    }

    public T getInfo(){
        return info;
    }

}
