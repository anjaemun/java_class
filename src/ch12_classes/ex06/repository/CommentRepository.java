package ch12_classes.ex06.repository;

import ch12_classes.ex06.dto.CommentDTO;

import java.util.ArrayList;
import java.util.List;

public class CommentRepository {
    List<CommentDTO> commentDTOList = new ArrayList<>();
    public boolean writeComment(CommentDTO commentDTO) {
        return commentDTOList.add(commentDTO);
    }
    public List<CommentDTO> commentCheck() {
        if (!commentDTOList.isEmpty()){
            return commentDTOList;
        }
        return null;
    }
}




