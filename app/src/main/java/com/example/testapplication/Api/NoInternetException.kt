package com.example.testapplication.Api

import java.io.IOException

class NoInternetException(message: String): IOException(message) {
}