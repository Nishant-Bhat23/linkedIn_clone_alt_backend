package Linkedin_clone_alt.demo.controller;

import Linkedin_clone_alt.demo.dto.PostRequest;
import Linkedin_clone_alt.demo.Entity.Posts;
import Linkedin_clone_alt.demo.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/post")
public class PostController {
    @Autowired
    private PostService postService;

    @PostMapping("/{user_id}/postupload")
    public ResponseEntity<Posts> savePost(@PathVariable int user_id,
                                          @RequestParam("content") MultipartFile content,
                                          @RequestParam("post_date") String postDate,
                                          @RequestParam("imageLink") String imageLink,
                                          @RequestParam("descr") String descr
    ){
        PostRequest postRequest = new PostRequest();
        postRequest.setContent(content);
        postRequest.setPost_date(postDate);
        postRequest.setDescr(descr);
        postRequest.setImageLink(imageLink);
        postService.savePost(user_id,postRequest);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/getPosts")
    public ResponseEntity<List<Posts>> getAllPosts(){
        return ResponseEntity.ok(postService.getAllPosts());
    }

    @GetMapping("/{user_id}/getPost")
    public ResponseEntity<List<Posts>> getPost(@PathVariable int user_id){
        return ResponseEntity.ok(postService.getPost(user_id));
    }

    @DeleteMapping("/delete/{post_id}")
    public void deletePost(@PathVariable int post_id) {
        postService.deletePost(post_id);
    }
}