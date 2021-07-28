package pl.ideopolis.webScraperTge.tge.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.ideopolis.webScraperTge.tge.dataModel.RdbSummary;

@Repository
public interface RdbSummaryRepository extends JpaRepository<RdbSummary, Long> {
}
