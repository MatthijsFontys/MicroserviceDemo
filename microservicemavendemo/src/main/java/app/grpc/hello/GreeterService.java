package app.grpc.hello;

import io.grpc.stub.StreamObserver;
import app.grpc.hello.GreeterGrpc.GreeterImplBase;

public class GreeterService extends GreeterImplBase {
    @Override
    public void sayHello(HelloRequest request, StreamObserver<HelloReply> responseObserver){
        var reply = HelloReply.newBuilder().setMessage("Hello " + request.getName()).build();
        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }
}
