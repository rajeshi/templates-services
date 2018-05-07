/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.testautomationhq.templates.services.repo;

import com.testautomationhq.templates.services.models.Template;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author abc
 */
public interface TemplatesRepository extends MongoRepository<Template, String> {

}
