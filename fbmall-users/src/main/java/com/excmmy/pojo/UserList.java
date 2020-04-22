package com.excmmy.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserList implements Serializable {
    private Long id;
    private String series;
    private String username;
    private String userpass;
    private String nickname;
    private String realname;
    private String phone;
    private String address;
    private String email;
    private Integer status;
    private String value;
}
