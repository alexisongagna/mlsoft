package fr.mlsof.mlsoft.repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;

import fr.mlsof.mlsoft.mapper.PersonneMapper;
import fr.mlsof.mlsoft.model.Personne;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;

public class PersonneJDBCTemplate implements PersonneRepository {
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplateObject;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplateObject = new JdbcTemplate(dataSource);
    }
    public void create(final String nom, final String prenom) {
        String SQL = "insert into PERSONNE (nom, prenom) values (?, ?)";

        jdbcTemplateObject.
                update( SQL, new PreparedStatementSetter() {
                    @Override
                    public void setValues(PreparedStatement ps) throws SQLException {
                        ps.setString(1, nom);
                        ps.setString(2, prenom);
                    }
                });
        System.out.println("Created Record Nom = " + nom + " Prénom = " + prenom);
        return;
    }
    public Personne getPersonne(Integer id) {
        String SQL = "select * from PERSONNE where id = ?";
        Personne person = (Personne)jdbcTemplateObject.queryForObject(SQL,new Object[] { id }, new PersonneMapper());

        return person;
    }
    public List<Personne> listPersonnes() {
        String SQL = "select * from PERSONNE ";
        List <Personne> personnes = jdbcTemplateObject.query(SQL, new PersonneMapper());
        return personnes;
    }
    public void delete(final Integer id) {
        String SQL = "delete from PERSONNE where id = ?";
        jdbcTemplateObject.update( SQL, new PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps) throws SQLException {
                ps.setLong(1, id);
            }
        });
        System.out.println("Deleted Record with ID = " + id );
        return;
    }
    public void update(final Integer id, final String nom){
        String SQL = "update PERSONNE set nom = ? where id = ?";
        jdbcTemplateObject.update( SQL, new PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps) throws SQLException {
                ps.setString(1, nom);
                ps.setLong(2, id);
            }
        });
        System.out.println("Updated Record with ID = " + id );
        return;
    }
}
