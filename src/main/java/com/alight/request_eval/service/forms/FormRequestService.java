package com.alight.request_eval.service.forms;

import com.alight.request_eval.model.dto.FormListDto;
import com.alight.request_eval.repository.forms.FormRequestRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FormRequestService implements IFormService {

    final private FormRequestRepository repository;

    public FormRequestService(FormRequestRepository repository) {
        this.repository = repository;
    }

    public List<FormListDto> getFormsByPlan(){
        return null;
    }
}
