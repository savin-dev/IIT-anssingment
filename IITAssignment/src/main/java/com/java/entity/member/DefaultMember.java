package com.java.entity.member;

import com.java.util.Date;

public class DefaultMember {

    private static int currentMembershipNo=1;

    protected int membershipNo;
    protected String name;
    protected Date startMembershipDate;
    protected String membershipType="default";

    public DefaultMember() {
        membershipNo=currentMembershipNo++;
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
