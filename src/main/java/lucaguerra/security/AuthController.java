package lucaguerra.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import lucaguerra.entities.User;
import lucaguerra.exception.UnauthorizedException;
import lucaguerra.payload.NewUserPayload;
import lucaguerra.payload.UserLoginPayload;
import lucaguerra.service.UsersService;

@Controller
@RequestMapping("/auth")
public class AuthController {

	@Autowired
	UsersService userService;

	@Autowired
	JWTTools jwtTools;

	@PostMapping("/register")
	@ResponseStatus(HttpStatus.CREATED)
	public User saveUser(@RequestBody NewUserPayload body) {

		User created = userService.save(body);
		return created;
	}

	public ResponseEntity<String> login(@RequestBody UserLoginPayload body) {

		User user = userService.findByEmail(body.getEmail());

		if (body.getPassword().equals(user.getPassword())) {
			String token = jwtTools.createToken(user);
			return new ResponseEntity<>(token, HttpStatus.OK);
		} else {
			throw new UnauthorizedException("Credenziali non valide");
		}
	}
}
