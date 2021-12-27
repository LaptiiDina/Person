package telran.b7a.person.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import telran.b7a.configuration.Constants;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PersonDto {
	Integer id;
	String name;
	@JsonFormat(pattern = "[yyyy-MM-dd]")
	LocalDate birthDate;
	AddressDto address;
}
