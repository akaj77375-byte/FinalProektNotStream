package service.serviceImpl;

import dao.DoctorDao;
import dao.daoImpl.DoctorDaoImpl;
import models.Doctor;
import service.DoctorService;

import java.util.List;

public class DoctorServiceImpl implements DoctorService {
DoctorDao doctorDao=new DoctorDaoImpl();
    @Override
    public Doctor findDoctorById(Long hospitalId, Long id) {
        return doctorDao.findDoctorById(hospitalId,id);
    }

    @Override
    public String assignDoctorToDepartment(Long hospitalId, Long departmentId, List<Long> doctorsId) {
        doctorDao.assignDoctorToDepartment(hospitalId,departmentId,doctorsId);
        return "Успешно добавлены";
    }

    @Override
    public List<Doctor> getAllDoctorsByHospitalId(Long id) {
        return doctorDao.getAllDoctorsByHospitalId(id);
    }

    @Override
    public List<Doctor> getAllDoctorsByDepartmentId(Long hospitalId, Long departmentId) {
        return doctorDao.getAllDoctorsByDepartmentId(hospitalId,departmentId);
    }


    @Override
    public String add(Long hospitalId, Doctor doctor) {
        doctorDao.add(hospitalId,doctor);
        return "Успешно добавлен";
    }

    @Override
    public String removeById(Long hospital, Long id) {
        doctorDao.removeById(hospital,id);
        return "Успешно удален";
    }

    @Override
    public String updateById(Long hospital, Long id, Doctor doctor) {
        doctorDao.updateById(hospital, id, doctor);
        return "Успешно обнавлен";
    }
}
