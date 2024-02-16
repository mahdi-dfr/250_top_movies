package com.example.filmnegar.utils

data class ServiceResponse<T>(
    var status: String? = null,
    var message: String? = null,
    var result : T? = null,
)
