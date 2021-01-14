package com.redislabs.springredisbootstrap;

public interface DataRepository {
    String ping();
    String loadData();
    String setData(String data);
}