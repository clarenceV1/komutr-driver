package com.komutr.driver.dao;

import com.komutr.driver.base.App;
import com.komutr.driver.been.MyObjectBox;

import io.objectbox.BoxStore;

public class BaseDAO {
    public BoxStore boxStore;

    public BaseDAO() {
        this.boxStore = App.getBoxStore();
    }
}
