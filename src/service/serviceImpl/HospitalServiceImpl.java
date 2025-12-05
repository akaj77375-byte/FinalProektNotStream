package service.serviceImpl;

import dao.HospitalDao;
import dao.daoImpl.HospitalDaoImpl;
import models.Hospital;
import models.Patient;
import service.HospitalService;

import java.util.List;
import java.util.Map;

public class HospitalServiceImpl implements HospitalService {
HospitalDao hospitalDao=new HospitalDaoImpl();
    @Override
    public String addHospital(Hospital hospital) {
        hospitalDao.addHospital(hospital);
        return "Успешно добавлен";
    }

    @Override
    public Hospital findHospitalById(Long id) {
        hospitalDao.findHospitalById(id);
        return null;
    }

    @Override
    public List<Hospital> getAllHospital() {
        return hospitalDao.getAllHospital();
    }

    @Override
    public List<Patient> getAllPatientFromHospital(Long id) {
        return hospitalDao.getAllPatientFromHospital(id);
    }

    @Override
    public String deleteHospitalById(Long id) {
        hospitalDao.deleteHospitalById(id);
        return "Успешно удален";
    }

    @Override
    public String updateHospital(Long id, Hospital hospital) {
        hospitalDao.updateHospital(id,hospital);
        return "Успешно обнавлен";
    }

    @Override
    public Map<String, Hospital> getAllHospitalByAddress(String address) {
        return hospitalDao.getAllHospitalByAddress(address);
    }


}
