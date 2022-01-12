package boostcourse.backend.guestbook.dao;

import boostcourse.backend.guestbook.dto.Guestbook;

import java.util.List;

public interface GuestbookDao {
    List<Guestbook> getGuestbooks();

    void addGuestbook(Guestbook guestbook);
}
