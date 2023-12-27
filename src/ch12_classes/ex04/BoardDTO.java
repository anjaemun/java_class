package ch12_classes.ex04;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

//글작성
//        제목(boardTitle), 작성자(boardWriter), 내용(boardContents), 비밀번호(boardPass)입력 받음
//        비밀번호는 글수정, 삭제 시 활용
//        글번호(id)는 자동으로 증가
//        글목록
//        전체 글목록 출력
//        목록 출력시 글번호, 제목, 작성자, 조회수 값만 출력됨
//        글조회
//        목록에서 게시글 번호를 입력하면 해당 글의 상세 내용을 보여줌
//        상세 내용 출력 이전에 해당 게시글의 조회수 값을 1 증가시켜줘야 함.
//        글수정
//        수정할 글번호를 입력 받고 비밀번호도 입력 받아서 비밀번호가 일치하면 수정할 제목, 내용을 입력받고 수정 처리.
//        비밀번호가 틀리면 틀렸다는 메시지 출력
//        글삭제
//        수정할 글번호를 입력 받고 비밀번호도 입력 받아서 비밀번호가 일치하면 글삭제 처리
//        비밀번호가 틀리면 틀렸다는 메시지 출력
//        검색
//        제목으로만 검색가능
//        입력한 검색어가 포함된 결과를 목록으로 출력
public class BoardDTO {
    private Long id;
    private String boardTitle;
    private String boardWriter;
    private String boardContents;
    private String boardPass;

    private Long boardHits;
    private String createdAt;


    @Override
    public String toString() {
        return "| id = " + id + " | Title = '" + boardTitle + '\'' + "| Writer = '" + boardWriter + '\'' + "| 조회수 = " + boardHits + " | \n"
                + "*****************************************************************************";
    }

    public Long getBoardHits() {
        return boardHits;
    }

    public void setBoardHits(Long boardHits) {
        this.boardHits = boardHits;
    }

    public String getBoardTitle() {
        return boardTitle;
    }

    public void setBoardTitle(String boardTitle) {
        this.boardTitle = boardTitle;
    }

    public String getBoardWriter() {
        return boardWriter;
    }

    public void setBoardWriter(String boardWriter) {
        this.boardWriter = boardWriter;
    }

    public String getBoardContents() {
        return boardContents;
    }

    public void setBoardContents(String boardContents) {
        this.boardContents = boardContents;
    }

    public String getBoardPass() {
        return boardPass;
    }

    public void setBoardPass(String boardPass) {
        this.boardPass = boardPass;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }
    public static Long idValue = 1L;

    public BoardDTO(String boardTitle, String boardWriter, String boardContents, String boardPass) {
        this.id = idValue++;
        this.boardHits = 0L;
        this.boardTitle = boardTitle;
        this.boardWriter = boardWriter;
        this.boardContents = boardContents;
        this.boardPass = boardPass;
        this.createdAt = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy년 MM월 dd일 HH시 mm분"));
    }
}
