package ch15_interface.ex02;

import java.util.ArrayList;
import java.util.List;

public class MemberRepositoryList implements MemberRepository {
    private static List<MemberDTO> memberDTOList = new ArrayList<>();

    @Override
    public boolean save(MemberDTO memberDTO) {
        return memberDTOList.add(memberDTO);
    }

    @Override
    public MemberDTO login(String memberEmail, String memberPassword) {
        MemberDTO memberDTO = null;
        for (MemberDTO dto : memberDTOList) {
            if (memberEmail.equals(dto.getMemberEmail()) && memberPassword.equals(dto.getMemberPassword())) {
                memberDTO = dto;
            }
        }
        return memberDTO;
    }

    @Override
    public List<MemberDTO> findAll() {
        return memberDTOList;
    }

    @Override
    public boolean update(String loginEmail, String mobile) {
        boolean result = false;
        for (MemberDTO memberDTO : memberDTOList) {
            if (loginEmail.equals(memberDTO.getMemberEmail())) {
                memberDTO.setMemberMobile(mobile);
                result = true;
            }
        }
        return result;
    }

    @Override
    public boolean delete(String loginEmail) {
        boolean result = false;
        for (int i = 0; i < memberDTOList.size(); i++) {
            if (loginEmail.equals(memberDTOList.get(i).getMemberEmail())) {
                memberDTOList.remove(i);
                result = true;
            }
        }
        return result;
    }

    @Override
    public boolean emailCheck(String memberEmail) {
        boolean result = true;
        for (MemberDTO memberDTO : memberDTOList) {
            if (memberEmail.equals(memberDTO.getMemberEmail())) {
                // 중복 되는 이메일이 있다 => 결과를 false로 주자
                result = false;
            }
        }
        return result;
    }
}
