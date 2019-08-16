package com.example.mvvm.di

import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val repositoryModule = module {
    single { provideDeviceToken(get()) }
}
fun provideDeviceToken(schedulerProvider: SchedulerProvider): DeviceTokenProvider {
    return DeviceTokenProviderImpl(schedulerProvider = schedulerProvider)
}