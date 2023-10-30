package Linkedin_clone_alt.demo.repositary;

import Linkedin_clone_alt.demo.Entity.Likes;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LikeRepository extends JpaRepository<Likes, Integer>{
    List<Likes> findAllByPostId(int post_id);
    Likes findByPostIdAndUserId(int postId, int userId);
}
