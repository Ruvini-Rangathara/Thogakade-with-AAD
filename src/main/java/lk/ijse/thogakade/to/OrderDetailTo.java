package lk.ijse.thogakade.to;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="orderDetail")
public class OrderDetailTo {

    @Id
    @ManyToOne
    private ItemTo itemTo = new ItemTo();

    @Id
    @ManyToOne
    private OrderTo orderTo = new OrderTo();

    private int qty;
}

