package ch11_classes.ex03;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MemberRepository {
    List<MemberDTO> memberDTOList = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    public boolean SignIn(MemberDTO memberDTO) {
        return memberDTOList.add(memberDTO);
    }

    public boolean SignUp(String memberEmail, String memberPassword) {
        boolean result = false;
        for (MemberDTO memberDTO : memberDTOList) {
            if (memberEmail.equals(memberDTO.getMemberEmail()) && memberPassword.equals(memberDTO.getMemberPassword())) {
                result = true;
            }
        }
        return result;
    }

    public List<MemberDTO> memberList() {
        return memberDTOList;
    }


    public Boolean update(String loginEmail, String memberMobile) {
        boolean result = false;
        for (int i = 0; i < memberDTOList.size(); i++) {
            if (loginEmail.equals(memberDTOList.get(i).getMemberEmail())) {
                if (memberMobile.equals(memberDTOList.get(i).getMemberMobile())) {
                    System.out.println(memberDTOList.get(i));
                    System.out.print("변경할 이메일 > ");
                    memberDTOList.get(i).setMemberEmail(sc.next());
                    System.out.print("변경할 비밀번호 > ");
                    memberDTOList.get(i).setMemberPassword(sc.next());
                    System.out.print("변경할 이름 > ");
                    memberDTOList.get(i).setMemberName(sc.next());
                    System.out.print("변경할 전화번호 > ");
                    memberDTOList.get(i).setMemberMobile(sc.next());
                    result = true;
                }
            }
        }
            return result;
    }

    public void delete(String memberPassword) {
        for (int i = 0; i < memberDTOList.size(); i++) {
            if (memberPassword.equals(memberDTOList.get(i).getMemberPassword())) {
                memberDTOList.remove(i);
                System.out.println("memberDTOList = " + memberDTOList);
            }
        }
    }


    public Boolean emailCheck(String memberEmail) {
        boolean result = false;
        for (MemberDTO memberDTO : memberDTOList) {
            if (memberEmail.equals(memberDTO.getMemberEmail())) {
                result = true;
            }
        }
        return result;
    }
}


