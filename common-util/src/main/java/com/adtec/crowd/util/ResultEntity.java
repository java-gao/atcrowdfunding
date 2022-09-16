package com.adtec.crowd.util;

public class ResultEntity<T> {

    public static final String SUCCESS="SUCCESS";
    public static final String FAILED="FAILED";

    //用来封装当前请求的处理结果
    private String result;
    //返回的数据
    private T data;
    //返回结果的信息
    private String message;

    public  ResultEntity() {
    }

    public ResultEntity(String result, T data, String message) {
        this.result = result;
        this.data = data;
        this.message = message;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
    //请求成功但是不返回数据
    public static <E> ResultEntity<E> successWithoutData(){
        return new ResultEntity<E>(SUCCESS,null,null);
    }

    //请求成功但是返回数据
    public static <E> ResultEntity<E> successWithData(E data){
        return new ResultEntity<E>(SUCCESS,data,null);
    }

    //请求失败
    public static <E> ResultEntity<E> failed(String message){
        return new ResultEntity<E>(FAILED,null,message);
    }
}
