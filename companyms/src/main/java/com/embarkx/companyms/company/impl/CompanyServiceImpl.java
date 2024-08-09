package com.embarkx.companyms.company.impl;

import java.util.List;
import org.springframework.stereotype.Service;

import com.embarkx.companyms.company.Company;
import com.embarkx.companyms.company.CompanyRepository;
import com.embarkx.companyms.company.CompanyService;
import com.embarkx.companyms.company.impl.CompanyServiceImpl;;

@Service
public class CompanyServiceImpl implements CompanyService {

    private CompanyRepository companyRepository;

    public CompanyServiceImpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    @Override
    public boolean updateCompany(Long id, Company company) {
        if (companyRepository.existsById(id)) {
            Company existingCompany = companyRepository.findById(id).get();
            if (company.getName() != null && !company.getName().isEmpty())
                existingCompany.setName(company.getName());
            if (company.getDescription() != null && !company.getDescription().isEmpty())
                existingCompany.setDescription(company.getDescription());
            companyRepository.save(existingCompany);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String createCompany(Company company) {
        companyRepository.save(company);
        return "Company added Successfully";
    }

    @Override
    public boolean deleteCompany(Long id) {
        if (companyRepository.existsById(id)) {
            companyRepository.deleteById(id);
            return true;
        } else
            return false;
    }

    @Override
    public Company getCompanyById(Long id) {
        return companyRepository.findById(id).orElse(null);
    }

}
