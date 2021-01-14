package com.redislabs.springredisbootstrap;

public interface DataRepository {
    String ping();
    void loadData();
}