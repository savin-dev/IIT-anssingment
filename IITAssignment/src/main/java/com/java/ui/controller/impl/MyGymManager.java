package com.java.ui.controller.impl;

import com.java.entity.member.DefaultMember;
import com.java.entity.member.impl.Over60Member;
import com.java.entity.member.impl.StudentMember;
import com.java.ui.controller.GymManager;
import com.java.util.Date;
import com.java.util.FileHandler;

import java.io.IOException;
import java.net.URISyntaxException;
import java.time.LocalDate;
import java.util.Scanner;

public class MyGymManager implements GymManager {
    private Scanner scanner;
    private FileHandler fileHandler;

    public MyGymManager(Scanner scanner) {
        try {
            this.fileHandler = new FileHandler();
            members.addAll(fileHandler.read());
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.scanner = scanner;
        scanner.useDelimiter("\n");
    }

    @Override
    public void registerMember() {
        System.out.println("Enter the following information to add a new member");
        System.out.println("===================================================");

        String name = null;
        while (name == null || name.isEmpty()) {
            System.out.print("Name\t\t: ");
            name = scanner.next();
        }

        String dateStr = "";
        do {
            System.out.println("Use format yyyy-mm-dd, or press enter to set today");
            System.out.print("Registration Date\t\t: ");
            dateStr = scanner.next();
            System.out.println(dateStr);
        } while (!dateStr.isEmpty() && !dateStr.matches("\\d{4}-\\d{2}-\\d{2}$"));

        Date date;
        if (dateStr.matches("/\\d{4}-\\d{2}-\\d{2}\\n/")) {
            String dateArr[] = dateStr.split("-");
            date = new Date(
                    Integer.parseInt(dateArr[0]),
                    Integer.parseInt(dateArr[1]),
                    Integer.parseInt(dateArr[2])
            );
        } else {
            date = new Date(
                    LocalDate.now().getYear(),
                    LocalDate.now().getMonthValue(),
                    LocalDate.now().getDayOfMonth()
            );
        }

        int ageGroup=0;
        while (ageGroup<1 || ageGroup>3) {
            System.out.println("Select age group from following.");
            System.out.println("\t1. 5-20\t\t2. 20-60\t\t3. 60+");
            System.out.print("Group No\t\t: ");
            ageGroup = scanner.nextInt();
        }

        DefaultMember member;
        switch (ageGroup) {
            case 1: {
                member = new StudentMember();
                System.out.print("School name\t\t: ");
                String school = scanner.next();
                ((StudentMember)member).setSchoolName(school);
                break;
            }
            case 3: {
                member = new Over60Member();
                System.out.print("Age\t\t: ");
                int age = scanner.nextInt();
                ((Over60Member)member).setAge(age);
                break;
            }
            default:
                member = new DefaultMember();
        }

        member.setName(name);
        member.setStartMembershipDate(date);

        members.add(member);
        System.out.println("Member created successfully\n");
    }

    @Override
    public void removeMember() {
        System.out.println("Enter the membership number to remove member");
        int num=scanner.nextInt();
        members.removeIf(defaultMember -> defaultMember.getMembershipNo()==num);
    }

    @Override
    public void listMembers() {
        System.out.format("%-15s%-30s%-20s%-10s%-6s%-50s\n", "Membership No","Name","Registration Date","Type","Age","School");
        for (DefaultMember member : members) {
            if (member instanceof StudentMember)
                System.out.format("%-15s%-30s%-20s%-10s%-6s%-50s\n",
                        member.getMembershipNo(),
                        member.getName(),
                        member.getStartMembershipDate(),
                        member.getMembershipType(),
                        "",
                        ((StudentMember)member).getSchoolName()
                );
            else if (member instanceof Over60Member)
                System.out.format("%-15s%-30s%-20s%-10s%-6s%-50s\n",
                        member.getMembershipNo(),
                        member.getName(),
                        member.getStartMembershipDate(),
                        member.getMembershipType(),
                        ((Over60Member)member).getAge(),
                        ""
                );
            else
                System.out.format("%-15s%-30s%-20s%-10s%-6s%-50s\n",
                        member.getMembershipNo(),
                        member.getName(),
                        member.getStartMembershipDate(),
                        member.getMembershipType(),
                        "",
                        ""
                );
        }
        System.out.println("\nPress enter to continue");
        scanner.next();
    }

    @Override
    public void sortMembersByName() {
        members.sort((o1, o2) -> {
            return o1.getName().compareToIgnoreCase(o2.getName());
        });
    }

    @Override
    public String save() {
        try {
            fileHandler.write(members);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


}
