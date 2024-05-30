package software.nipunatheekshana.shoe_shop_management_system.entity;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "refund")
public class RefundEntity {
    @Id
    private String refundId;
    private Timestamp date;
    private Double amount;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "saleDetailsId")
    private SaleDetailsEntity saleDetailsEntity;
}