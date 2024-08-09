package com.embarkx.companyms.company;

import java.util.List;

public interface CompanyService {
    List<Company> getAllCompanies();
    boolean updateCompany(Long id, Company company);
    String createCompany(Company company);
    boolean deleteCompany(Long id);
    Company getCompanyById(Long id);
}
