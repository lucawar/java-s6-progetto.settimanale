package lucaguerra.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lucaguerra.entities.UtenteDispositivo;
import lucaguerra.payload.NewUtenteDispositiviPayload;
import lucaguerra.service.UtenteDispositivoService;

@RestController
@RequestMapping("/utenteDispositivo")
public class UtenteDispositivoController {

	@Autowired
	UtenteDispositivoService udServ;

	@PostMapping("")
	public ResponseEntity<UtenteDispositivo> save(@RequestBody NewUtenteDispositiviPayload body) {
		UtenteDispositivo UtenteDispositivo = udServ.save(body);
		return ResponseEntity.status(HttpStatus.CREATED).body(UtenteDispositivo);

	}

	@GetMapping("")
	public List<UtenteDispositivo> getUtenteDispositivo() {
		return udServ.getUtenteDispositivo();
	}

	@GetMapping("/{utenteDispositivo}")
	public UtenteDispositivo findById(@PathVariable UUID utenteDispositivoId) {
		return udServ.findById(utenteDispositivoId);
	}

}
