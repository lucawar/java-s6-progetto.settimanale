package lucaguerra;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.github.javafaker.Faker;

import lucaguerra.Enum.StatoDispositivo;
import lucaguerra.Enum.TipoDispositivo;
import lucaguerra.payload.NewDispositivoPayload;
import lucaguerra.payload.NewUserPayload;
import lucaguerra.service.DispositivoService;
import lucaguerra.service.UsersService;

@Component
public class Runner implements CommandLineRunner {

	@Autowired
	UsersService userService;

	@Autowired
	DispositivoService dispSrv;

	@Override
	public void run(String... args) throws Exception {

		Faker faker = new Faker(new Locale("it"));

		for (int i = 0; i < 10; i++) {
			String username = faker.funnyName().name();
			String name = faker.name().firstName();
			String surname = faker.name().lastName();
			String email = faker.internet().emailAddress();
			String password = "1234";
			NewUserPayload user = new NewUserPayload(username, name, surname, email, password);
			// userService.save(user);
		}

		for (int i = 0; i < 10; i++) {
			TipoDispositivo tipo = TipoDispositivo.COMPUTER;
			StatoDispositivo stato = StatoDispositivo.ASSEGNATO;
			NewDispositivoPayload dispositivo = new NewDispositivoPayload(tipo, stato);
			// dispSrv.save(dispositivo);
		}
	}

}
