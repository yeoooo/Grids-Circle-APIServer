// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: ProductService.proto

package com.example.gccoffee;

public interface FindAllProductResponseOrBuilder extends
    // @@protoc_insertion_point(interface_extends:FindAllProductResponse)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>repeated .ProductMessage product = 1;</code>
   */
  java.util.List<com.example.gccoffee.ProductMessage> 
      getProductList();
  /**
   * <code>repeated .ProductMessage product = 1;</code>
   */
  com.example.gccoffee.ProductMessage getProduct(int index);
  /**
   * <code>repeated .ProductMessage product = 1;</code>
   */
  int getProductCount();
  /**
   * <code>repeated .ProductMessage product = 1;</code>
   */
  java.util.List<? extends com.example.gccoffee.ProductMessageOrBuilder> 
      getProductOrBuilderList();
  /**
   * <code>repeated .ProductMessage product = 1;</code>
   */
  com.example.gccoffee.ProductMessageOrBuilder getProductOrBuilder(
      int index);
}