package com.crud_simple.api;

import java.time.LocalDateTime;
import java.util.Map;

public record ApiError (
        boolean sucess,
        String message,
        LocalDateTime timestamp,
        Map<String, String> erros
){
}
