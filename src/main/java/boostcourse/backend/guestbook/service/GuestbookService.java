package boostcourse.backend.guestbook.service;

import boostcourse.backend.guestbook.dto.Guestbook;

import java.util.List;

public interface GuestbookService {
    List<Guestbook> getGuestbooks();

    void addGuestbook(Guestbook guestbook);
}
