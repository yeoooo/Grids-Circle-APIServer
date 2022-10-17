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
  private static volatile io.grpc.MethodDescriptor<com.example.gccoffee.getAllProductsRequest,
      com.example.gccoffee.GetAllProductResponse> getFindAllMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "findAll",
      requestType = com.example.gccoffee.getAllProductsRequest.class,
      responseType = com.example.gccoffee.GetAllProductResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.example.gccoffee.getAllProductsRequest,
      com.example.gccoffee.GetAllProductResponse> getFindAllMethod() {
    io.grpc.MethodDescriptor<com.example.gccoffee.getAllProductsRequest, com.example.gccoffee.GetAllProductResponse> getFindAllMethod;
    if ((getFindAllMethod = productServiceGrpc.getFindAllMethod) == null) {
      synchronized (productServiceGrpc.class) {
        if ((getFindAllMethod = productServiceGrpc.getFindAllMethod) == null) {
          productServiceGrpc.getFindAllMethod = getFindAllMethod =
              io.grpc.MethodDescriptor.<com.example.gccoffee.getAllProductsRequest, com.example.gccoffee.GetAllProductResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "findAll"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.gccoffee.getAllProductsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.gccoffee.GetAllProductResponse.getDefaultInstance()))
              .setSchemaDescriptor(new productServiceMethodDescriptorSupplier("findAll"))
              .build();
        }
      }
    }
    return getFindAllMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.example.gccoffee.helloRequest,
      com.example.gccoffee.helloResponse> getHelloMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Hello",
      requestType = com.example.gccoffee.helloRequest.class,
      responseType = com.example.gccoffee.helloResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.example.gccoffee.helloRequest,
      com.example.gccoffee.helloResponse> getHelloMethod() {
    io.grpc.MethodDescriptor<com.example.gccoffee.helloRequest, com.example.gccoffee.helloResponse> getHelloMethod;
    if ((getHelloMethod = productServiceGrpc.getHelloMethod) == null) {
      synchronized (productServiceGrpc.class) {
        if ((getHelloMethod = productServiceGrpc.getHelloMethod) == null) {
          productServiceGrpc.getHelloMethod = getHelloMethod =
              io.grpc.MethodDescriptor.<com.example.gccoffee.helloRequest, com.example.gccoffee.helloResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Hello"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.gccoffee.helloRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.gccoffee.helloResponse.getDefaultInstance()))
              .setSchemaDescriptor(new productServiceMethodDescriptorSupplier("Hello"))
              .build();
        }
      }
    }
    return getHelloMethod;
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
    public void findAll(com.example.gccoffee.getAllProductsRequest request,
        io.grpc.stub.StreamObserver<com.example.gccoffee.GetAllProductResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getFindAllMethod(), responseObserver);
    }

    /**
     */
    public void hello(com.example.gccoffee.helloRequest request,
        io.grpc.stub.StreamObserver<com.example.gccoffee.helloResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getHelloMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getFindAllMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.example.gccoffee.getAllProductsRequest,
                com.example.gccoffee.GetAllProductResponse>(
                  this, METHODID_FIND_ALL)))
          .addMethod(
            getHelloMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.example.gccoffee.helloRequest,
                com.example.gccoffee.helloResponse>(
                  this, METHODID_HELLO)))
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
    public void findAll(com.example.gccoffee.getAllProductsRequest request,
        io.grpc.stub.StreamObserver<com.example.gccoffee.GetAllProductResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getFindAllMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void hello(com.example.gccoffee.helloRequest request,
        io.grpc.stub.StreamObserver<com.example.gccoffee.helloResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getHelloMethod(), getCallOptions()), request, responseObserver);
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
    public com.example.gccoffee.GetAllProductResponse findAll(com.example.gccoffee.getAllProductsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getFindAllMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.example.gccoffee.helloResponse hello(com.example.gccoffee.helloRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getHelloMethod(), getCallOptions(), request);
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
    public com.google.common.util.concurrent.ListenableFuture<com.example.gccoffee.GetAllProductResponse> findAll(
        com.example.gccoffee.getAllProductsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getFindAllMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.gccoffee.helloResponse> hello(
        com.example.gccoffee.helloRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getHelloMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_FIND_ALL = 0;
  private static final int METHODID_HELLO = 1;

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
          serviceImpl.findAll((com.example.gccoffee.getAllProductsRequest) request,
              (io.grpc.stub.StreamObserver<com.example.gccoffee.GetAllProductResponse>) responseObserver);
          break;
        case METHODID_HELLO:
          serviceImpl.hello((com.example.gccoffee.helloRequest) request,
              (io.grpc.stub.StreamObserver<com.example.gccoffee.helloResponse>) responseObserver);
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
              .addMethod(getHelloMethod())
              .build();
        }
      }
    }
    return result;
  }
}
