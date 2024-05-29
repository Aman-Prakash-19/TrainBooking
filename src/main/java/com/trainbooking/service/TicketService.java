package com.trainbooking.service;

import com.trainbooking.model.Ticket;
import com.trainbooking.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TicketService {
    private final List<Ticket> tickets = new ArrayList<>();
    private final Map<String, List<User>> seatAllocations = new HashMap<>();

    public Ticket purchaseTicket(User user) {
        String from = "London";
        String to = "France";
        double pricePaid = 20.0;
        String seat = allocateSeat();
        Ticket ticket = new Ticket(from, to, user, pricePaid, seat);
        tickets.add(ticket);
        seatAllocations.computeIfAbsent(seat, k -> new ArrayList<>()).add(user);
        return ticket;
    }

    public Ticket getReceipt(String email) {
        return tickets.stream()
                .filter(ticket -> ticket.getUser().getEmail().equals(email))
                .findFirst()
                .orElse(null);
    }

    public List<User> getUsersBySection(String section) {
        return seatAllocations.getOrDefault(section, new ArrayList<>());
    }

    public void removeUser(String email) {
        tickets.removeIf(ticket -> ticket.getUser().getEmail().equals(email));
        seatAllocations.values().forEach(users -> users.removeIf(user -> user.getEmail().equals(email)));
    }

    public void modifySeat(String email, String newSeat) {
        tickets.stream()
                .filter(ticket -> ticket.getUser().getEmail().equals(email))
                .findFirst()
                .ifPresent(ticket -> {
                    String oldSeat = ticket.getSeat();
                    seatAllocations.getOrDefault(oldSeat, new ArrayList<>()).remove(ticket.getUser());
                    ticket.setSeat(newSeat);
                    seatAllocations.computeIfAbsent(newSeat, k -> new ArrayList<>()).add(ticket.getUser());
                });
    }

    private String allocateSeat() {
        return tickets.size() % 2 == 0 ? "A" : "B";
    }
}