import com.example.tickets.IncidentTicket;
import com.example.tickets.TicketService;

import java.util.ArrayList;
import java.util.List;

public class TryIt {

    public static void main(String[] args) {
        TicketService service = new TicketService();

        List<String> tags = new ArrayList<>();
        tags.add("PAYMENT");

        IncidentTicket t1 = service.create(
                "TCK-1001",
                "reporter@example.com",
                "Payment failing on checkout",
                "Checkout page throws error",
                tags
        );

        System.out.println("Created: " + t1);
        IncidentTicket t2 = service.assign(t1, "agent@example.com");
        IncidentTicket t3 = service.escalate(t2);

        System.out.println("\nAfter service updates (new ticket): " + t3);

      
        tags.add("HACKED_FROM_OUTSIDE");
        System.out.println("\nAfter external tag mutation attempt: " + t3);
    }
}
