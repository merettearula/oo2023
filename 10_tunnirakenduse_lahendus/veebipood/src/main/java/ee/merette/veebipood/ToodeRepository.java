package ee.merette.veebipood;

import org.springframework.data.jpa.repository.JpaRepository;

//JpaRepository annab andmebaasi käsud ToodeREpository sisse
public interface ToodeRepository extends JpaRepository<Toode, Integer> {
    Toode findTopByOrder
}
