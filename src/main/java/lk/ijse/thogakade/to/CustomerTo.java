package lk.ijse.thogakade.to;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name="customer")
public class CustomerTo {
    @Id
    @Column(name="cust_id")
    private String id;

    @Column(nullable = false)
    private String name;

    private String address;

    private double salary;

    @OneToMany(mappedBy = "customerTo")
    private List<OrderTo> orderToList = new ArrayList<>();


}
