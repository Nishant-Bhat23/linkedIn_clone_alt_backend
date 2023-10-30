package Linkedin_clone_alt.demo.service;

import Linkedin_clone_alt.demo.dto.LikeRequest;
import Linkedin_clone_alt.demo.Entity.Likes;
import Linkedin_clone_alt.demo.repositary.LikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LikeService {
    @Autowired
    private LikeRepository likeRepository;

    public Likes likePost(LikeRequest likeRequest) {
        Likes like = Likes.build(0, likeRequest.getPost_id(), likeRequest.getUser_id());
        return likeRepository.save(like);
    }

    public int totalLikes(int post_id) {
        List<Likes> likes = likeRepository.findAllByPostId(post_id);
        return likes.size();
    }
}
