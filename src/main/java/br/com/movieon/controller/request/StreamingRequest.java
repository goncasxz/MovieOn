package br.com.movieon.controller.request;

import lombok.Builder;

@Builder
public record StreamingRequest(String name) {
}
