package Linkedin_clone_alt.demo.repositary;

import Linkedin_clone_alt.demo.Entity.Comments;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comments, Integer>{

}
