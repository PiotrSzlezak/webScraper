package pl.ideopolis.webScraperTge.tge.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.ideopolis.webScraperTge.tge.dataModel.RdbSummary;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface RdbSummaryRepository extends JpaRepository<RdbSummary, Long> {

    @Query("SELECT s " +
            "FROM RdbSummary s " +
            "WHERE s.dataDostawy = ?1")
    Optional<RdbSummary> findMatchingEntry(LocalDate dataDostawy);

}
