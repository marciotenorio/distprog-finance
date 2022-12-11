package br.imd.distprog.finance;

import br.imd.distprog.finance.model.BillPayable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BillPayableRepository extends JpaRepository<BillPayable, Long> {
}
