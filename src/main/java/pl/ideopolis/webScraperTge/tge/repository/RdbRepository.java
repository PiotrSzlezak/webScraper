package pl.ideopolis.webScraperTge.tge.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.ideopolis.webScraperTge.tge.dataModel.RdbSummary;
import pl.ideopolis.webScraperTge.tge.dataModel.RdbTable;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface RdbRepository extends JpaRepository<RdbTable, Long> {

    @Query("SELECT r " +
            "FROM Rdb r " +
            "WHERE r.dataDostawy = ?1")
    Optional<RdbSummary> findMatchingEntry(LocalDate dataDostawy);

}
