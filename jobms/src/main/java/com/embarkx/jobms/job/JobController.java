package com.embarkx.jobms.job;

import com.embarkx.jobms.job.dto.JobDTO;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
@RequestMapping("/jobs")
public class JobController {
    
    private final JobService jobService;

    public JobController(JobService jobService){
        this.jobService = jobService;
    }

    @GetMapping
    public ResponseEntity<List<JobDTO>> findAll() {
        return ResponseEntity.ok(jobService.findAll());
    }

    @PostMapping
    public ResponseEntity<String> createJob(@RequestBody Job job) {
       return new ResponseEntity<>(jobService.createJob(job) , HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<JobDTO> getJobById(@PathVariable Long id) {
        JobDTO jobDto = jobService.getJobById(id);
        return jobDto != null ? new ResponseEntity<>(jobDto, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteJobById(@PathVariable Long id) {
        boolean deleted = jobService.deleteJobById(id);
        return deleted ? ResponseEntity.ok("Job deleted Successfully") : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateJobById(@PathVariable Long id, @RequestBody Job job) {
        boolean updated = jobService.updateJobById(id,job);
        if (updated) {
            return ResponseEntity.ok("Job Updated Successfully.");
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}


/*
    
    GET /jobs: Get all jobs
    GET /jobs/{id} : Get a specific job with that id
    POST /jobs : Create a new job (Request body must contain the job details)
    DELETE /jobs/{id} : Delete a specific job by id
    PUT /jobs/{id} : Update a specific job by ID (Request body should contain the updated document)
    GET /jobs/{id}/company : Get compant asosciated with specific job by id

 */