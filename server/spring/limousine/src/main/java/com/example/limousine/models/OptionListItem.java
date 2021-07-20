package com.example.limousine.models;

import lombok.Data;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.Table;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author dambarpun
 */
@Entity
@Table(name = "optionlistitem")
@Data
public class OptionListItem {

  @Id
  @Embedded
  private OptionListItemId optionListItemId;

  @Column(name = "typename", nullable = false, length = 100)
  private String typeName;

  @Column(name = "seqno", nullable = false)
  private Integer seqNo;

  @Column(name = "status", nullable = false)
  private Integer status;

  @Embeddable
  @Data
  public class OptionListItemId implements Serializable {
    public static final long serialVersionUID = 127368712312L;

    public OptionListItemId(String companyId, String category, Integer typeId) {
      this.companyId = companyId;
      this.category = category;
      this.typeId = typeId;
    }

    @Column(name = "companyid", nullable = false, length = 20)
    private String companyId;

    @Column(name = "category", nullable = false, length = 20)
    private String category;

    @Column(name = "typeid", nullable = false)
    private Integer typeId;
  }

}