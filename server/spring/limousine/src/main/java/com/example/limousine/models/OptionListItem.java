package com.example.limousine.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.Table;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Table(name = "optionlistitem")
public class OptionListItem {

  @Id
  @Embedded
  public OptionListItemId optionListItemId;

  @Column(name = "typename", nullable = false, length = 100)
  public String typeName;

  @Column(name = "seqno", nullable = false)
  public Integer seqNo;

  @Column(name = "status", nullable = false)
  public Integer status;

  @Embeddable
  public class OptionListItemId implements Serializable {
    public static final long serialVersionUID = 127368712312L;
    @Column(name = "companyid", nullable = false, length = 20)
    public String companyId;

    @Column(name = "category", nullable = false, length = 20)
    public String category;

    @Column(name = "typeid", nullable = false)
    public Integer typeId;
  }

}