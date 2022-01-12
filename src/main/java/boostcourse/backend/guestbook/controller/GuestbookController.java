package boostcourse.backend.guestbook.controller;

import boostcourse.backend.guestbook.dto.Guestbook;
import boostcourse.backend.guestbook.service.GuestbookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/guestbooks")
public class GuestbookController {
    private final GuestbookService guestbookService;

    @Autowired
    public GuestbookController(GuestbookService guestbookService) {
        this.guestbookService = guestbookService;
    }

    @GetMapping
    public String guestbooks(Model model) {
        List<Guestbook> list = guestbookService.getGuestbooks();

        model.addAttribute("list", list);

        return "guestbooks";
    }

    @PostMapping("/write")
    public String addGuestbook(@ModelAttribute("guestbook") Guestbook guestbook, Model model) {
        guestbookService.addGuestbook(guestbook);

        return "redirect:/guestbooks";
    }
}
