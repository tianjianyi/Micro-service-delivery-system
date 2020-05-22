package com.yifeng.domain;

import java.util.List;

public class MenuVo {
    private int code;
    private String msg;
    private int count;
    private List<Menu> data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<Menu> getData() {
        return data;
    }

    public void setData(List<Menu> data) {
        this.data = data;
    }

    public MenuVo(int code, String msg, int count, List<Menu> data) {
        this.code = code;
        this.msg = msg;
        this.count = count;
        this.data = data;
    }

    public MenuVo() {
    }
}
