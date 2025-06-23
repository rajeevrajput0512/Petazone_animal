package com.petazone.user.dto.response;


public class CommonMasterDTO {
    private Integer id;
    private String value;
    private String key;

    public Integer getId() {
        return id;
    }


    public void setKey(String key) {
        this.key = key;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    @Override
    public String toString() {
        return "Person{id=" + this.id + ", name='" + this.value + "'}";
    }
}
