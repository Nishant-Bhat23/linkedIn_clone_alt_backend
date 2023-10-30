package Linkedin_clone_alt.demo.controller;

import Linkedin_clone_alt.demo.dto.LikeRequest;
import Linkedin_clone_alt.demo.Entity.Likes;
import Linkedin_clone_alt.demo.repositary.LikeRepository;
import Linkedin_clone_alt.demo.service.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class LikeController {
    @Autowired
    private LikeRepository likeRepository;
    @Autowired
    private LikeService likeService;

    @PostMapping("/like")
    public ResponseEntity<Likes> likeOrUnlikePost(@RequestBody LikeRequest likeRequest) {
        int postId = likeRequest.getPost_id();
        int userId = likeRequest.getUser_id();

        // Check if the like already exists
        Likes existingLike = likeRepository.findByPostIdAndUserId(postId, userId);
        if (existingLike != null) {
            // If it exists, remove the like
            likeRepository.delete(existingLike);
        } else {
            // If it doesn't exist, add the like
            likeRepository.save(Likes.build(0, postId, userId));
        }

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/{post_id}/totalLikes")
    public ResponseEntity<Integer> totalLikes(@PathVariable int post_id) {
        return ResponseEntity.ok(likeService.totalLikes(post_id));
    }
}