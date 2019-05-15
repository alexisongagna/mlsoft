package fr.mlsof.mlsoft.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import fr.mlsof.mlsoft.model.Personne;
import org.springframework.jdbc.core.RowMapper;

public class PersonneMapper implements RowMapper{
    public Personne mapRow(ResultSet rs, int rowNum) throws SQLException {
        Personne person = new Personne();
        person.setId(rs.getInt("id"));
        person.setNom(rs.getString("nom"));
        person.setPrenom(rs.getString("prenom"));

        return person;
    }
}