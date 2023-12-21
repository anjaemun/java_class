package ch11_classes.ex03;

import java.util.List;
import java.util.Scanner;

public class MemberService {
    private static String loginEmail = null;
    static MemberRepository memberRepository = new MemberRepository();

    static Scanner sc = new Scanner(System.in);

    public void SignIn() {
        System.out.print("이메일 > ");
        String memberEmail = sc.next();
        memberRepository.emailCheck(memberEmail);
        boolean result = memberRepository.emailCheck(memberEmail);
        if (result) {
            System.out.println("이메일이 존재합니다. 다시 시도해주세요");
            SignIn();
        } else {
            System.out.println("사용 가능합니다.");
        }
        System.out.print("비밀번호 > ");
        String memberPassword = sc.next();
        System.out.print("이름 > ");
        String memberName = sc.next();
        System.out.print("전화번호 > ");
        String memberMobile = sc.next();
        MemberDTO memberDTO = new MemberDTO(memberEmail, memberPassword, memberName, memberMobile);
        boolean result2 = memberRepository.SignIn(memberDTO);
        if (result2) {
            System.out.println("등록 완료");
        } else {
            System.out.println("등록 실패");
        }
    }

    public void SignUp() {
        System.out.print("이메일 > ");
        String memberEmail = sc.next();
        System.out.print("비밀번호 > ");
        String memberPassword = sc.next();
        boolean result = memberRepository.SignUp(memberEmail, memberPassword);
        if (result) {
            System.out.println("로그인 성공");
            System.out.println(memberEmail+"님 환영합니다.");
            loginEmail = memberEmail;
        } else {
            System.out.println("이메일 또는 비밀번호가 틀립니다.");
        }


    }

    public void memberList() {
        List<MemberDTO> memberDTOList = memberRepository.memberList();
        for (MemberDTO memberDTO : memberDTOList) {
            System.out.println("memberDTO = " + memberDTO);
        }
    }

    public void update() {
        if (loginEmail != null) {
            System.out.print("전화번호 > ");
            String memberMobile = sc.next();
            boolean result = memberRepository.update(loginEmail,memberMobile);
            if (result) {
                System.out.println("정보 수정 완료");
            } else {
                System.out.println("정보 수정 실패");
            }
        } else {
            System.out.println("로그인 하세요.");
        }
    }

    public void delete() {
        if (loginEmail != null) {
            System.out.print("이메일 > ");
            String memberEmail = sc.next();
            if (loginEmail.equals(memberEmail)) {
                System.out.print("비밀번호 > ");
                String memberPassword = sc.next();
                memberRepository.delete(memberPassword);
            } else {
                System.out.println("회원정보와 다릅니다.");
            }
        } else {
            System.out.println("로그인 하세요");
        }

    }

    public void logout() {
        if (loginEmail != null) {
            loginEmail = null;
            System.out.println("로그아웃 완료");
        } else {
            System.out.println("로그인이 되어 있지 않습니다.");
        }
    }
    /*public void emailCheck() {
        System.out.print("이메일 > ");
        String memberEmail = sc.next();
        boolean result = memberRepository.emailCheck(memberEmail);
        if (result) {
            System.out.println("이메일이 존재합니다.");
        } else {
            System.out.println("사용 가능합니다.");
        }
    }*/
}
