package com.example.mvvm.data

import android.util.Log
import com.google.firebase.iid.FirebaseInstanceId
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext
//trong reponsilytis
interface DeviceTokenProvider {
    fun token(): Single<String>

    suspend fun token1(): String?
}


class DeviceTokenProviderImpl(
    private val schedulerProvider: SchedulerProvider
) : DeviceTokenProvider {
    override suspend fun token1(): String? {
        return withContext(Dispatchers.IO) {
            FirebaseInstanceId.getInstance()
                .instanceId
                .await()
                .token
        }
    }

    override fun token(): Single<String> {
        return Single.create<String> { emitter ->
            FirebaseInstanceId.getInstance()
                .instanceId
                .addOnCompleteListener(OnCompleteListener { task ->
                    if (!task.isSuccessful) {
                        Log.w("DeviceTokenProviderImpl", "getInstanceId failed", task.exception)
                        if (!emitter.isDisposed) {
                            task.exception?.let(emitter::onError)
                        }
                        return@OnCompleteListener
                    }

                    // Get new Instance ID token
                    val token = task.result?.token

                    if (!emitter.isDisposed && token !== null) {
                        emitter.onSuccess(token)
                    } else {
                        emitter.onError(IllegalStateException("Token is null"))
                    }
                })
        }.subscribeOn(schedulerProvider.io())
    }