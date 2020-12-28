package com.java.ui.models;

import com.java.util.Date;

public class MemberTableModel {

    private int membershipNo;
    private String name;
    private Date startMembershipDate;
    private String membershipType;

    public MemberTableModel() {
    }

    public MemberTableModel(String name, Date startMembershipDate, String membershipType) {
        this.name = name;
        this.startMembershipDate = startMembershipDate;
        this.membershipType = membershipType;
    }

    public MemberTableModel(int membershipNo, String name, Date startMembershipDate, String membershipType) {
        this.membershipNo = membershipNo;
        this.name = name;
        this.startMembershipDate = startMembershipDate;
        this.membershipType = membershipType;
    }

    public int getMembershipNo() {
        return membershipNo;
    }

    public void setMembershipNo(int membershipNo) {
        this.membershipNo = membershipNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getStartMembershipDate() {
        return startMembershipDate;
    }

    public void setStartMembershipDate(Date startMembershipDate) {
        this.startMembershipDate = startMembershipDate;
    }

    public String getMembershipType() {
        return membershipType;
    }

    public void setMembershipType(String membershipType) {
        this.membershipType = membershipType;
    }
}
