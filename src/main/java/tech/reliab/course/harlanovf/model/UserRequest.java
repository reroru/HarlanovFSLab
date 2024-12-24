package tech.reliab.course.harlanovf.model;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserRequest {
    private String fullName;
    private LocalDate dateOfBirth;
    private String workplace;
    private double monthlyIncome;
    private int creditScore;
}