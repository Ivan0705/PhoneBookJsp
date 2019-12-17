package ru.academits.servlet;

import ru.academits.PhoneBook;
import ru.academits.service.ContactService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteContactServlet extends HttpServlet {
    private ContactService contactService = PhoneBook.contactService;

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String stringId = req.getParameter("id");
        if (stringId != null) {
            int id = Integer.parseInt(stringId);
            contactService.deleteContact(id);
            resp.setStatus(200);
        }
        resp.sendRedirect("/phonebook");
    }

}
