package br.com.movieon.mapper;

import br.com.movieon.controller.request.StreamingRequest;
import br.com.movieon.controller.response.StreamingResponse;
import br.com.movieon.entity.Streaming;
import lombok.experimental.UtilityClass;

@UtilityClass
public class StreamingMapper {
    public static Streaming toStreaming(StreamingRequest streamingRequest) {
        return Streaming
                .builder()
                .name(streamingRequest.name())
                .build();
    }

    public static StreamingResponse toStreamingResponse(Streaming streaming) {
        return StreamingResponse
                .builder()
                .id(streaming.getId())
                .name(streaming.getName())
                .build();
    }
}
