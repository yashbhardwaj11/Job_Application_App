package com.embarkx.jobms.job.mapper;

import com.embarkx.jobms.job.Job;
import com.embarkx.jobms.job.dto.JobDTO;
import com.embarkx.jobms.job.external.Company;
import com.embarkx.jobms.job.external.Reviews;

import java.util.List;

public class JobMapper {
    public static JobDTO mapToJobWithCompanyDto(Job job, Company company, List<Reviews> reviews){
        JobDTO jobDto = new JobDTO();
        jobDto.setId(job.getId());
        jobDto.setLocation(job.getLocation());
        jobDto.setDescription(job.getDescription());
        jobDto.setTitle(job.getTitle());
        jobDto.setMaxSalary(job.getMaxSalary());
        jobDto.setMinSalary(job.getminSalary());
        jobDto.setCompany(company);
        jobDto.setReviews(reviews);
        return jobDto;
    }
}
