package lk.ijse.thogakade.to;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="order")
public class OrderTo {
    @Id
    private String orderId;
    private Date date;
    private String customerId;

    @ManyToOne
    private CustomerTo customerTo = new CustomerTo();

    @OneToMany(mappedBy = "orderTo")
    private List<OrderDetailTo> orderDetailToList = new ArrayList<>();
}
