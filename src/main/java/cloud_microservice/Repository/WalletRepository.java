package cloud_microservice.Repository;

import cloud_microservice.Model.Profile;
import cloud_microservice.Model.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;


public interface WalletRepository extends JpaRepository<Wallet, Integer> {

    boolean existsByProfile(Profile profile);
    Wallet findByProfile(Profile profile);
}
