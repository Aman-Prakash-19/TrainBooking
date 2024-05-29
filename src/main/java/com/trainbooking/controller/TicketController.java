package com.trainbooking.controller;

import com.trainbooking.model.Ticket;
import com.trainbooking.model.User;
import com.trainbooking.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @PostMapping("/purchaseTicket")
    public Ticket purchaseTicket(@RequestBody User user) {
        return ticketService.purchaseTicket(user);
    }

    @GetMapping("/receipt")
    public Ticket getReceipt(@RequestParam String email) {
        return ticketService.getReceipt(email);
    }

    @GetMapping("/users")
    public List<User> getUsersBySection(@RequestParam String section) {
        return ticketService.getUsersBySection(section);
    }

    @DeleteMapping("/removeUser")
    public void removeUser(@RequestParam String email) {
        ticketService.removeUser(email);
    }

    @PutMapping("/modifySeat")
    public void modifySeat(@RequestParam String email, @RequestParam String newSeat) {
        ticketService.modifySeat(email, newSeat);
    }
}
