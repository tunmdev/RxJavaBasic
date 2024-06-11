package com.tunm17.rxjavademo;

import android.util.Log;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.Disposable;

/**
 * Single is an observable that emits only a single item
 * SingleObserver class have no onNext(), and onComplete()
 * use: one time network request,...
 */
public class SingleDemo {

    static void run() {
        Single<String> single = Single.create(emitter -> {
            // We have no onNext here because we're Single
            emitter.onSuccess("Hello World from Single");
        });

        single.subscribe(new SingleObserver<String>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {
                Log.v("tunm17", "onSubscribe called.");
            }

            @Override
            public void onSuccess(@NonNull String s) {
                Log.v("tunm17", "Received: " + s);
            }

            @Override
            public void onError(@NonNull Throwable e) {
                e.printStackTrace();
            }
        });
    }
}

//    Mô tả:
//        Single chỉ phát ra một giá trị duy nhất hoặc một lỗi.
//        Không có khái niệm hoàn thành (onComplete) vì nó chỉ phát ra đúng một giá trị duy nhất hoặc một lỗi.

//    Trường hợp sử dụng:
//        Khi bạn mong đợi một giá trị duy nhất từ một nguồn dữ liệu.
//        Các tác vụ như truy vấn một đối tượng từ cơ sở dữ liệu, gọi API trả về một kết quả duy nhất, hoặc tính toán một giá trị đơn lẻ.
