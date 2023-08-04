package lucaguerra.entities;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "utenteDispositivo")
@NoArgsConstructor
@Data
public class UtenteDispositivo {

	@Id
	@GeneratedValue
	private UUID id;
	@ManyToOne
	@JoinColumn(name = "dispositivo_id")
	private Dispositivo dispositivo;
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	public UtenteDispositivo(Dispositivo dispositivo, User user) {

		this.dispositivo = dispositivo;
		this.user = user;
	}

}
