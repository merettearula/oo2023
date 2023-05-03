package ee.merette.veebipood;

import org.springframework.data.jpa.repository.JpaRepository;

//JpaRepository annab andmebaasi käsud ToodeREpository sisse
public interface TellimusRepository extends JpaRepository<Tellimus, Integer> {
}
