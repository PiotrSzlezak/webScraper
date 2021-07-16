package pl.ideopolis.webScraperTge.tge;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.ideopolis.webScraperTge.tge.dataModel.Rdb;

import java.util.Date;
import java.util.Optional;

@Repository
public interface DataRepository extends JpaRepository<Rdb, Long> {

    @Query("SELECT t" +
            "FROM TgeRdb t" +
            "WHERE (t.dataDostawy = ?1) AND " +
            "(t.poczatekPomiaru = ?2)")
    Optional<Rdb> findMatchingEntry(Date dataDostawy, int poczatekPomiaru);

}
