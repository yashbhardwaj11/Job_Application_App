package com.embarkx.jobms.job.impl;

import java.util.List;
import java.util.stream.Collectors;

import com.embarkx.jobms.job.clients.CompanyClient;
import com.embarkx.jobms.job.clients.ReviewsClient;
import com.embarkx.jobms.job.dto.JobDTO;
import com.embarkx.jobms.job.external.Company;
import com.embarkx.jobms.job.external.Reviews;
import com.embarkx.jobms.job.mapper.JobMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.embarkx.jobms.job.Job;
import com.embarkx.jobms.job.JobRepository;
import com.embarkx.jobms.job.JobService;
import org.springframework.web.client.RestTemplate;

@Service
public class JobServiceImpl implements JobService {

    JobRepository jobRepository;

    @Autowired
    RestTemplate restTemplate;

    private CompanyClient companyClient;
    private ReviewsClient reviewsClient;

    public JobServiceImpl(JobRepository jobRepository, CompanyClient companyClient , ReviewsClient reviewsClient) {
        this.jobRepository = jobRepository;
        this.companyClient = companyClient;
        this.reviewsClient = reviewsClient;
    }

    @Override
    public List<JobDTO> findAll() {
        List<Job> jobs = jobRepository.findAll();
        return jobs.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    private JobDTO convertToDto(Job job){
        Company company = companyClient.getCompany(job.getCompanyId());

        ResponseEntity<List<Reviews>> reviewResponse = reviewsClient.getReviews(job.getCompanyId());

        List<Reviews> reviews = reviewResponse.getBody();

        return JobMapper.mapToJobWithCompanyDto(job,company,reviews);
    }

    @Override
    public String createJob(Job job) {
        jobRepository.save(job);
        return "Job added Successfully";
    }

    @Override
    public JobDTO getJobById(Long id) {
        Job job = jobRepository.findById(id).orElse(null);
        return convertToDto(job);
    }

    @Override
    public boolean deleteJobById(Long id) {
        if(jobRepository.existsById(id)){
            jobRepository.deleteById(id);
            return true;
        }
        else return false;
    }

    @Override
    public boolean updateJobById(Long id, Job job) {
        if (jobRepository.existsById(id)) {
            Job existingJob = jobRepository.findById(id).get();
            if (job.getTitle() != null && !job.getTitle().isEmpty())
                existingJob.setTitle(job.getTitle());
            if (job.getDescription() != null && !job.getDescription().isEmpty())
                existingJob.setDescription(job.getDescription());
            if (job.getminSalary() != null && !job.getminSalary().isEmpty())
                existingJob.setminSalary(job.getminSalary());
            if (job.getMaxSalary() != null && !job.getMaxSalary().isEmpty())
                existingJob.setMaxSalary(job.getMaxSalary());
            if (job.getLocation() != null && !job.getLocation().isEmpty())
                existingJob.setLocation(job.getLocation());

            jobRepository.save(existingJob);
            return true;
        } else
            return false;
    }
}
