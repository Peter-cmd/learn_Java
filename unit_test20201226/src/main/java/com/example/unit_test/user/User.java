package com.example.unit_test.user;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class User {
    Long id;

    String name;

    String passwd;
}
