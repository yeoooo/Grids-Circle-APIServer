package com.example.gccoffee;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.50.0)",
    comments = "Source: ProductService.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class productServiceGrpc {

  private productServiceGrpc() {}

  public static final String SERVICE_NAME = "productService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.example.gccoffee.FindAllProductRequest,
      com.example.gccoffee.FindAllProductResponse> getFindAllMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "findAll",
      requestType = com.example.gccoffee.FindAllProductRequest.class,
      responseType = com.example.gccoffee.FindAllProductResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.example.gccoffee.FindAllProductRequest,
      com.example.gccoffee.FindAllProductResponse> getFindAllMethod() {
    io.grpc.MethodDescriptor<com.example.gccoffee.FindAllProductRequest, com.example.gccoffee.FindAllProductResponse> getFindAllMethod;
    if ((getFindAllMethod = productServiceGrpc.getFindAllMethod) == null) {
      synchronized (productServiceGrpc.class) {
        if ((getFindAllMethod = productServiceGrpc.getFindAllMethod) == null) {
          productServiceGrpc.getFindAllMethod = getFindAllMethod =
              io.grpc.MethodDescriptor.<com.example.gccoffee.FindAllProductRequest, com.example.gccoffee.FindAllProductResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "findAll"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.gccoffee.FindAllProductRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.gccoffee.FindAllProductResponse.getDefaultInstance()))
              .setSchemaDescriptor(new productServiceMethodDescriptorSupplier("findAll"))
              .build();
        }
      }
    }
    return getFindAllMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.example.gccoffee.FindProductByIdRequest,
      com.example.gccoffee.FindOneProductResponse> getFindByIdMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "findById",
      requestType = com.example.gccoffee.FindProductByIdRequest.class,
      responseType = com.example.gccoffee.FindOneProductResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.example.gccoffee.FindProductByIdRequest,
      com.example.gccoffee.FindOneProductResponse> getFindByIdMethod() {
    io.grpc.MethodDescriptor<com.example.gccoffee.FindProductByIdRequest, com.example.gccoffee.FindOneProductResponse> getFindByIdMethod;
    if ((getFindByIdMethod = productServiceGrpc.getFindByIdMethod) == null) {
      synchronized (productServiceGrpc.class) {
        if ((getFindByIdMethod = productServiceGrpc.getFindByIdMethod) == null) {
          productServiceGrpc.getFindByIdMethod = getFindByIdMethod =
              io.grpc.MethodDescriptor.<com.example.gccoffee.FindProductByIdRequest, com.example.gccoffee.FindOneProductResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "findById"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.gccoffee.FindProductByIdRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.gccoffee.FindOneProductResponse.getDefaultInstance()))
              .setSchemaDescriptor(new productServiceMethodDescriptorSupplier("findById"))
              .build();
        }
      }
    }
    return getFindByIdMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.example.gccoffee.FindProductByNameRequest,
      com.example.gccoffee.FindOneProductResponse> getFindByNameMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "findByName",
      requestType = com.example.gccoffee.FindProductByNameRequest.class,
      responseType = com.example.gccoffee.FindOneProductResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.example.gccoffee.FindProductByNameRequest,
      com.example.gccoffee.FindOneProductResponse> getFindByNameMethod() {
    io.grpc.MethodDescriptor<com.example.gccoffee.FindProductByNameRequest, com.example.gccoffee.FindOneProductResponse> getFindByNameMethod;
    if ((getFindByNameMethod = productServiceGrpc.getFindByNameMethod) == null) {
      synchronized (productServiceGrpc.class) {
        if ((getFindByNameMethod = productServiceGrpc.getFindByNameMethod) == null) {
          productServiceGrpc.getFindByNameMethod = getFindByNameMethod =
              io.grpc.MethodDescriptor.<com.example.gccoffee.FindProductByNameRequest, com.example.gccoffee.FindOneProductResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "findByName"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.gccoffee.FindProductByNameRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.gccoffee.FindOneProductResponse.getDefaultInstance()))
              .setSchemaDescriptor(new productServiceMethodDescriptorSupplier("findByName"))
              .build();
        }
      }
    }
    return getFindByNameMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static productServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<productServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<productServiceStub>() {
        @java.lang.Override
        public productServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new productServiceStub(channel, callOptions);
        }
      };
    return productServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static productServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<productServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<productServiceBlockingStub>() {
        @java.lang.Override
        public productServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new productServiceBlockingStub(channel, callOptions);
        }
      };
    return productServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static productServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<productServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<productServiceFutureStub>() {
        @java.lang.Override
        public productServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new productServiceFutureStub(channel, callOptions);
        }
      };
    return productServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class productServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void findAll(com.example.gccoffee.FindAllProductRequest request,
        io.grpc.stub.StreamObserver<com.example.gccoffee.FindAllProductResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getFindAllMethod(), responseObserver);
    }

    /**
     */
    public void findById(com.example.gccoffee.FindProductByIdRequest request,
        io.grpc.stub.StreamObserver<com.example.gccoffee.FindOneProductResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getFindByIdMethod(), responseObserver);
    }

    /**
     */
    public void findByName(com.example.gccoffee.FindProductByNameRequest request,
        io.grpc.stub.StreamObserver<com.example.gccoffee.FindOneProductResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getFindByNameMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getFindAllMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.example.gccoffee.FindAllProductRequest,
                com.example.gccoffee.FindAllProductResponse>(
                  this, METHODID_FIND_ALL)))
          .addMethod(
            getFindByIdMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.example.gccoffee.FindProductByIdRequest,
                com.example.gccoffee.FindOneProductResponse>(
                  this, METHODID_FIND_BY_ID)))
          .addMethod(
            getFindByNameMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.example.gccoffee.FindProductByNameRequest,
                com.example.gccoffee.FindOneProductResponse>(
                  this, METHODID_FIND_BY_NAME)))
          .build();
    }
  }

  /**
   */
  public static final class productServiceStub extends io.grpc.stub.AbstractAsyncStub<productServiceStub> {
    private productServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected productServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new productServiceStub(channel, callOptions);
    }

    /**
     */
    public void findAll(com.example.gccoffee.FindAllProductRequest request,
        io.grpc.stub.StreamObserver<com.example.gccoffee.FindAllProductResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getFindAllMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void findById(com.example.gccoffee.FindProductByIdRequest request,
        io.grpc.stub.StreamObserver<com.example.gccoffee.FindOneProductResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getFindByIdMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void findByName(com.example.gccoffee.FindProductByNameRequest request,
        io.grpc.stub.StreamObserver<com.example.gccoffee.FindOneProductResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getFindByNameMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class productServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<productServiceBlockingStub> {
    private productServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected productServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new productServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.example.gccoffee.FindAllProductResponse findAll(com.example.gccoffee.FindAllProductRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getFindAllMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.example.gccoffee.FindOneProductResponse findById(com.example.gccoffee.FindProductByIdRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getFindByIdMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.example.gccoffee.FindOneProductResponse findByName(com.example.gccoffee.FindProductByNameRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getFindByNameMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class productServiceFutureStub extends io.grpc.stub.AbstractFutureStub<productServiceFutureStub> {
    private productServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected productServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new productServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.gccoffee.FindAllProductResponse> findAll(
        com.example.gccoffee.FindAllProductRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getFindAllMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.gccoffee.FindOneProductResponse> findById(
        com.example.gccoffee.FindProductByIdRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getFindByIdMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.gccoffee.FindOneProductResponse> findByName(
        com.example.gccoffee.FindProductByNameRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getFindByNameMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_FIND_ALL = 0;
  private static final int METHODID_FIND_BY_ID = 1;
  private static final int METHODID_FIND_BY_NAME = 2;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final productServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(productServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_FIND_ALL:
          serviceImpl.findAll((com.example.gccoffee.FindAllProductRequest) request,
              (io.grpc.stub.StreamObserver<com.example.gccoffee.FindAllProductResponse>) responseObserver);
          break;
        case METHODID_FIND_BY_ID:
          serviceImpl.findById((com.example.gccoffee.FindProductByIdRequest) request,
              (io.grpc.stub.StreamObserver<com.example.gccoffee.FindOneProductResponse>) responseObserver);
          break;
        case METHODID_FIND_BY_NAME:
          serviceImpl.findByName((com.example.gccoffee.FindProductByNameRequest) request,
              (io.grpc.stub.StreamObserver<com.example.gccoffee.FindOneProductResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class productServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    productServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.example.gccoffee.ProductService.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("productService");
    }
  }

  private static final class productServiceFileDescriptorSupplier
      extends productServiceBaseDescriptorSupplier {
    productServiceFileDescriptorSupplier() {}
  }

  private static final class productServiceMethodDescriptorSupplier
      extends productServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    productServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (productServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new productServiceFileDescriptorSupplier())
              .addMethod(getFindAllMethod())
              .addMethod(getFindByIdMethod())
              .addMethod(getFindByNameMethod())
              .build();
        }
      }
    }
    return result;
  }
}
