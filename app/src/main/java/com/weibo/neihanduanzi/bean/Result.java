package com.weibo.neihanduanzi.bean;

/**
 * Created by Administrator on 2017/12/12.
 */

public class Result<T> {

    /**
    *  "message": "success",
    *  "data": []
    */

    private String message;
    private T[] data;

    public Result() {
    }

    public Result(String message, T[] data) {
        this.message = message;
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T[] getData() {
        return data;
    }

    public void setData(T[] data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Result{" +
                "message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
