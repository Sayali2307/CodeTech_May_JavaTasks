package codetechtask.level2.task2;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Loan {
    private Item item;
    private LocalDate loanDate;
    private LocalDate returnDate;

    public Loan(Item item) {
        this.item = item;
        this.loanDate = LocalDate.now();
    }

    public long getOverdueDays() {
        if (returnDate == null) {
            return ChronoUnit.DAYS.between(loanDate.plusWeeks(2), LocalDate.now());
        } else {
            return ChronoUnit.DAYS.between(loanDate.plusWeeks(2), returnDate);
        }
    }

    public void returnItem() {
        this.returnDate = LocalDate.now();
    }

    public Item getItem() {
        return item;
    }

    public LocalDate getLoanDate() {
        return loanDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }
}
