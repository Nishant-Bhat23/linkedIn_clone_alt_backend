package Linkedin_clone_alt.demo.repositary;

import Linkedin_clone_alt.demo.Entity.Posts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PostRepository extends JpaRepository<Posts, Integer> {
    @Query("SELECT p FROM Posts p WHERE p.user_id = :user_id")
    List<Posts> findByUser_id(@Param("user_id") int user_id);

}
