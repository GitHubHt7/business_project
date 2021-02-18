package com.sincerity.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Member {

    /**
     * 会员Id
     */
    private Long id;

    /**
     * 会员姓名
     */
    private String name;

    /**
     * 会员年龄
     */
    private Integer age;

    /**
     * 描述
     */
    private String description;
}
