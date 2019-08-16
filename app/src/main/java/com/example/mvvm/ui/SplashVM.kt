package com.example.mvvm.ui

import android.util.Log
import com.example.mvvm.data.DeviceTokenProvider
import kotlinx.coroutines.launch

class SplashVM(private val deviceTokenProvider: DeviceTokenProvider) : BaseViewModel() {
    init {
        launchDisposable {
            deviceTokenProvider
                .token()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeBy {
                    Log.d("token", it)
                }
        }

        this.viewModelScope?.launch {
            deviceTokenProvider.token1()
        }
    }

    /**
     * cai apply let, also, no ta k hieu khi nao nen dung no he?
     *
     * apply, also trả về chính nó
     * +apply lambda đối số là this
     * +also lambda đối số là it
     *
     * run, let trả về giá trị cuối cùng trong lambda
     * +run lambda đối số là this
     * +let lambda đối số là it
     *
     * chi khac nhau doi so this, it, thi sao lai phai phan ra 2 cai, nene
     * k biet vi sao phan nhu vay, thay khi dung hoi giong a. co doc qua.
     * cái this nớ nếu mình gọi cái method của chính nó
     * cái it nớ nếu mình pass nó vô method khác
     *
     * ok,
     * cho repositories: ho tro get data, luu data xun db, or get data tu api ha?? thay code toanf the
     *
     *
     * nói chung VM thì xử lí thông qua repository
     * nói chung repository thì get từ db với call api rứa thôi.ok
     *
     * trong moi class Activity,(View, chi chua fun xu li do data ve view thoi ha, show ra man hinh
     * dung k
     *
     * trong View chỉ có 2 nhiệm vụ: lắng nghe VM với dispatch sự kiện vô VM đó.
     * du lieu tra ve, sao set vo view? set no o dau?
     * lắng nghe liveData.observe đó
     * ham lien quan su kien settext deu bo trong ViewModel het.
     * muon dung thi create single ViewModel, sau do oseber set data cho view ?
     * nhu the ha?
     *
     * thì thông qua VM hết,,view chỉ setOnClick rồi đứa vô VM kiểu đó thôi
     *
     *
     *
     * nhin may cai custom ớn vl.
     * ca dong lun, trên stack or git example có k biết, ngồi tự mò, khi nào xong task haha
     * lên github copy code thưu viện về haha
     * Rxandroid dung lam gi the.
     *
     * có 2 kiểu sử dụng: 1 kiểu để thực hiện mấy cái task bất đồng bộ thay cho AsyncTask
     * 1 kiểu lạp trình reactive functional
     * có mấy chỗ fun suspend a, block. ( doc thi bao kieu no chay nhu bat dong bo rua ha?
     * suspend, khi co fun A, chay, fun B dc goi, thi B chay xong, ( A pause, rezume) sau do
     * chay tiep ha?
     *
     * cái suspenf function như async function bên JS rứa, kiểu gọi hàm đó là nó dừng coroutine cho
     * đến khi nó return value thì tiếp tục phần bên dơới, kiểu thay cho callback kiểu đỡ callback
     * block thi no block lun ha, chay cai thu 2 thoi
     *
     * bên java 1 hàm bình thuonwg khi gọi luôn block thread đó, kiểu nó phải chạy xong thì
     * phần code phía dơới mới đc chạy tiếp
     *
     *
     * suspend function thì khi nó đc gọi nó ko block thread, nó pause coroutine mà gọi nó.
     *
     * cái mô bên rxjava mà return Single có thể chuyển về suspend function
     * suspend dễ sài hơn rxjava. okbase
     *
     * */

    suspend fun func1() {
        ///
    }

    suspend fun main() {
        func1()
        func2()

    }

    fun f(): Unit {
        val a = mutableListOf<Int>()

        val b = a.apply { this.add(1) }
        val c = a.also { it.add(1) }

        val d = a.let {
            it.removeAt(0)
            ""
        }
        val e = a.run {
            this.add(2)
            ""
        }


        val aaa = A()

        aaa.apply {
            f1()
            f2()
            f3()
        }
        aaa.let(B()::f1)

        // cai trên đúng hơn
        aaa.also {
            it.f1()
            it.f2()
            it.f3()
        }
        aaa.run { B().f1(this) }
    }

    class A {
        fun f1(): Unit {

        }

        fun f2(): Unit {

        }

        fun f3(): Unit {

        }
    }

    class B {
        fun f1(a: A): Unit {

        }
    }
}