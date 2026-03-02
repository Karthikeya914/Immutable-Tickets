package com.example.tickets;

import java.util.List;

public class TicketService {

    public IncidentTicket create(
            String id,
            String reporterEmail,
            String title,
            String description,
            List<String> tags
    ) {
        return new IncidentTicket.Builder()
                .id(id)
                .reporterEmail(reporterEmail)
                .title(title)
                .description(description)
                .tags(tags)
                .build();
    }

    public IncidentTicket assign(IncidentTicket ticket, String assigneeEmail) {
        return ticket.toBuilder()
                .assigneeEmail(assigneeEmail)
                .build();
    }

    public IncidentTicket escalate(IncidentTicket ticket) {
        return ticket.toBuilder()
                .priority("CRITICAL")
                .build();
    }

    public IncidentTicket markCustomerVisible(IncidentTicket ticket) {
        return ticket.toBuilder()
                .customerVisible(true)
                .build();
    }
}
