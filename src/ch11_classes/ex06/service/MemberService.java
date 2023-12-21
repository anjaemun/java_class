package ch11_classes.ex06.service;

import ch11_classes.ex06.common.CommonVariables;
import ch11_classes.ex06.dto.MemberDTO;
import ch11_classes.ex06.repository.MemberRepository;

import java.util.List;
import java.util.Scanner;

public class MemberService {
    CommonVariables commonVariables = new CommonVariables();
    MemberRepository memberRepository = new MemberRepository();
    Scanner sc = new Scanner(System.in);

    public void save() {
        System.out.println("=====회원 가입=====");
        System.out.print("이메일 > ");
        String memberEmail = sc.next();
        MemberDTO emailCheck = memberRepository.emailCheck(memberEmail);
        if (emailCheck == null) {
            System.out.println("사용 가능한 이메일입니다.");
            System.out.print("비밀번호 > ");
            String memberPassword = sc.next();
            System.out.print("성명 > ");
            String memberName = sc.next();
            System.out.print("전화번호 > ");
            String memberMobile = sc.next();
            MemberDTO memberDTO = new MemberDTO(memberEmail, memberPassword, memberName, memberMobile);
            boolean save = memberRepository.save(memberDTO);
            if (save) {
                System.out.println("회원가입 완료");
            } else {
                System.out.println("회원가입 실패");
            }
        } else {
            System.out.println("이미 가입된 이메일입니다. 다시 입력해주세요.");
        }

    }

    public void login() {
        System.out.println("=====로그인=====");
        System.out.print("이메일 > ");
        String memberEmail = sc.next();
        System.out.print("비밀번호 > ");
        String memberPassword = sc.next();
        boolean login = memberRepository.login(memberEmail, memberPassword);
        if (login) {
            System.out.println("로그인 성공!!");
        } else {
            System.out.println("입력 정보가 일치하지 않습니다,,");
        }
    }

    public void memberList() {
        System.out.println("=====회원 목록=====");
        List<MemberDTO> memberDTOList = memberRepository.memberList();
        if (!memberDTOList.isEmpty()) {
            for (MemberDTO memberDTO : memberDTOList) {
                System.out.println("memberDTO = " + memberDTO);
            }
        } else {
            System.out.println("회원이 존재하지 않습니다.");
        }
    }

    public void update() {
        System.out.println("=====회원정보 수정=====");
        System.out.println("정보를 변경하시려면 아래 정보를 입력해주세요.");
        System.out.print("이메일 > ");
        String memberEmail = sc.next();
        MemberDTO updateCheck = memberRepository.emailCheck(memberEmail);
        if (updateCheck != null) {
            System.out.println("======================================");
            System.out.println("1.이메일 2.비밀번호 3.성명 4.전화번호 0.종료");
            System.out.println("======================================");
            System.out.print("변경할 정보 > ");
            int updateMenu = sc.nextInt();
            MemberDTO update = memberRepository.update(memberEmail, updateMenu);
            if (update != null) {
                System.out.println("정보 수정 완료!");
            } else {
                System.out.println("정보 수정 실패.");
            }
        } else {
            System.out.println("입력 정보가 일치하지 않습니다.");
        }
    }

    public void leave() {
        System.out.println("=====회원 탈퇴=====");
        System.out.print("탈퇴할 이메일 > ");
        String memberEmail = sc.next();
        MemberDTO leaveCheck = memberRepository.emailCheck(memberEmail);
        if (leaveCheck != null) {
            System.out.println("정말 탈퇴하시겠습니까? (y / n)");
            String input = sc.next();
            MemberDTO delete = memberRepository.leave(memberEmail, input);
            if (delete != null) {
                System.out.println("탈퇴 완료되었습니다.");
            }
        } else {
            System.out.println("입력 정보가 일치하지 않습니다.");
        }
    }

    public void logout() {
        CommonVariables.loginEmail = null;
        System.out.println("로그아웃 되었습니다.");
    }

    public void loginCheck() {
        String login = CommonVariables.loginEmail;
        if (login != null) {
            commonVariables.boardMenu();
        } else {
            System.out.println("회원 전용 게시판입니다.");
        }
    }
}
