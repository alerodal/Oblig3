package koder.oblig3;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;





@Repository
public class KinoRepository  {



    @Autowired
    private JdbcTemplate db;

    public void lagreKino(Kino kunde){
        String sql = "INSERT INTO Kino (Film, Antall, Fornavn, Etternavn, Telefonnr, Epost) VALUES(?, ?, ?, ?, ?, ?);";
        db.update(sql, kunde.getFilm(), kunde.getAntall(), kunde.getFornavn(), kunde.getEtternavn(), kunde.getTelefonnr(), kunde.getEpost());
    }
    public List<Kino> hentKino(){
        String sql = "SELECT * FROM Kino";
        List<Kino> alleKunder = db.query(sql, new BeanPropertyRowMapper(Kino.class));
        return alleKunder;
    }
    public void slettKino(){
        String sql = "DELETE FROM Kino";
        db.update(sql);
    }

}
