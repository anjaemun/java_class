package ch13_map.ex03;

import java.util.HashMap;
import java.util.Map;

public class MemberRepository {
    private static Map<Long, MemberDTO> memberDTOMap = new HashMap<>();


    public boolean SignUp(MemberDTO memberDTO) {
        MemberDTO memberDTO1 = memberDTOMap.put(memberDTO.getMemberId(), memberDTO);
        return memberDTO1 != null;
    }

    public boolean SignIn(String memberEmail, String memberPassword) {
        for (Long i : memberDTOMap.keySet()) {
            if (memberEmail.equals(memberDTOMap.get(i).getMemberEmail()) && memberPassword.equals(memberDTOMap.get(i).getMemberPassword())) {
                return true;
            }
        }
        return false;
    }

    public Map<Long, MemberDTO> memberList() {
        return memberDTOMap;
    }

    public boolean update(String loginEmail, String memberMobile) {
        for (Long i : memberDTOMap.keySet()) {
            if (loginEmail.equals(memberDTOMap.get(i).getMemberEmail())) {
                memberDTOMap.get(i).setMemberMobile(memberMobile);
                return true;
            }
        }
        return false;
    }

    public void delete(String memberPassword) {
        for (Long i : memberDTOMap.keySet()) {
            if (memberPassword.equals(memberDTOMap.get(i).getMemberPassword())) {
                memberDTOMap.remove(i);
            }
        }
    }

    public boolean emailCheck(String memberEmail) {
        for (Long i : memberDTOMap.keySet()) {
            if (memberEmail.equals(memberDTOMap.get(i).getMemberEmail())) {
                return true;
            }
        }
        return false;
    }
}
