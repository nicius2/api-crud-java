package com.crud_simple.api;

public record ApiResponse<T> (
        boolean sucess,
        String message,
        T data
){
}
