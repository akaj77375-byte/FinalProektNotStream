package dao.daoImpl;

import dao.DepartmentDao;
import database.DB;
import database.GenId;
import models.Department;
import models.Hospital;

import java.util.List;

public class DepartmentDaoImpl implements DepartmentDao {
    @Override
    public List<Department> getAllDepartmentByHospital(Long id) {
        for (Hospital h: DB.hospitals) {
if (h.getId().equals(id)){
    return h.getDepartments();
}
        }
        return List.of();
    }

    @Override
    public Department findDepartmentByName(Long hospitalId, String name) {
        for (Hospital h: DB.hospitals){
            for (Department d:h.getDepartments()){
                if (d.getDepartmentName().equals(name)){
                    return d;
                }
            }
        }
        return null;
    }

    @Override
    public String add(Long hospitalId, Department department) {
        for (Hospital h:DB.hospitals){
            if (h.getId().equals(hospitalId)){
                Long newId= GenId.getDepartmentId(hospitalId);
               department.setId(newId);
                h.getDepartments().add(department);
            }
        }
        return "";
    }

    @Override
    public void removeById(Long hospital,Long id) {
        for (Hospital h:DB.hospitals){
            if (h.getId().equals(hospital)){
                h.getDepartments().removeIf(department -> department.getId().equals(id));
            }
        }
    }

    @Override
    public String updateById(Long hospital, Long id, Department department) {
        for (Hospital h:DB.hospitals){
            if (h.getId().equals(hospital)){
                for (Department d:h.getDepartments()){
                    if (d.getId().equals(id)){
                        d.setDepartmentName(department.getDepartmentName());
                    }
                }
            }
        }
        return "";
    }
}
