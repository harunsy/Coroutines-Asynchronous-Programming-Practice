package com.example.coroutinesandasynchronousprogramming_practice.ui.main

import com.example.coroutinesandasynchronousprogramming_practice.data.Task

data class TasksUiState(
    val isLoading: Boolean = false,
    val tasks: List<Task> = emptyList(),
    val announcement: String = "",
    val courseCount: Int = 0,
    val errorMessage: String? = null,
    val tapCount: Int = 0
)
