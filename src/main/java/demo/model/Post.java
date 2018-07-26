package demo.model;

import javax.persistence.*;
import java.util.Date;
@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String title;
    private String content;
    @Temporal(TemporalType.TIMESTAMP)
    private Date created;

    public Post(String title, String content){
        this.title=title;
        this.content=content;
        this.created=new Date();

    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId(){
        return id;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }


}
