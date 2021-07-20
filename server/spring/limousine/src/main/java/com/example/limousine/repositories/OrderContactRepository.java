package com.example.limousine.repositories;

import com.example.limousine.models.OrderContact;
import com.example.limousine.models.OrderContact.OrderContactId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.persistence.Column;
import java.util.Optional;

/**
 * @author dambarpun
 */
public interface OrderContactRepository extends JpaRepository<OrderContact, OrderContactId> {
  /**
   * Find OrderContact by OrderContactId
   *
   * @param companyId
   * @param orderId
   * @param version
   * @param seqNo
   * @return
   */

  @Query("SELECT oc FROM ordercontact oc WHERE oc.companyid = :companyId AND oc.orderid = :orderId AND oc.version = :version AND oc.seqno = :seqNo")
  OrderContact findByOrderContactId(@Param("companyId") String companyId, @Param("orderId") Long orderId, @Param("version") Integer version, @Param("seqNo") String seqNo);

}
