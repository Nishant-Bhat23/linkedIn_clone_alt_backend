package Linkedin_clone_alt.demo.controller;

import Linkedin_clone_alt.demo.dto.CommentRequest;
import Linkedin_clone_alt.demo.Entity.Comments;
import Linkedin_clone_alt.demo.service.CommentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/post")
public class CommentController {
    @Autowired
    private CommentsService commentService;

    @PostMapping("/{user_id}/postComment")
    public ResponseEntity<Comments> saveComment(@PathVariable int user_id,@RequestBody CommentRequest commentRequest){
        return new ResponseEntity<>(commentService.saveComment(user_id, commentRequest),HttpStatus.CREATED);
    }

    @GetMapping("/getComments")
    public ResponseEntity<List<Comments>> getComments(){
        return ResponseEntity.ok(commentService.getAllComments());
    }
}
