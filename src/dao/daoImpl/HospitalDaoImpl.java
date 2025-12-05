package dao.daoImpl;

import dao.HospitalDao;
import database.DB;
import models.Hospital;
import models.Patient;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class HospitalDaoImpl implements HospitalDao {

    @Override
    public String addHospital(Hospital hospital) {
        DB.hospitals.add(hospital);
        return "";
    }

    @Override
    public Hospital findHospitalById(Long id) {
        for (Hospital h:DB.hospitals) {
            if (h.getId().equals(id)){
                return h;
            }
        }
        return null;
    }

    @Override
    public List<Hospital> getAllHospital() {
        return DB.hospitals;
    }

    @Override
    public List<Patient> getAllPatientFromHospital(Long id) {
        Hospital patient=findHospitalById(id);

        return patient.getPatients();
    }

    @Override
    public String deleteHospitalById(Long id) {
        DB.hospitals.removeIf(hospital -> hospital.getId().equals(id));

        return "";
    }

    @Override
    public String updateHospital(Long id, Hospital hospital) {
        Hospital hospital1=findHospitalById(id);
        hospital1.setAddress(hospital.getAddress());
        hospital1.setHospitalName(hospital.getHospitalName());
        return "";
    }

    @Override
    public Map<String, Hospital> getAllHospitalByAddress(String address) {
        Map<String,Hospital> result=new LinkedHashMap<>();
        for (Hospital h:DB.hospitals){
            if (h.getAddress().equals(address)){
                result.put(address,h);
            }
        }
        return result;
    }
}
