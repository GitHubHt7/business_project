package com.sincerity.entity;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Company {

    /**
     * 公司名称
     */
    private String name;

    /**
     * 打印时间
     */
    private String printTime;

    /**
     * 会员列表
     */
    private List<Member> members;

    public List<Member> getMembers() {
        if (null == members){
            members = new ArrayList<>();
        }
        return members;
    }
}
