package pl.ideopolis.webScraperTge.tge;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.ideopolis.webScraperTge.tge.SummaryRdb;

@Repository("SummaryRepository")
public interface SummaryRepository extends JpaRepository<SummaryRdb, Long> {
}
