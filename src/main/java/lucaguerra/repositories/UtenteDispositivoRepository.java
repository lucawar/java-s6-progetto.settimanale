package lucaguerra.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import lucaguerra.entities.UtenteDispositivo;

@Repository
public interface UtenteDispositivoRepository extends JpaRepository<UtenteDispositivo, UUID> {

}
