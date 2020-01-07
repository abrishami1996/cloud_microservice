package cloud_microservice.Repository;

import cloud_microservice.Model.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

public interface ProfileRepository extends JpaRepository<Profile, Integer> {
//    boolean existsByStudentNumber(long studentNumber);
//    boolean existsById(int ID);
//    @Transactional
//    void deleteByStudentNumber(long StudentNumber);
//    @Transactional
//    void deleteById(int Id);
//    Student findById(int fk);

}
