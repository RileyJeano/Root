package riley.patrick.Root.repository;

import java.util.Collection;

import org.springframework.data.repository.CrudRepository;

import riley.patrick.Root.model.Drivers;

public interface DriversRepository extends CrudRepository<Drivers, Long> {
	Collection<Drivers> findByDriverName(String driverName);

}
