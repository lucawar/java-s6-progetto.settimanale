package lucaguerra.entities;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lucaguerra.Enum.StatoDispositivo;
import lucaguerra.Enum.TipoDispositivo;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Dispositivo {

	@Id
	@GeneratedValue
	private UUID id;
	@Enumerated(EnumType.STRING)
	private TipoDispositivo tipoDispositivo;
	@Enumerated(EnumType.STRING)
	private StatoDispositivo statoDispositivo;

}
