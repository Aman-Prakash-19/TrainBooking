package com.trainbooking.service;

import com.trainbooking.model.Ticket;
import com.trainbooking.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TicketServiceTest {
    private TicketService ticketService;

    @BeforeEach
    void setUp() {
        ticketService = new TicketService();
    }

    @Test
    void testPurchaseTicket() {
        User user = new User("John", "Doe", "john.doe@example.com");
        Ticket ticket = ticketService.purchaseTicket(user);

        assertNotNull(ticket);
        assertEquals("London", ticket.getFrom());
        assertEquals("France", ticket.getTo());
        assertEquals(20.0, ticket.getPricePaid());
        assertEquals(user, ticket.getUser());
    }

    @Test
    void testGetReceipt() {
        User user = new User("Jane", "Doe", "jane.doe@example.com");
        ticketService.purchaseTicket(user);
        Ticket receipt = ticketService.getReceipt(user.getEmail());

        assertNotNull(receipt);
        assertEquals(user, receipt.getUser());
    }

    @Test
    void testGetUsersBySection() {
        User user1 = new User("Alice", "Smith", "alice.smith@example.com");
        User user2 = new User("Bob", "Brown", "bob.brown@example.com");
        ticketService.purchaseTicket(user1);
        ticketService.purchaseTicket(user2);

        List<User> sectionAUsers = ticketService.getUsersBySection("A");
        List<User> sectionBUsers = ticketService.getUsersBySection("B");

        assertEquals(1, sectionAUsers.size());
        assertEquals(1, sectionBUsers.size());
    }

    @Test
    void testRemoveUser() {
        User user = new User("Charlie", "Clark", "charlie.clark@example.com");
        ticketService.purchaseTicket(user);
        ticketService.removeUser(user.getEmail());

        assertNull(ticketService.getReceipt(user.getEmail()));
    }

    @Test
    void testModifySeat() {
        User user = new User("Diana", "Prince", "diana.prince@example.com");
        ticketService.purchaseTicket(user);
        ticketService.modifySeat(user.getEmail(), "B");

        Ticket ticket = ticketService.getReceipt(user.getEmail());
        assertEquals("B", ticket.getSeat());
    }
}