package br.com.tevitto.controla_guincho.service;

import br.com.tevitto.controla_guincho.data.dto.FeedbackDto;
import br.com.tevitto.controla_guincho.data.dto.Feedback_TypeDto;
import br.com.tevitto.controla_guincho.data.model.Feedback;
import br.com.tevitto.controla_guincho.data.model.Feedback_Type;
import br.com.tevitto.controla_guincho.repository.FeedbackRepository;
import br.com.tevitto.controla_guincho.repository.Feedback_TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FeedbackService {

    @Autowired
    private FeedbackRepository feedbackRepository;
    private Feedback feedback;

    @Autowired
    private Feedback_TypeRepository feedback_typeRepository;  
    private Feedback_Type feedback_type;

    public FeedbackDto saveFeedback(FeedbackDto dto) {
        feedback = new Feedback();
        feedback.setComment(dto.getComment());
        feedback.setScreenshot(dto.getScreenshot());
        feedback.setFeedback_type(feedback_typeRepository
                .findByDescription(dto.getFeedback_type().getDescription()).get());
        Feedback save = feedbackRepository.save(feedback);
        dto.setId(save.getId());
        return dto;
    }

    public List<FeedbackDto> findAll() {
        List<FeedbackDto> dtos = new ArrayList<>();
        List<Feedback> models = feedbackRepository.findAll();


        for (Feedback m : models) {
            String preffix = "data:image/png;base64," + m.getScreenshot();

            FeedbackDto dto = new FeedbackDto();

            dto.setId(m.getId());
            dto.setComment(m.getComment());
            dto.setScreenshot(preffix.getBytes());
            dto.setFeedback_type(convertFeedbackTypeToDto(m.getFeedback_type()));

            dtos.add(dto);
        }

        return dtos;
    }

    private Feedback_TypeDto convertFeedbackTypeToDto(Feedback_Type model) {
        Feedback_TypeDto dto = new Feedback_TypeDto();

        dto.setDescription(model.getDescription());
        dto.setId(model.getId());
        return dto;
    }
}
