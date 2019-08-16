package com.example.mvvm.ui

import org.koin.androidx.viewmodel.ext.android.viewModel

class SplashActivity {

    override val viewModelx: SplashVM by viewModel()
    /**
     * Chô ni mình get ra để dùng, thì nó sẽ lookup trong các module, có cái definnition nào có Type
     * là  SplashVM
     *
     * nó tìm ra viewModel { SplashVM(get()) }
     * rồi nó call cái lambda   { SplashVM(get()) }()
     * thì trả về SplashVM thôi, kiểu rứa đó
     * cai get do goi ra singleton cho 1 object do ha
     * haha ko
     * get có thể tạo mới đố tợợng mỗi lần gọi hoặc trả về singleton
     */
}
