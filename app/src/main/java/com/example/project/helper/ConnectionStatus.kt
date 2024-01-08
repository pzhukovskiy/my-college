package com.example.project.helper

sealed class ConnectionStatus {
    object Available: ConnectionStatus()
    object Unavailable: ConnectionStatus()
}