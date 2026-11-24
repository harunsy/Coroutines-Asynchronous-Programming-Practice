package com.example.coroutinesandasynchronousprogramming_practice.data

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext
import java.io.IOException

class TaskRepository {

    suspend fun getTasks(shouldFail: Boolean = false): List<Task> =
        withContext(Dispatchers.IO) {
            delay(2000L)
            // Latihan 4 note: if Thread.sleep(2000L) is used inside withContext(Dispatchers.IO),
            // it blocks the IO dispatcher thread (not main thread directly, unless called on main thread).
            // If withContext is removed, it would run on whatever caller thread (Main thread if called from launch),
            // causing ANR / UI freeze!
            if (shouldFail) {
                throw IOException("Server is not reachable")
            }
            listOf(
                Task(1, "Write lab report", "Mobile App Development"),
                Task(2, "Read chapter 5", "Data Science"),
                Task(3, "Prepare quiz", "Research Methodology")
            )
        }

    suspend fun getAnnouncement(): String =
        withContext(Dispatchers.IO) {
            delay(1000L)
            "Quiz 2 is next Monday"
        }

    // Latihan 1 requirement
    suspend fun getCourseCount(): Int =
        withContext(Dispatchers.IO) {
            delay(1500L)
            5
        }
}
