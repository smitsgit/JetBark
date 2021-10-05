package com.example.androidtemplate.backgroundwork

import android.content.Context
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.work.CoroutineWorker
import androidx.work.Worker
import androidx.work.WorkerParameters
import kotlinx.coroutines.delay
import logcat.logcat

class TemplateUploadWorker(
    ctx: Context,
    workerParameters: WorkerParameters
): Worker(ctx, workerParameters) {

    override fun doWork(): Result {
        logcat { "Starting to perform the work" }
        Thread.sleep(5000)
        logcat { "Work finished" }
        return Result.success()
    }
}

class TemplateAsyncUploadWorker(
    ctx: Context,
    workerParameters: WorkerParameters
): CoroutineWorker(ctx, workerParameters) {

    override suspend fun doWork(): Result {
        logcat { "Starting to perform the work" }
        delay(5000)
        logcat { "Work finished" }
        return Result.success()
    }

}