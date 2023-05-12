package ee.merette.kodune_harjutamine;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Period;
import java.time.Year;

@RestController
public class StringController {
    @GetMapping("hello-world")
    public String helloWorld() {
        return "Hello world!";
    }
    @GetMapping("/random-arv/{min}/{max}")
    public double randomGenerator(
            @PathVariable int min,
            @PathVariable int max
    ){
        return Math.random() * (max - min) + min;
    }

    @GetMapping("/age/{birthYear}/{birthMonth}")
    public String calculateAge(
            @PathVariable int birthYear,
            @PathVariable @DateTimeFormat(pattern = "MM") int birthMonth
    ) {
        LocalDate currentDate = LocalDate.now();
        LocalDate birthDate = LocalDate.of(birthYear, birthMonth, 1);

        Period period = Period.between(birthDate, currentDate);
        int age = period.getYears();

        boolean hasBirthdayOccurred = hasBirthdayOccurred(birthDate, currentDate);

        if (hasBirthdayOccurred) {
            return "Oled " + age + " aastat vana.";
        } else {
            return "Oled " + (age - 1) + " aastat vana.";
        }
    }

    private boolean hasBirthdayOccurred(LocalDate birthDate, LocalDate currentDate) {
        int currentMonth = currentDate.getMonthValue();
        int currentDay = currentDate.getDayOfMonth();

        int birthMonth = birthDate.getMonthValue();
        int birthDay = birthDate.getDayOfMonth();

        if (birthMonth < currentMonth) {
            return true;
        } else if (birthMonth == currentMonth) {
            if (birthDay <= currentDay) {
                return true;
            }
        }
        return false;
    }
}