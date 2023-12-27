package ch12_classes.ex06.repository;

import ch12_classes.ex06.common.CommonVariables;
import ch12_classes.ex06.dto.MemberDTO;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MemberRepository {
    List<MemberDTO> memberDTOList = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    public MemberDTO emailCheck(String memberEmail) {
        for (MemberDTO memberDTO : memberDTOList) {
            if (memberEmail.equals(memberDTO.getMemberEmail())) {
                return memberDTO;
            }
        }
        return null;
    }


    public boolean save(MemberDTO memberDTO) {
        return memberDTOList.add(memberDTO);
    }

    public boolean login(String memberEmail, String memberPassword) {
        for (MemberDTO memberDTO : memberDTOList) {
            if (memberEmail.equals(memberDTO.getMemberEmail()) && memberPassword.equals(memberDTO.getMemberPassword())) {
                CommonVariables.loginEmail = memberEmail;
                return true;
            }
        }
        return false;
    }

    public List<MemberDTO> memberList() {
        return memberDTOList;
    }

    public MemberDTO update(String memberEmail, int updateMenu) {
        boolean run = true;
        for (MemberDTO memberDTO : memberDTOList) {
            if (memberEmail.equals(memberDTO.getMemberEmail())) {
                while (run) {
                    if (updateMenu == 1) {
                        memberDTO.setMemberEmail(sc.next());
                        break;
                    } else if (updateMenu == 2) {
                        memberDTO.setMemberPassword(sc.next());
                        break;
                    } else if (updateMenu == 3) {
                        memberDTO.setMemberName(sc.next());
                        break;
                    } else if (updateMenu == 4) {
                        memberDTO.setMemberMobile(sc.next());
                        break;
                    } else {
                        run = false;
                    }
                }
            }
            return memberDTO;
        }
        return null;
    }

    public MemberDTO leave(String memberEmail, String input) {
        for (int i = 0; i < memberDTOList.size(); i++) {
            if (memberEmail.equals(memberDTOList.get(i).getMemberEmail())) {
                if (input.equals("y")) {
                    return memberDTOList.remove(i);
                }
            }
        }
        return null;
    }
}

