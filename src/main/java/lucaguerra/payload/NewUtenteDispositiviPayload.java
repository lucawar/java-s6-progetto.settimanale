package lucaguerra.payload;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@AllArgsConstructor
@ToString
public class NewUtenteDispositiviPayload {

	private UUID userId;
	private UUID dispositivoId;
}
