package com.example.limousine.models;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

public class BaseModel implements Pageable {

  @Override
  public int getPageNumber() {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public int getPageSize() {
    return 0;
  }

  @Override
  public long getOffset() {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public Sort getSort() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Pageable next() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Pageable previousOrFirst() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Pageable first() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Pageable withPage(int pageNumber) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public boolean hasPrevious() {
    // TODO Auto-generated method stub
    return false;
  }

}