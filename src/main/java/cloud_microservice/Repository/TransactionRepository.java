package cloud_microservice.Repository;

import cloud_microservice.Model.Profile;
import cloud_microservice.Model.Transaction;
import cloud_microservice.Model.Wallet;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.swing.*;
import java.util.List;


public interface TransactionRepository extends JpaRepository<Transaction, Integer> {

  List<Transaction> findAllByProfile(Profile profile);

}
