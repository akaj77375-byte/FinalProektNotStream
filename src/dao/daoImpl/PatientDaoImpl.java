package dao.daoImpl;

import dao.PatientDao;
import database.DB;
import database.GenId;
import models.Hospital;
import models.Patient;

import java.util.*;

public class PatientDaoImpl implements PatientDao {
    @Override
    public String addPatientsToHospital(Long id, List<Patient> patients) {
        for (Hospital h: DB.hospitals){
            if (h.getId().equals(id)){
                for (Patient p:patients){
                    Long newId= GenId.getPatientId(GenId.getHospitalId());
                    p.setId(newId);
                    h.getPatients().add(p);
                }
            }
        }
        return "";
    }

    @Override
    public Patient getPatientById(Long hospitalId, Long id) {
        for (Hospital h: DB.hospitals){
            if (h.getId().equals(hospitalId)){
                for (Patient p:h.getPatients()){
                    if (p.getId().equals(id)){
                        return p;
                    }
                }
            }
        }
        return null;
    }

    @Override
    public Map<Integer, Patient> getPatientByAge(Long hospitalId, Integer age) {
Map<Integer,Patient>patientMap=new LinkedHashMap<>();
for (Hospital h: DB.hospitals){
    if (h.getId().equals(hospitalId)){
        for(Patient p:h.getPatients()){
            if (p.getAge()==age){
                patientMap.put(age,p);
            }
        }
    }
}

return patientMap;

    }

    @Override
    public List<Patient> sortPatientsByAge(Long hospitalId, String ascOrDesc) {
        if (ascOrDesc.equalsIgnoreCase("asc")){
            for (Hospital h:DB.hospitals){
                if (h.getId().equals(hospitalId)){
                    h.getPatients().sort(Comparator.comparing(Patient::getAge));
                }
            }
        }
        return List.of();
    }

    @Override
    public String add(Long hospitalId, Patient patient) {
       for (Hospital h:DB.hospitals){
           if (h.getId().equals(hospitalId)){
               Long newId=GenId.getPatientId(hospitalId);
               patient.setId(newId);
               h.getPatients().add(patient);
           }
       }
        return "";
    }

    @Override
    public void removeById(Long hospital,Long id) {
for (Hospital h:DB.hospitals){
    if (h.getId().equals(hospital)){
        h.getPatients().removeIf(patient -> patient.getId().equals(id));
    }
}
    }

    @Override
    public String updateById(Long hospital, Long id, Patient patient) {
        for (Hospital h:DB.hospitals){
            if (h.getId().equals(hospital)){
                for (Patient p:h.getPatients()){
                    if (p.getId().equals(id)){
                        p.setAge(patient.getAge());
                        p.setFirstName(patient.getFirstName());
                        p.setLastName(patient.getLastName());
                    }
                }
            }
        }
        return "";
    }
}
