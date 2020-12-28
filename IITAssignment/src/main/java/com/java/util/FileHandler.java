package com.java.util;

import com.java.entity.member.DefaultMember;
import com.java.entity.member.impl.Over60Member;
import com.java.entity.member.impl.StudentMember;

import java.io.*;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileHandler {

    private File dataFile;

    public FileHandler() throws URISyntaxException, IOException {

        dataFile = new File("./data/data.csv");
        dataFile.getParentFile().mkdirs();
        dataFile.createNewFile();

    }

    public void write(List<DefaultMember> members) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(dataFile));
        for (DefaultMember member : members) {
            String line = "" + member.getMembershipNo()
                    + "," + member.getName().trim()
                    + "," + member.getStartMembershipDate()
                    + "," + member.getMembershipType();

            if (!member.getMembershipType().equals("default")) {
                if (member.getMembershipType().equals("over60")) {
                    line += "," + ((Over60Member) member).getAge();
                } else {
                    line += "," + ((StudentMember) member).getSchoolName();
                }
            }

            writer.append(line);
            writer.newLine();
        }
        writer.flush();
        writer.close();
    }

    public List<DefaultMember> read() throws IOException {
        List<DefaultMember> members = new ArrayList<>();

        List<String> memberLines = Files.readAllLines(Paths.get("./data/data.csv"));

        for (String line:memberLines) {
            String[] memberData = line.split(",");

            DefaultMember member;

            switch (memberData[3]) {
                case "student": {
                    member = new StudentMember();
                    ((StudentMember) member).setSchoolName(memberData[4]);
                }
                break;
                case "over60": {
                    member = new Over60Member();
                    ((Over60Member) member).setAge(Integer.parseInt(memberData[4]));
                }
                break;
                default:
                    member = new DefaultMember();
            }

            member.setMembershipNo(Integer.parseInt(memberData[0]));
            member.setName(memberData[1]);
            member.setStartMembershipDate(new Date(memberData[2]));
            member.setMembershipType(memberData[3]);

            members.add(member);
        }

        System.out.println("Loading Completed");

        return members;
    }


}
