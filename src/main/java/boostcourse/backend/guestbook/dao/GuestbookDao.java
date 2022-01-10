package boostcourse.backend.guestbook.dao;

import boostcourse.backend.guestbook.dto.Guestbook;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static boostcourse.backend.guestbook.dao.GuestbookDaoSqls.*;

public class GuestbookDao {
    private NamedParameterJdbcTemplate jdbc;

    public GuestbookDao(DataSource dataSource) {
        this.jdbc = new NamedParameterJdbcTemplate(dataSource);
    }

    public List<Guestbook> getGuestbooks() {
        return jdbc.query(SELECT_ALL, new GuestbookMapper());
    }

    public void addGuestbook(Guestbook guestbook) {
        Map<String, Object> params = new HashMap<>();

        params.put("name", guestbook.getName());
        params.put("content", guestbook.getContent());

        jdbc.update(INSERT_ONE, params);
    }

    private class GuestbookMapper implements RowMapper<Guestbook> {
        @Override
        public Guestbook mapRow(ResultSet rs, int rowNum) throws SQLException {
            Guestbook guestbook = new Guestbook();

            guestbook.setId(rs.getLong(1));
            guestbook.setName(rs.getString(2));
            guestbook.setContent(rs.getString(3));
            guestbook.setRegdate(rs.getDate(4));

            return guestbook;
        }
    }
}
