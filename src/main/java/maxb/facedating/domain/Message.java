package maxb.facedating.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "MESSAGES")
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ID")
    private Long id;

    @Column(name="CHAT_ID")
    private Long chatId;

    @Column(name="MESSAGE")
    private String message;

    @Column(name="IS_ANSWER")
    private boolean answer;

    @Column(name = "CREATE_AT")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getChatId() {
        return chatId;
    }

    public void setChatId(Long chatId) {
        this.chatId = chatId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public boolean isAnswer() {
        return answer;
    }

    public void setAnswer(boolean answer) {
        this.answer = answer;
    }
}
