package com.cskaoyan.mall.admin.bean;


public class PermissionApi {
    String api;
    String id;
    String label;
    String mothed;

    public String getMothed() {
        return mothed;
    }

    public void setMothed(String mothed) {
        this.mothed = mothed;
    }

    public String getApi() {
        return api;
    }

    public void setApi(String api) {
        this.api = mothed+api;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
