package lucaguerra.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lucaguerra.entities.Dispositivo;
import lucaguerra.exception.NotFoundException;
import lucaguerra.payload.NewDispositivoPayload;
import lucaguerra.repositories.DispositivoRepository;

@Service
public class DispositivoService {

	@Autowired
	DispositivoRepository dispositivoRepo;

	public Dispositivo save(NewDispositivoPayload body) {

		Dispositivo dispositivo = new Dispositivo(body.getTipoDispositivo(), body.getStatoDispositivo());
		return dispositivoRepo.save(dispositivo);
	}

	public List<Dispositivo> getDispositivo() {
		return dispositivoRepo.findAll();
	}

	public Dispositivo findById(UUID id) throws NotFoundException {
		return dispositivoRepo.findById(id).orElseThrow(() -> new NotFoundException(id));
	}

	public Dispositivo findByIdAndUpdate(UUID id, NewDispositivoPayload body) throws NotFoundException {
		Dispositivo found = this.findById(id);
		found.setTipoDispositivo(body.getTipoDispositivo());
		found.setStatoDispositivo(body.getStatoDispositivo());
		return dispositivoRepo.save(found);
	}

	public void findByIdAndDelete(UUID id) throws NotFoundException {
		Dispositivo found = this.findById(id);
		dispositivoRepo.delete(found);
	}
}
