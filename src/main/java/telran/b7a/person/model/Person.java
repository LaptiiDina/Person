package telran.b7a.person.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@EqualsAndHashCode(of= {"id"})
@Entity// javax.persistence.Id
@Table(name = "persons")//если не нравиться чтоб таблица была названа как класс
public class Person implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4478261898905305126L;//Serial... не обязательно, но при передачи с 1 аппликации в другую нужен этот интерфейс(на всякий случай)
	@Id// javax.persistence.Id
Integer id;
String name;
LocalDate birthDate;
//@Embedded

Address address;
}
