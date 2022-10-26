package com.example.gccoffee;
import com.google.protobuf.Message;
import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.Struct;
import com.google.protobuf.util.JsonFormat;


import java.io.IOException;

public class ProtobufUtil extends IOException{
    public static Message fromJson(String json) throws IOException {
            Message.Builder structBuilder = Struct.newBuilder();
            JsonFormat.parser().ignoringUnknownFields().merge(json, structBuilder);
            return structBuilder.build();
        }
    public static String toJson(MessageOrBuilder messageOrBuilder) throws IOException {
        return JsonFormat.printer().print(messageOrBuilder);
    }
}
