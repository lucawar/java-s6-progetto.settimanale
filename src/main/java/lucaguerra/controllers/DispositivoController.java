package lucaguerra.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lucaguerra.entities.Dispositivo;
import lucaguerra.payload.NewDispositivoPayload;
import lucaguerra.service.DispositivoService;

@RestController
@RequestMapping("/dispositivo")
public class DispositivoController {

	@Autowired
	DispositivoService dispositivoServ;

	@PostMapping("")
	@ResponseStatus(HttpStatus.CREATED)
	public Dispositivo saveDispositivo(@RequestBody lucaguerra.payload.NewDispositivoPayload body) {
		Dispositivo createdDispositivo = dispositivoServ.save(body);
		return createdDispositivo;
	}

	@GetMapping("")
	public List<Dispositivo> getDispositivo() {
		return dispositivoServ.getDispositivo();
	}

	@GetMapping("/{dispositivoId}")
	public Dispositivo findById(@PathVariable UUID dispositivoId) {
		return dispositivoServ.findById(dispositivoId);
	}

	@PutMapping("/{dispositivoId}")
	public Dispositivo updateDispositivo(@PathVariable UUID dispositivoId, @RequestBody NewDispositivoPayload body) {
		return dispositivoServ.findByIdAndUpdate(dispositivoId, body);
	}

	@DeleteMapping("/{dispositivoId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteDispositivo(@PathVariable UUID dispositivoId) {
		dispositivoServ.findByIdAndDelete(dispositivoId);
	}
}
