/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibraryspring.dao;

import com.sg.dvdlibraryspring.model.Dvd;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author asmat
 */
public class DvdLibraryDaoDbImpl implements DvdLibraryDao{

    private final String SQL_INSERT_DVD = "insert into dvd_list (Title, ReleaseDate, MpaaRating, Director, Studio, Note) " 
                                        + " values (?,?,?,?,?,?) ";
    private final String SQL_DELETE_DVD = "delete from dvd_list "
                                        + " where DvdId = ?";
    private final String SQL_GET_ALL_DVDS = "select * from dvd_list";
    
    private final String SQL_GET_DVD_BY_ID = "select * from dvd_list"
                                        + " where DvdId = ?";
    private final String SQL_GET_DVD_BY_TITLE = "select * from dvd_list"
                                        + " where title = ?";
    
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    
    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public Dvd addDvd(Dvd dvd) {
        jdbcTemplate.update(SQL_INSERT_DVD, 
                            dvd.getTitle(),
                            dvd.getReleaseDate().toString(),
                            dvd.getMpaaRating(),
                            dvd.getDirector(),
                            dvd.getStudio(),
                            dvd.getNote());
        dvd.setDvdId(jdbcTemplate.queryForObject("select LAST_INSERT_ID()", Integer.class));
        return dvd;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public Dvd removeDvd(String title) {
        Dvd dvd = jdbcTemplate.queryForObject(SQL_GET_DVD_BY_TITLE, new DvdMapper(), title);
        jdbcTemplate.update(SQL_DELETE_DVD, dvd.getDvdId());
        
        return null;
    }

    @Override
    public List<Dvd> getAllDvds() {
        return jdbcTemplate.query(SQL_GET_ALL_DVDS, new DvdMapper());
    }

    @Override
    public Dvd getDvdById(int id) {
        Dvd dvd = jdbcTemplate.queryForObject(SQL_GET_DVD_BY_ID, new DvdMapper(), id);
        return dvd;
    }

    private static class DvdMapper implements RowMapper<Dvd>{

        @Override
        public Dvd mapRow(ResultSet rs, int i) throws SQLException {
            Dvd dvd = new Dvd();
            dvd.setDvdId(rs.getInt("DvdId"));
            dvd.setTitle(rs.getString("Title"));
            dvd.setReleaseDate(rs.getTimestamp("ReleaseDate").toLocalDateTime().toLocalDate());
            dvd.setMpaaRating(rs.getString("MpaaRating"));
            dvd.setDirector(rs.getString("Director"));
            dvd.setStudio(rs.getString("Studio"));
            dvd.setNote(rs.getString("Note"));
            return dvd;
        }
    }
}
