package lucaguerra.payload;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lucaguerra.Enum.StatoDispositivo;
import lucaguerra.Enum.TipoDispositivo;

@Getter
@Setter
@AllArgsConstructor
public class NewDispositivoPayload {

	@Enumerated(EnumType.STRING)
	private TipoDispositivo tipoDispositivo;
	@Enumerated(EnumType.STRING)
	private StatoDispositivo statoDispositivo;
}
