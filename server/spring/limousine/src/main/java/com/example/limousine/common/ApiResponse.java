package com.example.limousine.common;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResponse<T> {
  private String error;
  private T data;
  private String status;

  private ApiResponse(String error, T data, String status) {
    this.error = error;
    this.data = data;
    this.status = status;
  }

  public void setError(String error) {
    this.error = error;
  }

  public void setData(T data) {
    this.data = data;
  }

  public void setState(String status) {
    this.status = status;
  }

  public String getError() {
    return this.error;
  }

  public T getData() {
    return this.data;
  }

  public String getStatus() {
    return this.status;
  }

  // public static ApiResponse<Object> statusOK() {
  // return new ApiResponse<Object>(null, null, "ok");
  // }
  // public static ApiResponse<Object> error(String error) {
  // return new ApiResponse<Object>(error, null, null);
  // }
  //
  // public ApiResponse(T data) {
  // this.data = data;
  // }

  public static class Builder<E> {
    private String error;
    private E data;
    private String status;

    public Builder<E> withError(String error) {
      this.error = error;
      return this;
    }

    public Builder<E> withStatusOk() {
      this.status = "ok";
      return this;
    }

    public Builder<E> withData(E data) {
      this.data = data;
      return this;
    }

    public ApiResponse<E> build() {
      return new ApiResponse<E>(this.error, this.data, this.status);
    }
  }

}
