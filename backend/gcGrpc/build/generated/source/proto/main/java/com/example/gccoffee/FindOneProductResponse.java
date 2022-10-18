// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: ProductService.proto

package com.example.gccoffee;

/**
 * Protobuf type {@code FindOneProductResponse}
 */
public final class FindOneProductResponse extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:FindOneProductResponse)
    FindOneProductResponseOrBuilder {
private static final long serialVersionUID = 0L;
  // Use FindOneProductResponse.newBuilder() to construct.
  private FindOneProductResponse(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private FindOneProductResponse() {
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new FindOneProductResponse();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return com.example.gccoffee.ProductService.internal_static_FindOneProductResponse_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.example.gccoffee.ProductService.internal_static_FindOneProductResponse_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.example.gccoffee.FindOneProductResponse.class, com.example.gccoffee.FindOneProductResponse.Builder.class);
  }

  public static final int PRODUCT_FIELD_NUMBER = 1;
  private com.example.gccoffee.ProductMessage product_;
  /**
   * <code>.ProductMessage product = 1;</code>
   * @return Whether the product field is set.
   */
  @java.lang.Override
  public boolean hasProduct() {
    return product_ != null;
  }
  /**
   * <code>.ProductMessage product = 1;</code>
   * @return The product.
   */
  @java.lang.Override
  public com.example.gccoffee.ProductMessage getProduct() {
    return product_ == null ? com.example.gccoffee.ProductMessage.getDefaultInstance() : product_;
  }
  /**
   * <code>.ProductMessage product = 1;</code>
   */
  @java.lang.Override
  public com.example.gccoffee.ProductMessageOrBuilder getProductOrBuilder() {
    return getProduct();
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (product_ != null) {
      output.writeMessage(1, getProduct());
    }
    getUnknownFields().writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (product_ != null) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(1, getProduct());
    }
    size += getUnknownFields().getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof com.example.gccoffee.FindOneProductResponse)) {
      return super.equals(obj);
    }
    com.example.gccoffee.FindOneProductResponse other = (com.example.gccoffee.FindOneProductResponse) obj;

    if (hasProduct() != other.hasProduct()) return false;
    if (hasProduct()) {
      if (!getProduct()
          .equals(other.getProduct())) return false;
    }
    if (!getUnknownFields().equals(other.getUnknownFields())) return false;
    return true;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    if (hasProduct()) {
      hash = (37 * hash) + PRODUCT_FIELD_NUMBER;
      hash = (53 * hash) + getProduct().hashCode();
    }
    hash = (29 * hash) + getUnknownFields().hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.example.gccoffee.FindOneProductResponse parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.example.gccoffee.FindOneProductResponse parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.example.gccoffee.FindOneProductResponse parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.example.gccoffee.FindOneProductResponse parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.example.gccoffee.FindOneProductResponse parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.example.gccoffee.FindOneProductResponse parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.example.gccoffee.FindOneProductResponse parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.example.gccoffee.FindOneProductResponse parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.example.gccoffee.FindOneProductResponse parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.example.gccoffee.FindOneProductResponse parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.example.gccoffee.FindOneProductResponse parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.example.gccoffee.FindOneProductResponse parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(com.example.gccoffee.FindOneProductResponse prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code FindOneProductResponse}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:FindOneProductResponse)
      com.example.gccoffee.FindOneProductResponseOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.example.gccoffee.ProductService.internal_static_FindOneProductResponse_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.example.gccoffee.ProductService.internal_static_FindOneProductResponse_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.example.gccoffee.FindOneProductResponse.class, com.example.gccoffee.FindOneProductResponse.Builder.class);
    }

    // Construct using com.example.gccoffee.FindOneProductResponse.newBuilder()
    private Builder() {

    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);

    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      if (productBuilder_ == null) {
        product_ = null;
      } else {
        product_ = null;
        productBuilder_ = null;
      }
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.example.gccoffee.ProductService.internal_static_FindOneProductResponse_descriptor;
    }

    @java.lang.Override
    public com.example.gccoffee.FindOneProductResponse getDefaultInstanceForType() {
      return com.example.gccoffee.FindOneProductResponse.getDefaultInstance();
    }

    @java.lang.Override
    public com.example.gccoffee.FindOneProductResponse build() {
      com.example.gccoffee.FindOneProductResponse result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public com.example.gccoffee.FindOneProductResponse buildPartial() {
      com.example.gccoffee.FindOneProductResponse result = new com.example.gccoffee.FindOneProductResponse(this);
      if (productBuilder_ == null) {
        result.product_ = product_;
      } else {
        result.product_ = productBuilder_.build();
      }
      onBuilt();
      return result;
    }

    @java.lang.Override
    public Builder clone() {
      return super.clone();
    }
    @java.lang.Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.setField(field, value);
    }
    @java.lang.Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return super.clearField(field);
    }
    @java.lang.Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return super.clearOneof(oneof);
    }
    @java.lang.Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return super.setRepeatedField(field, index, value);
    }
    @java.lang.Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.addRepeatedField(field, value);
    }
    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof com.example.gccoffee.FindOneProductResponse) {
        return mergeFrom((com.example.gccoffee.FindOneProductResponse)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.example.gccoffee.FindOneProductResponse other) {
      if (other == com.example.gccoffee.FindOneProductResponse.getDefaultInstance()) return this;
      if (other.hasProduct()) {
        mergeProduct(other.getProduct());
      }
      this.mergeUnknownFields(other.getUnknownFields());
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      if (extensionRegistry == null) {
        throw new java.lang.NullPointerException();
      }
      try {
        boolean done = false;
        while (!done) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              done = true;
              break;
            case 10: {
              input.readMessage(
                  getProductFieldBuilder().getBuilder(),
                  extensionRegistry);

              break;
            } // case 10
            default: {
              if (!super.parseUnknownField(input, extensionRegistry, tag)) {
                done = true; // was an endgroup tag
              }
              break;
            } // default:
          } // switch (tag)
        } // while (!done)
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.unwrapIOException();
      } finally {
        onChanged();
      } // finally
      return this;
    }

    private com.example.gccoffee.ProductMessage product_;
    private com.google.protobuf.SingleFieldBuilderV3<
        com.example.gccoffee.ProductMessage, com.example.gccoffee.ProductMessage.Builder, com.example.gccoffee.ProductMessageOrBuilder> productBuilder_;
    /**
     * <code>.ProductMessage product = 1;</code>
     * @return Whether the product field is set.
     */
    public boolean hasProduct() {
      return productBuilder_ != null || product_ != null;
    }
    /**
     * <code>.ProductMessage product = 1;</code>
     * @return The product.
     */
    public com.example.gccoffee.ProductMessage getProduct() {
      if (productBuilder_ == null) {
        return product_ == null ? com.example.gccoffee.ProductMessage.getDefaultInstance() : product_;
      } else {
        return productBuilder_.getMessage();
      }
    }
    /**
     * <code>.ProductMessage product = 1;</code>
     */
    public Builder setProduct(com.example.gccoffee.ProductMessage value) {
      if (productBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        product_ = value;
        onChanged();
      } else {
        productBuilder_.setMessage(value);
      }

      return this;
    }
    /**
     * <code>.ProductMessage product = 1;</code>
     */
    public Builder setProduct(
        com.example.gccoffee.ProductMessage.Builder builderForValue) {
      if (productBuilder_ == null) {
        product_ = builderForValue.build();
        onChanged();
      } else {
        productBuilder_.setMessage(builderForValue.build());
      }

      return this;
    }
    /**
     * <code>.ProductMessage product = 1;</code>
     */
    public Builder mergeProduct(com.example.gccoffee.ProductMessage value) {
      if (productBuilder_ == null) {
        if (product_ != null) {
          product_ =
            com.example.gccoffee.ProductMessage.newBuilder(product_).mergeFrom(value).buildPartial();
        } else {
          product_ = value;
        }
        onChanged();
      } else {
        productBuilder_.mergeFrom(value);
      }

      return this;
    }
    /**
     * <code>.ProductMessage product = 1;</code>
     */
    public Builder clearProduct() {
      if (productBuilder_ == null) {
        product_ = null;
        onChanged();
      } else {
        product_ = null;
        productBuilder_ = null;
      }

      return this;
    }
    /**
     * <code>.ProductMessage product = 1;</code>
     */
    public com.example.gccoffee.ProductMessage.Builder getProductBuilder() {
      
      onChanged();
      return getProductFieldBuilder().getBuilder();
    }
    /**
     * <code>.ProductMessage product = 1;</code>
     */
    public com.example.gccoffee.ProductMessageOrBuilder getProductOrBuilder() {
      if (productBuilder_ != null) {
        return productBuilder_.getMessageOrBuilder();
      } else {
        return product_ == null ?
            com.example.gccoffee.ProductMessage.getDefaultInstance() : product_;
      }
    }
    /**
     * <code>.ProductMessage product = 1;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        com.example.gccoffee.ProductMessage, com.example.gccoffee.ProductMessage.Builder, com.example.gccoffee.ProductMessageOrBuilder> 
        getProductFieldBuilder() {
      if (productBuilder_ == null) {
        productBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            com.example.gccoffee.ProductMessage, com.example.gccoffee.ProductMessage.Builder, com.example.gccoffee.ProductMessageOrBuilder>(
                getProduct(),
                getParentForChildren(),
                isClean());
        product_ = null;
      }
      return productBuilder_;
    }
    @java.lang.Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFields(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:FindOneProductResponse)
  }

  // @@protoc_insertion_point(class_scope:FindOneProductResponse)
  private static final com.example.gccoffee.FindOneProductResponse DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.example.gccoffee.FindOneProductResponse();
  }

  public static com.example.gccoffee.FindOneProductResponse getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<FindOneProductResponse>
      PARSER = new com.google.protobuf.AbstractParser<FindOneProductResponse>() {
    @java.lang.Override
    public FindOneProductResponse parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      Builder builder = newBuilder();
      try {
        builder.mergeFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.setUnfinishedMessage(builder.buildPartial());
      } catch (com.google.protobuf.UninitializedMessageException e) {
        throw e.asInvalidProtocolBufferException().setUnfinishedMessage(builder.buildPartial());
      } catch (java.io.IOException e) {
        throw new com.google.protobuf.InvalidProtocolBufferException(e)
            .setUnfinishedMessage(builder.buildPartial());
      }
      return builder.buildPartial();
    }
  };

  public static com.google.protobuf.Parser<FindOneProductResponse> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<FindOneProductResponse> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public com.example.gccoffee.FindOneProductResponse getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

