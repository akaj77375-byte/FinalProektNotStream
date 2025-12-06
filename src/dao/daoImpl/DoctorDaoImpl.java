package dao.daoImpl;

import dao.DoctorDao;
import database.DB;
import database.GenId;
import models.Department;
import models.Doctor;
import models.Hospital;

import java.util.List;

public class DoctorDaoImpl implements DoctorDao {
    @Override
    public Doctor findDoctorById(Long hospitalId, Long id) {
        for (Hospital h:DB.hospitals){
            if (h.getId().equals(hospitalId)){
                for (Doctor d:h.getDoctors()){
                    if (d.getId().equals(id)){
                        return d;
                    }
                }
            }
        }
        return null;
    }

    @Override
    public String assignDoctorToDepartment(Long hospitalId,Long departmentId, List<Long> doctorsId) {
        for (Hospital h:DB.hospitals){
            if (h.getId().equals(hospitalId)){
                for (Department d:h.getDepartments()){
                    if (d.getId().equals(departmentId)){
                        for (Doctor doc:h.getDoctors()){
                            for (Long dokId:doctorsId){
                                if (doc.getId().equals(dokId)){
                                    d.getDoctors().add(doc);
                                }
                            }
                        }
                    }
                }
            }
        }
        return "";
    }

    @Override
    public List<Doctor> getAllDoctorsByHospitalId(Long id) {
        for (Hospital h:DB.hospitals){
            if (h.getId().equals(id)){
                return h.getDoctors();
            }
        }
        return List.of();
    }

    @Override
    public List<Doctor> getAllDoctorsByDepartmentId(Long hospitalId, Long departmentId) {
        for (Hospital h:DB.hospitals){
            if (h.getId().equals(departmentId)){
                for (Department d: h.getDepartments()){
                    if (d.getId().equals(hospitalId)){
                        return d.getDoctors();
                    }
                }

            }
        }
        return List.of();
    }

    @Override
    public String add(Long hospitalId, Doctor doctor) {

        for (Hospital h : DB.hospitals) {
            if (hospitalId.equals(h.getId())) {
                Long newId= GenId.getDoctorId(hospitalId);
                doctor.setId(newId);
                h.getDoctors().add(doctor);
            }
        }

        return "";
    }

    @Override
    public void removeById(Long hospitalId,Long id) {
        for (Hospital h:DB.hospitals){
            if (h.getId().equals(hospitalId)){
                h.getPatients().removeIf(patient -> patient.getId().equals(id));
            }
        }
    }

    @Override
    public String updateById(Long hospital, Long id, Doctor doctor) {
       for (Hospital h:DB.hospitals){
           if (h.getId().equals(id)){
               for (Doctor d:h.getDoctors()){
                   if (d.getId().equals(id)){
                       d.setExperienceYear(doctor.getExperienceYear());
                       d.setFirstName(doctor.getFirstName());
                       d.setLastName(doctor.getLastName());
                       d.setGender(doctor.getGender());
                   }
               }
           }
       }
return "";
    }
}
