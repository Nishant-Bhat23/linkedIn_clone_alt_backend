package Linkedin_clone_alt.demo.service;

import Linkedin_clone_alt.demo.dto.CommentRequest;
import Linkedin_clone_alt.demo.Entity.Comments;
import Linkedin_clone_alt.demo.repositary.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentsService {
    @Autowired
    private CommentRepository commentRepository;

    //to save a comment
    public Comments saveComment(int user_id,CommentRequest commentRequest) {
        try {
            Comments comment = Comments.build(0, commentRequest.getPost_id(), user_id, commentRequest.getComment_text());
            return commentRepository.save(comment);
        }catch (Exception e) {
            throw new RuntimeException("Comment not posted");
        }
    }

    public List<Comments> getAllComments(){
        return commentRepository.findAll();
    }
}
