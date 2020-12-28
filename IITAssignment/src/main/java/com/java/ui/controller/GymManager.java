package com.java.ui.controller;

import com.java.entity.member.DefaultMember;

import java.util.ArrayList;
import java.util.List;

public interface GymManager {

    List<DefaultMember> members=new ArrayList<>(100);

    void registerMember();
    void removeMember();
    void listMembers();
    void sortMembersByName();
    String save();
}
