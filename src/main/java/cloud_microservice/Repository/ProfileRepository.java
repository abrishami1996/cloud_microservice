package cloud_microservice.Repository;

import cloud_microservice.Model.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

public interface ProfileRepository extends JpaRepository<Profile, Integer> {

    Profile findByEmail(String email);
    boolean existsByEmail(String email);

}
