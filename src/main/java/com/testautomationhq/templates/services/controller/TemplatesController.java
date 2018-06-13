package com.testautomationhq.templates.services.controller;

import com.testautomationhq.data_objects_library.Template;
import com.testautomationhq.templates.services.repo.TemplatesRepository;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/rest/api/templates")
public class TemplatesController {

    @Autowired
    TemplatesRepository templatesRepository;

    @RequestMapping(method = RequestMethod.GET, params = "offset")
    public Page<Template> listTemplates(@RequestParam("offset") int offset) {
        Pageable tempateableRequest = PageRequest.of(offset, 10);
        return templatesRepository.findAll(tempateableRequest);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{templateId}")
    public Template getTemplateById(@PathVariable String templateId) {
        return templatesRepository.findById(templateId).get();
    }

    @RequestMapping(method = RequestMethod.POST)
    public String addTemplate(@RequestBody Template testStep) {
        testStep.setTemplateId(UUID.randomUUID().toString());
        return templatesRepository.save(testStep).getTemplateId();
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{templateId}")
    public void deleteTemplate(@PathVariable String templateId) {
        Template template = templatesRepository.findById(templateId).get();
        templatesRepository.delete(template);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/{templateId}")
    public void updateTemplate(@PathVariable String templateId, @RequestBody Template template) {
        template.setTemplateId(templateId);
        templatesRepository.save(template);
    }
}
