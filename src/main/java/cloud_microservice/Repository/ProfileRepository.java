package cloud_microservice.Repository;

import cloud_microservice.Model.Profile;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProfileRepository extends JpaRepository<Profile, Integer> {

    boolean existsByEmail(String Email);
    Profile findByEmail (String Email);
}
