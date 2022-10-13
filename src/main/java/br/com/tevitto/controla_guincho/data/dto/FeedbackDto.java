package br.com.tevitto.controla_guincho.data.dto;

import br.com.tevitto.controla_guincho.data.model.Feedback;

import java.util.Objects;

public class FeedbackDto {
    private Long id;

    private String comment;

    private Feedback_TypeDto feedback_type;

    private byte[] screenshot;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Feedback_TypeDto getFeedback_type() {
        return feedback_type;
    }

    public void setFeedback_type(Feedback_TypeDto feedback_type) {
        this.feedback_type = feedback_type;
    }

    public byte[] getScreenshot() {
        return screenshot;
    }

    public void setScreenshot(byte[] screenshot) {
        this.screenshot = screenshot;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Feedback)) return false;
        Feedback feedback = (Feedback) o;
        return Objects.equals(getId(), feedback.getId()) && Objects.equals(getComment(), feedback.getComment()) && Objects.equals(getFeedback_type(), feedback.getFeedback_type()) && Objects.equals(getScreenshot(), feedback.getScreenshot());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getComment(), getFeedback_type(), getScreenshot());
    }
}
