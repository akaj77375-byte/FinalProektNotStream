package service.serviceImpl;

import dao.PatientDao;
import dao.daoImpl.PatientDaoImpl;
import models.Patient;
import service.PatientService;

import java.util.List;
import java.util.Map;

public class PatientServiceImpl implements PatientService {
PatientDao patientDao=new PatientDaoImpl();
    @Override
    public String addPatientsToHospital(Long id, List<Patient> patients) {
        patientDao.addPatientsToHospital(id,patients);
        return "Успешно добавлен";
    }

    @Override
    public Patient getPatientById(Long hospitalId, Long id) {

        return  patientDao.getPatientById(hospitalId,id);
    }

    @Override
    public Map<Integer, Patient> getPatientByAge(Long hospitalId, Integer age) {
        return patientDao.getPatientByAge(hospitalId,age);
    }

    @Override
    public List<Patient> sortPatientsByAge(Long hospitalId, String ascOrDesc) {
        return patientDao.sortPatientsByAge(hospitalId,ascOrDesc);
    }
}
