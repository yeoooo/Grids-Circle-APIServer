// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: ProductService.proto

package com.example.gccoffee;

/**
 * Protobuf type {@code FindAllProductResponse}
 */
public final class FindAllProductResponse extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:FindAllProductResponse)
    FindAllProductResponseOrBuilder {
private static final long serialVersionUID = 0L;
  // Use FindAllProductResponse.newBuilder() to construct.
  private FindAllProductResponse(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private FindAllProductResponse() {
    product_ = java.util.Collections.emptyList();
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new FindAllProductResponse();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return com.example.gccoffee.ProductService.internal_static_FindAllProductResponse_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.example.gccoffee.ProductService.internal_static_FindAllProductResponse_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.example.gccoffee.FindAllProductResponse.class, com.example.gccoffee.FindAllProductResponse.Builder.class);
  }

  public static final int PRODUCT_FIELD_NUMBER = 1;
  private java.util.List<com.example.gccoffee.ProductMessage> product_;
  /**
   * <code>repeated .ProductMessage product = 1;</code>
   */
  @java.lang.Override
  public java.util.List<com.example.gccoffee.ProductMessage> getProductList() {
    return product_;
  }
  /**
   * <code>repeated .ProductMessage product = 1;</code>
   */
  @java.lang.Override
  public java.util.List<? extends com.example.gccoffee.ProductMessageOrBuilder> 
      getProductOrBuilderList() {
    return product_;
  }
  /**
   * <code>repeated .ProductMessage product = 1;</code>
   */
  @java.lang.Override
  public int getProductCount() {
    return product_.size();
  }
  /**
   * <code>repeated .ProductMessage product = 1;</code>
   */
  @java.lang.Override
  public com.example.gccoffee.ProductMessage getProduct(int index) {
    return product_.get(index);
  }
  /**
   * <code>repeated .ProductMessage product = 1;</code>
   */
  @java.lang.Override
  public com.example.gccoffee.ProductMessageOrBuilder getProductOrBuilder(
      int index) {
    return product_.get(index);
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
    for (int i = 0; i < product_.size(); i++) {
      output.writeMessage(1, product_.get(i));
    }
    getUnknownFields().writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    for (int i = 0; i < product_.size(); i++) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(1, product_.get(i));
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
    if (!(obj instanceof com.example.gccoffee.FindAllProductResponse)) {
      return super.equals(obj);
    }
    com.example.gccoffee.FindAllProductResponse other = (com.example.gccoffee.FindAllProductResponse) obj;

    if (!getProductList()
        .equals(other.getProductList())) return false;
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
    if (getProductCount() > 0) {
      hash = (37 * hash) + PRODUCT_FIELD_NUMBER;
      hash = (53 * hash) + getProductList().hashCode();
    }
    hash = (29 * hash) + getUnknownFields().hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.example.gccoffee.FindAllProductResponse parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.example.gccoffee.FindAllProductResponse parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.example.gccoffee.FindAllProductResponse parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.example.gccoffee.FindAllProductResponse parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.example.gccoffee.FindAllProductResponse parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.example.gccoffee.FindAllProductResponse parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.example.gccoffee.FindAllProductResponse parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.example.gccoffee.FindAllProductResponse parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.example.gccoffee.FindAllProductResponse parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.example.gccoffee.FindAllProductResponse parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.example.gccoffee.FindAllProductResponse parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.example.gccoffee.FindAllProductResponse parseFrom(
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
  public static Builder newBuilder(com.example.gccoffee.FindAllProductResponse prototype) {
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
   * Protobuf type {@code FindAllProductResponse}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:FindAllProductResponse)
      com.example.gccoffee.FindAllProductResponseOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.example.gccoffee.ProductService.internal_static_FindAllProductResponse_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.example.gccoffee.ProductService.internal_static_FindAllProductResponse_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.example.gccoffee.FindAllProductResponse.class, com.example.gccoffee.FindAllProductResponse.Builder.class);
    }

    // Construct using com.example.gccoffee.FindAllProductResponse.newBuilder()
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
        product_ = java.util.Collections.emptyList();
      } else {
        product_ = null;
        productBuilder_.clear();
      }
      bitField0_ = (bitField0_ & ~0x00000001);
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.example.gccoffee.ProductService.internal_static_FindAllProductResponse_descriptor;
    }

    @java.lang.Override
    public com.example.gccoffee.FindAllProductResponse getDefaultInstanceForType() {
      return com.example.gccoffee.FindAllProductResponse.getDefaultInstance();
    }

    @java.lang.Override
    public com.example.gccoffee.FindAllProductResponse build() {
      com.example.gccoffee.FindAllProductResponse result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public com.example.gccoffee.FindAllProductResponse buildPartial() {
      com.example.gccoffee.FindAllProductResponse result = new com.example.gccoffee.FindAllProductResponse(this);
      int from_bitField0_ = bitField0_;
      if (productBuilder_ == null) {
        if (((bitField0_ & 0x00000001) != 0)) {
          product_ = java.util.Collections.unmodifiableList(product_);
          bitField0_ = (bitField0_ & ~0x00000001);
        }
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
      if (other instanceof com.example.gccoffee.FindAllProductResponse) {
        return mergeFrom((com.example.gccoffee.FindAllProductResponse)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.example.gccoffee.FindAllProductResponse other) {
      if (other == com.example.gccoffee.FindAllProductResponse.getDefaultInstance()) return this;
      if (productBuilder_ == null) {
        if (!other.product_.isEmpty()) {
          if (product_.isEmpty()) {
            product_ = other.product_;
            bitField0_ = (bitField0_ & ~0x00000001);
          } else {
            ensureProductIsMutable();
            product_.addAll(other.product_);
          }
          onChanged();
        }
      } else {
        if (!other.product_.isEmpty()) {
          if (productBuilder_.isEmpty()) {
            productBuilder_.dispose();
            productBuilder_ = null;
            product_ = other.product_;
            bitField0_ = (bitField0_ & ~0x00000001);
            productBuilder_ = 
              com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders ?
                 getProductFieldBuilder() : null;
          } else {
            productBuilder_.addAllMessages(other.product_);
          }
        }
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
              com.example.gccoffee.ProductMessage m =
                  input.readMessage(
                      com.example.gccoffee.ProductMessage.parser(),
                      extensionRegistry);
              if (productBuilder_ == null) {
                ensureProductIsMutable();
                product_.add(m);
              } else {
                productBuilder_.addMessage(m);
              }
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
    private int bitField0_;

    private java.util.List<com.example.gccoffee.ProductMessage> product_ =
      java.util.Collections.emptyList();
    private void ensureProductIsMutable() {
      if (!((bitField0_ & 0x00000001) != 0)) {
        product_ = new java.util.ArrayList<com.example.gccoffee.ProductMessage>(product_);
        bitField0_ |= 0x00000001;
       }
    }

    private com.google.protobuf.RepeatedFieldBuilderV3<
        com.example.gccoffee.ProductMessage, com.example.gccoffee.ProductMessage.Builder, com.example.gccoffee.ProductMessageOrBuilder> productBuilder_;

    /**
     * <code>repeated .ProductMessage product = 1;</code>
     */
    public java.util.List<com.example.gccoffee.ProductMessage> getProductList() {
      if (productBuilder_ == null) {
        return java.util.Collections.unmodifiableList(product_);
      } else {
        return productBuilder_.getMessageList();
      }
    }
    /**
     * <code>repeated .ProductMessage product = 1;</code>
     */
    public int getProductCount() {
      if (productBuilder_ == null) {
        return product_.size();
      } else {
        return productBuilder_.getCount();
      }
    }
    /**
     * <code>repeated .ProductMessage product = 1;</code>
     */
    public com.example.gccoffee.ProductMessage getProduct(int index) {
      if (productBuilder_ == null) {
        return product_.get(index);
      } else {
        return productBuilder_.getMessage(index);
      }
    }
    /**
     * <code>repeated .ProductMessage product = 1;</code>
     */
    public Builder setProduct(
        int index, com.example.gccoffee.ProductMessage value) {
      if (productBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureProductIsMutable();
        product_.set(index, value);
        onChanged();
      } else {
        productBuilder_.setMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .ProductMessage product = 1;</code>
     */
    public Builder setProduct(
        int index, com.example.gccoffee.ProductMessage.Builder builderForValue) {
      if (productBuilder_ == null) {
        ensureProductIsMutable();
        product_.set(index, builderForValue.build());
        onChanged();
      } else {
        productBuilder_.setMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .ProductMessage product = 1;</code>
     */
    public Builder addProduct(com.example.gccoffee.ProductMessage value) {
      if (productBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureProductIsMutable();
        product_.add(value);
        onChanged();
      } else {
        productBuilder_.addMessage(value);
      }
      return this;
    }
    /**
     * <code>repeated .ProductMessage product = 1;</code>
     */
    public Builder addProduct(
        int index, com.example.gccoffee.ProductMessage value) {
      if (productBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureProductIsMutable();
        product_.add(index, value);
        onChanged();
      } else {
        productBuilder_.addMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .ProductMessage product = 1;</code>
     */
    public Builder addProduct(
        com.example.gccoffee.ProductMessage.Builder builderForValue) {
      if (productBuilder_ == null) {
        ensureProductIsMutable();
        product_.add(builderForValue.build());
        onChanged();
      } else {
        productBuilder_.addMessage(builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .ProductMessage product = 1;</code>
     */
    public Builder addProduct(
        int index, com.example.gccoffee.ProductMessage.Builder builderForValue) {
      if (productBuilder_ == null) {
        ensureProductIsMutable();
        product_.add(index, builderForValue.build());
        onChanged();
      } else {
        productBuilder_.addMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .ProductMessage product = 1;</code>
     */
    public Builder addAllProduct(
        java.lang.Iterable<? extends com.example.gccoffee.ProductMessage> values) {
      if (productBuilder_ == null) {
        ensureProductIsMutable();
        com.google.protobuf.AbstractMessageLite.Builder.addAll(
            values, product_);
        onChanged();
      } else {
        productBuilder_.addAllMessages(values);
      }
      return this;
    }
    /**
     * <code>repeated .ProductMessage product = 1;</code>
     */
    public Builder clearProduct() {
      if (productBuilder_ == null) {
        product_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000001);
        onChanged();
      } else {
        productBuilder_.clear();
      }
      return this;
    }
    /**
     * <code>repeated .ProductMessage product = 1;</code>
     */
    public Builder removeProduct(int index) {
      if (productBuilder_ == null) {
        ensureProductIsMutable();
        product_.remove(index);
        onChanged();
      } else {
        productBuilder_.remove(index);
      }
      return this;
    }
    /**
     * <code>repeated .ProductMessage product = 1;</code>
     */
    public com.example.gccoffee.ProductMessage.Builder getProductBuilder(
        int index) {
      return getProductFieldBuilder().getBuilder(index);
    }
    /**
     * <code>repeated .ProductMessage product = 1;</code>
     */
    public com.example.gccoffee.ProductMessageOrBuilder getProductOrBuilder(
        int index) {
      if (productBuilder_ == null) {
        return product_.get(index);  } else {
        return productBuilder_.getMessageOrBuilder(index);
      }
    }
    /**
     * <code>repeated .ProductMessage product = 1;</code>
     */
    public java.util.List<? extends com.example.gccoffee.ProductMessageOrBuilder> 
         getProductOrBuilderList() {
      if (productBuilder_ != null) {
        return productBuilder_.getMessageOrBuilderList();
      } else {
        return java.util.Collections.unmodifiableList(product_);
      }
    }
    /**
     * <code>repeated .ProductMessage product = 1;</code>
     */
    public com.example.gccoffee.ProductMessage.Builder addProductBuilder() {
      return getProductFieldBuilder().addBuilder(
          com.example.gccoffee.ProductMessage.getDefaultInstance());
    }
    /**
     * <code>repeated .ProductMessage product = 1;</code>
     */
    public com.example.gccoffee.ProductMessage.Builder addProductBuilder(
        int index) {
      return getProductFieldBuilder().addBuilder(
          index, com.example.gccoffee.ProductMessage.getDefaultInstance());
    }
    /**
     * <code>repeated .ProductMessage product = 1;</code>
     */
    public java.util.List<com.example.gccoffee.ProductMessage.Builder> 
         getProductBuilderList() {
      return getProductFieldBuilder().getBuilderList();
    }
    private com.google.protobuf.RepeatedFieldBuilderV3<
        com.example.gccoffee.ProductMessage, com.example.gccoffee.ProductMessage.Builder, com.example.gccoffee.ProductMessageOrBuilder> 
        getProductFieldBuilder() {
      if (productBuilder_ == null) {
        productBuilder_ = new com.google.protobuf.RepeatedFieldBuilderV3<
            com.example.gccoffee.ProductMessage, com.example.gccoffee.ProductMessage.Builder, com.example.gccoffee.ProductMessageOrBuilder>(
                product_,
                ((bitField0_ & 0x00000001) != 0),
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


    // @@protoc_insertion_point(builder_scope:FindAllProductResponse)
  }

  // @@protoc_insertion_point(class_scope:FindAllProductResponse)
  private static final com.example.gccoffee.FindAllProductResponse DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.example.gccoffee.FindAllProductResponse();
  }

  public static com.example.gccoffee.FindAllProductResponse getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<FindAllProductResponse>
      PARSER = new com.google.protobuf.AbstractParser<FindAllProductResponse>() {
    @java.lang.Override
    public FindAllProductResponse parsePartialFrom(
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

  public static com.google.protobuf.Parser<FindAllProductResponse> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<FindAllProductResponse> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public com.example.gccoffee.FindAllProductResponse getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}
