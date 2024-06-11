package com.tunm17.rxjavademo;

import android.util.Log;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.Disposable;

/**
 * Maybe is similar to Single but it allows your observable the ability to not emit any item at all
 * onComplete is back
 */
public class MaybeDemo {
    static void run() {
//        Maybe<String> single = Maybe.create(emitter -> {
//            emitter.onSuccess("Hello World from Maybe");
//        });

        Maybe<String> maybe = Maybe.empty();

        maybe.subscribe(new MaybeObserver<String>() {
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

            @Override
            public void onComplete() {
                Log.v("tunm17", "onComplete called.");
            }
        });
    }
}

//    Mô tả:
//        Maybe có thể phát ra một giá trị, không phát ra gì, hoặc phát ra một lỗi.
//        Nếu nó phát ra một giá trị, nó sẽ hoàn thành (onComplete) sau khi phát ra giá trị đó.
//        Nếu nó không phát ra giá trị nào, nó chỉ hoàn thành (onComplete) mà không phát ra gì.

//    Trường hợp sử dụng:
//        Khi bạn có thể hoặc không có giá trị để phát ra.
//        Các tác vụ như tìm kiếm một đối tượng trong cơ sở dữ liệu (có thể không tìm thấy đối tượng nào), kiểm tra trạng thái của một tác vụ có thể hoàn thành hoặc không có kết quả.
