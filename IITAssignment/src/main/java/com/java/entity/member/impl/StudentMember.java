package com.java.entity.member.impl;

import com.java.entity.member.DefaultMember;

public class StudentMember extends DefaultMember {
    private String schoolName;

    public StudentMember() {
        membershipType="student";
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }
}
