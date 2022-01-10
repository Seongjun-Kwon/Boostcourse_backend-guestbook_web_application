package boostcourse.backend.guestbook.dao;

public class GuestbookDaoSqls {
    public static final String SELECT_ALL = "SELECT id, name, content, regdate FROM guestbook";
    public static final String INSERT_ONE = "INSERT INTO guestbook (name, content, regdate) VALUES (:name, :content, now())";
}
