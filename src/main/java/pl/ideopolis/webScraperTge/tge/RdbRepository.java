package pl.ideopolis.webScraperTge.tge;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.ideopolis.webScraperTge.tge.Rdb;

@Repository("RdbRepository")
public interface RdbRepository extends JpaRepository<Rdb, Long> {
}
