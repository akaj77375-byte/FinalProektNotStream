package service.serviceImpl;

import dao.DepartmentDao;
import dao.daoImpl.DepartmentDaoImpl;
import models.Department;
import service.DepartmentService;

import java.util.List;

public class DepartmentServiceIMpl implements DepartmentService {
DepartmentDao departmentDao=new DepartmentDaoImpl();
    @Override
    public List<Department> getAllDepartmentByHospital(Long hospitalId) {

        return departmentDao.getAllDepartmentByHospital(hospitalId);
    }

    @Override
    public Department findDepartmentByName(Long hospitalId, String name) {
        return departmentDao.findDepartmentByName(hospitalId,name);
    }

    @Override
    public String add(Long hospitalId, Department department) {
        departmentDao.add(hospitalId,department);
        return "Успешно добавлен";
    }

    @Override
    public String removeById(Long hospital, Long id) {
departmentDao.removeById(hospital,id);
return "Успешно удален";
    }

    @Override
    public String updateById(Long hospital, Long id, Department department) {
        departmentDao.updateById(hospital,id,department);
        return "Успешно обновлен";
    }
}
