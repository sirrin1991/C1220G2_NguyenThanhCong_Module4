package com.example.library.controller;

import com.example.library.entity.Book;
import com.example.library.entity.PersonalCode;
import com.example.library.service.BookService;
import com.example.library.service.PersonalCodeService;
import com.example.library.util.NotFoundException;
import com.example.library.util.QuantityException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
public class PersonalCodeController {
    @Autowired
    BookService bookService;

    @Autowired
    PersonalCodeService personalCodeService;

    @GetMapping("/borrow")
    public ModelAndView showListBook() {
        return new ModelAndView("borrow", "books", bookService.findAll());
    }

    @GetMapping("/return")
    public ModelAndView showReturn() {
        return new ModelAndView("return", "personalCode", new PersonalCode());
    }

    @GetMapping("/borrow/{id}/borrow")
    public String borrowBook(@PathVariable Integer id, Model model) throws QuantityException {
        Book book = bookService.findById(id);
        Integer oldQuantity = book.getQuantity();
        if (oldQuantity == 0) {
            throw new QuantityException();
        }
        book.setQuantity(oldQuantity - 1);
        bookService.save(book);
        int code = (int) Math.floor(((Math.random() * 89999) + 10000));
        String codeOfPerson = String.valueOf(code);
        model.addAttribute("abc", codeOfPerson);
        PersonalCode personalCode = new PersonalCode();
        personalCode.setCodeForBook(codeOfPerson);
        personalCode.setBook(book);
        personalCodeService.save(personalCode);
        return "home";
    }

    @ExceptionHandler(QuantityException.class)
    public String showErrorPage() {
        return "error_quantity.html";
    }

    @PostMapping("/return-book")
    public String returnBook(PersonalCode personalCode, Model model) throws NotFoundException {
        PersonalCode pCode = personalCodeService.findByCode(personalCode.getCodeForBook());
        if (pCode == null) {
            throw new NotFoundException();
        }
        Book book = pCode.getBook();
        Integer oldQuantity = book.getQuantity();
        book.setQuantity(oldQuantity + 1);
        bookService.save(book);
        personalCodeService.delete(pCode.getId());
        model.addAttribute("msg", "Cảm ơn và hẹn gặp lại");
        return "home";
    }

    @ExceptionHandler(NotFoundException.class)
    public String showErrPage() {
        return "error_notfound";
    }
}
