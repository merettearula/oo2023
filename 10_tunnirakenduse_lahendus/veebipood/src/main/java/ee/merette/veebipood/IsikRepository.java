package ee.merette.veebipood;

import org.springframework.data.jpa.repository.JpaRepository;

//JpaRepository annab andmebaasi käsud ToodeREpository sisse
public interface IsikRepository extends JpaRepository<Isik, Integer> {
}