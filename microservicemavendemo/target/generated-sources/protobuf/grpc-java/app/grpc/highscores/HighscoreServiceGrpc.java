package app.grpc.highscores;

import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.4.0)",
    comments = "Source: highscore.proto")
public final class HighscoreServiceGrpc {

  private HighscoreServiceGrpc() {}

  public static final String SERVICE_NAME = "Highscore.HighscoreService";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<app.grpc.highscores.PuzzleRequest,
      app.grpc.highscores.PuzzleReply> METHOD_GET_PUZZLE_HIGHSCORE =
      io.grpc.MethodDescriptor.<app.grpc.highscores.PuzzleRequest, app.grpc.highscores.PuzzleReply>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "Highscore.HighscoreService", "GetPuzzleHighscore"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              app.grpc.highscores.PuzzleRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              app.grpc.highscores.PuzzleReply.getDefaultInstance()))
          .build();

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static HighscoreServiceStub newStub(io.grpc.Channel channel) {
    return new HighscoreServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static HighscoreServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new HighscoreServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static HighscoreServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new HighscoreServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class HighscoreServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void getPuzzleHighscore(app.grpc.highscores.PuzzleRequest request,
        io.grpc.stub.StreamObserver<app.grpc.highscores.PuzzleReply> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_GET_PUZZLE_HIGHSCORE, responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            METHOD_GET_PUZZLE_HIGHSCORE,
            asyncUnaryCall(
              new MethodHandlers<
                app.grpc.highscores.PuzzleRequest,
                app.grpc.highscores.PuzzleReply>(
                  this, METHODID_GET_PUZZLE_HIGHSCORE)))
          .build();
    }
  }

  /**
   */
  public static final class HighscoreServiceStub extends io.grpc.stub.AbstractStub<HighscoreServiceStub> {
    private HighscoreServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private HighscoreServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected HighscoreServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new HighscoreServiceStub(channel, callOptions);
    }

    /**
     */
    public void getPuzzleHighscore(app.grpc.highscores.PuzzleRequest request,
        io.grpc.stub.StreamObserver<app.grpc.highscores.PuzzleReply> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_GET_PUZZLE_HIGHSCORE, getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class HighscoreServiceBlockingStub extends io.grpc.stub.AbstractStub<HighscoreServiceBlockingStub> {
    private HighscoreServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private HighscoreServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected HighscoreServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new HighscoreServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public app.grpc.highscores.PuzzleReply getPuzzleHighscore(app.grpc.highscores.PuzzleRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_GET_PUZZLE_HIGHSCORE, getCallOptions(), request);
    }
  }

  /**
   */
  public static final class HighscoreServiceFutureStub extends io.grpc.stub.AbstractStub<HighscoreServiceFutureStub> {
    private HighscoreServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private HighscoreServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected HighscoreServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new HighscoreServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<app.grpc.highscores.PuzzleReply> getPuzzleHighscore(
        app.grpc.highscores.PuzzleRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_GET_PUZZLE_HIGHSCORE, getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_PUZZLE_HIGHSCORE = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final HighscoreServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(HighscoreServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_PUZZLE_HIGHSCORE:
          serviceImpl.getPuzzleHighscore((app.grpc.highscores.PuzzleRequest) request,
              (io.grpc.stub.StreamObserver<app.grpc.highscores.PuzzleReply>) responseObserver);
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

  private static final class HighscoreServiceDescriptorSupplier implements io.grpc.protobuf.ProtoFileDescriptorSupplier {
    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return app.grpc.highscores.Highscore.getDescriptor();
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (HighscoreServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new HighscoreServiceDescriptorSupplier())
              .addMethod(METHOD_GET_PUZZLE_HIGHSCORE)
              .build();
        }
      }
    }
    return result;
  }
}
