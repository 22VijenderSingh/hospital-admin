package com.vj.hospitaladmin.controller;

import com.vj.hospitaladmin.model.Patient;
import com.vj.hospitaladmin.service.PatientManagementService;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/patient/manage")
public class PatientManagementController {

  private PatientManagementService service;

  private Logger logger = LoggerFactory.getLogger(PatientManagementController.class);

  @Autowired
  public PatientManagementController(PatientManagementService service) {
    this.service = service;
  }

  @RequestMapping(path = "/add", method = RequestMethod.POST)
  public Patient add(@RequestBody Patient patient) {
    logger.info("Received request to add patient - {}", patient);
    return service.addPatient(patient);
  }

  @RequestMapping(path = "/update", method = RequestMethod.PUT)
  public Patient update(@RequestBody Patient patient) throws Exception {
    logger.info("Received updated request for patient - {}", patient);
    return service.update(patient);
  }

  @RequestMapping(path = "/delete", method = RequestMethod.DELETE)
  public void delete(Long id) {
    logger.info("Received request to delete patient with id - {}", id);
    service.deleteById(id);
  }

  @RequestMapping(path = "/fetchAll", method = RequestMethod.GET)
  public List<Patient> fetchAll() {
    return service.fetchAll();
  }
}
