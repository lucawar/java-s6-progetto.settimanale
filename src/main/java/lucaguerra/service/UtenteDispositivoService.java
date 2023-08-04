package lucaguerra.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lucaguerra.entities.Dispositivo;
import lucaguerra.entities.User;
import lucaguerra.entities.UtenteDispositivo;
import lucaguerra.exception.NotFoundException;
import lucaguerra.payload.NewUtenteDispositiviPayload;
import lucaguerra.repositories.UtenteDispositivoRepository;

@Service
public class UtenteDispositivoService {

	@Autowired
	UsersService userServ;

	@Autowired
	DispositivoService dispositivoServ;

	@Autowired
	UtenteDispositivoRepository udRepo;

	public UtenteDispositivo save(NewUtenteDispositiviPayload body) {

		UUID userId = body.getUserId();
		UUID dispositivoId = body.getDispositivoId();

		User user;
		try {
			user = userServ.findById(userId);
		} catch (NotFoundException e) {
			throw new NotFoundException("Utente non trovato con ID: " + userId);
		}

		Dispositivo dispositivo;
		try {
			dispositivo = dispositivoServ.findById(dispositivoId);
		} catch (NotFoundException e) {
			throw new NotFoundException("Dispositivo non trovato con ID: " + dispositivoId);
		}
		UtenteDispositivo newUtenteDispositivo = new UtenteDispositivo(userId, dispositivo, user);
		return udRepo.save(newUtenteDispositivo);
	}

	public List<UtenteDispositivo> getUtenteDispositivo() {
		return udRepo.findAll();
	}

	public UtenteDispositivo findById(UUID id) throws NotFoundException {
		return udRepo.findById(id).orElseThrow(() -> new NotFoundException(id));
	}

	public void findByIdAndDelete(UUID id) throws NotFoundException {
		UtenteDispositivo found = this.findById(id);
		udRepo.delete(found);
	}

}
