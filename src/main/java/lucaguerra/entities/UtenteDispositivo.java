package lucaguerra.entities;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "utenteDispositivo")
@NoArgsConstructor
@AllArgsConstructor
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
}
