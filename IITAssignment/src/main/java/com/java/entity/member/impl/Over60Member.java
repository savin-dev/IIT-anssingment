package com.java.entity.member.impl;

import com.java.entity.member.DefaultMember;

public class Over60Member extends DefaultMember {
    private int age;

    public Over60Member() {
        membershipType="over60";
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
