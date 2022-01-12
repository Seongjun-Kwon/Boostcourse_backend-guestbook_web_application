package boostcourse.backend.guestbook.service;

import boostcourse.backend.guestbook.dao.GuestbookDao;
import boostcourse.backend.guestbook.dto.Guestbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GuestbookServiceImpl implements GuestbookService {
    private final GuestbookDao guestbookDao;

    @Autowired
    public GuestbookServiceImpl(GuestbookDao guestbookDao) {
        this.guestbookDao = guestbookDao;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Guestbook> getGuestbooks() {
        List<Guestbook> list = guestbookDao.getGuestbooks();

        return list;
    }

    @Override
    public void addGuestbook(Guestbook guestbook) {
        guestbookDao.addGuestbook(guestbook);
    }
}
