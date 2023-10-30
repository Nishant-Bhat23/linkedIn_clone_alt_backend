package Linkedin_clone_alt.demo.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Blob;

@Data
@NoArgsConstructor
@AllArgsConstructor(staticName = "build")
@Entity
@Table(name ="posts")
public class Posts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int post_id;
    private int user_id;
    @Lob
    private Blob content;
    @Column(columnDefinition = "TEXT")
    private String descr;
    private String post_date;
    private String imageLink;
    @Column(columnDefinition = "LONGTEXT")
    private String base64Content;

}