package Linkedin_clone_alt.demo.dto;

import jakarta.persistence.Lob;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Data
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
public class ProfilePicDTO {
    @Lob
    private MultipartFile picture;
}