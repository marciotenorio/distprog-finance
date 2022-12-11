package br.imd.distprog.finance.model;

import br.imd.distprog.finance.util.DBSchema;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "bill_payable", schema = DBSchema.FINANCE)
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class BillPayable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String justification;

    private Long buyOrderId;

    private boolean paid;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        BillPayable that = (BillPayable) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
