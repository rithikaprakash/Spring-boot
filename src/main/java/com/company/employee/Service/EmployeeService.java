package com.company.employee.Service;

import com.company.employee.model.EmployeeEntity;
import com.company.employee.repository.EmployeeRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    public List<EmployeeEntity> getAllEmployees()
    {
        List<EmployeeEntity> employeeList = employeeRepository.findAll();
        if(employeeList.size()>0)
            return employeeList;
        else
            return new ArrayList<EmployeeEntity>();
    }
    public  EmployeeEntity getEmployeeWithId(Long id) throws NotFoundException {
        Optional<EmployeeEntity> employee = employeeRepository.findById(id);
        if(employee.isPresent()){
            return employee.get();
        }
        else{
            throw new NotFoundException("Employee record is not present");
        }
    }
    public EmployeeEntity createOrUpdateEmployee(EmployeeEntity entity) throws NotFoundException{
        Optional<EmployeeEntity> employee = employeeRepository.findById(entity.getId());

        if(employee.isPresent())
        {
            EmployeeEntity newEntity = employee.get();
            newEntity.setEmployeeName(entity.getEmployeeName());
            newEntity.setEmployeeEmail(entity.getEmployeeEmail());
            newEntity.setEmployeeMobile(entity.getEmployeeMobile());
            newEntity.setEmployeeCompany(entity.getEmployeeCompany());

            newEntity = employeeRepository.save(newEntity);

            return newEntity;
        } else {
            entity = employeeRepository.save(entity);

            return entity;
        }
    }
    public void deleteEmployeeWithId(Long id) throws NotFoundException
    {
        Optional<EmployeeEntity> employee = employeeRepository.findById(id);
        if(employee.isPresent())
        {
            employeeRepository.deleteById(id);
        }
        else
            throw new NotFoundException("Employee with id is not found and hence cannot be deleted");
    }

}
