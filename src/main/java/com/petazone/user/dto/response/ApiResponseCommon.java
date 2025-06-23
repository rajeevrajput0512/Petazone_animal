package com.petazone.user.dto.response;

public class ApiResponseCommon<T> {
    private Boolean flag;

    private T data;

    private String msg;


    public ApiResponseCommon(Boolean flg, T data, String msg) {
        this.flag = flg;
        this.data = data;
        this.msg = msg;
    }


    public Boolean getFlag() {
        return flag;
    }

    public void setFlag(Boolean flag) {
        this.flag = flag;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }


}
