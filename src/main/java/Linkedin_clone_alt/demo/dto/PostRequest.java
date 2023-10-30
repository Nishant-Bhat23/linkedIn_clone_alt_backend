package Linkedin_clone_alt.demo.dto;

import jakarta.persistence.Lob;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Data
@NoArgsConstructor
@AllArgsConstructor(staticName = "build")
public class PostRequest {
    @Lob
    private MultipartFile content;
    private String descr;
    private String post_date;
    private String imageLink;
}
