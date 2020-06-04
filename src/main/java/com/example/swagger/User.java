package com.example.swagger;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "user class", description = "user info description")
public class User {
    @ApiModelProperty(value = "username")
    private String username;
    @ApiModelProperty(value = "address")
    private String address;

    public String toString() {
        return "User:{username:" +
                username +
                ", address:" +
                "}";
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


}
