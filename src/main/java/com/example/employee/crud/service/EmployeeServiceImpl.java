package com.example.employee.crud.service;

import com.example.employee.crud.dao.EmployeeDAO;
import com.example.employee.crud.entity.Employee;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeDAO employeeDAO;

    // Constructor Dependency Injection untuk EmployeeDAO
    public EmployeeServiceImpl(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    /**
     * Mengambil semua employee dari database.
     */
    @Override
    public List<Employee> findAll() {
        return employeeDAO.findAll();
    }

    /**
     * Mencari employee berdasarkan ID.
     * Jika tidak ditemukan, kembalikan null.
     */
    @Override
    public Employee findById(int id) {
        Optional<Employee> result = Optional.ofNullable(employeeDAO.findById(id));
        return result.orElse(null);
    }

    /**
     * Menyimpan atau memperbarui employee.
     * Jika ID adalah 0, berarti employee baru; jika tidak, update employee.
     */
    @Override
    public Employee save(Employee employee) {
        return employeeDAO.save(employee);
    }

    /**
     * Menghapus employee berdasarkan ID.
     */
    @Override
    public void deleteById(int id) {
        employeeDAO.deleteById(id);
    }
}
