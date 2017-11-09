/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.hangmanspring.dao;

import com.sg.hangmanspring.model.Word;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author asmat
 */
public class HangmanDao {

    private static final String SQL_SELECT_WORD_BY_SIZE
            = "select * from words where length(word) = ?";

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Word> getWordBySize(int size) {
        
        List<Word> words = new ArrayList<>();
        
        words = jdbcTemplate.query(SQL_SELECT_WORD_BY_SIZE,
                new WordMapper(),
                size);
        return words;
    }

    private static final class WordMapper implements RowMapper<Word> {

        @Override
        public Word mapRow(ResultSet rs, int i) throws SQLException {
            Word word = new Word();
            word.setWordId(rs.getLong("WordId"));
            word.setWord(rs.getString("Word"));
            return word;
        }
    }

}
