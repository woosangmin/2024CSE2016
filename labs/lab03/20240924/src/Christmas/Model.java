package Christmas;

import java.time.LocalDate;
import java.time.Period;

public class Model {
    Period fromChirstmas() {
        LocalDate today = LocalDate.now();
        LocalDate dDay = LocalDate.of(2024,12,25);
        Period period = Period.between(today, dDay);
        return period;
    }
}
