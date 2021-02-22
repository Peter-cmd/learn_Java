package org.study.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
import java.util.List;

@Setter
@Getter
@ToString
public class User {
    private Integer id;

    private String username;

    private String password;

    private String nickname;

    private Integer sex;

    private List<Article> articles;

    private Date birthday;

    private String head;

    private Date createTime;
}
