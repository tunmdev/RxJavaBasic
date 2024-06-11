package com.tunm17.rxjavademo;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.disposables.Disposable;

public class CompletableDemo {
    static void run() {
        Completable.fromSingle(Single.just("Hello world!")).subscribe(new CompletableObserver() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {
                
            }

            @Override
            public void onComplete() {

            }

            @Override
            public void onError(@NonNull Throwable e) {

            }
        });

    }
}

//    Mô tả:
//        Completable không phát ra bất kỳ giá trị nào, chỉ tín hiệu hoàn thành hoặc lỗi.
//        Được sử dụng để biểu diễn các tác vụ mà bạn chỉ cần biết khi nào chúng hoàn thành hoặc gặp lỗi, không cần quan tâm đến giá trị kết quả.

//    Trường hợp sử dụng:
//        Khi bạn chỉ quan tâm đến việc một tác vụ đã hoàn thành hay chưa mà không cần nhận kết quả.
//        Các tác vụ như ghi vào cơ sở dữ liệu, gửi dữ liệu lên server, xóa một tệp, hoặc bất kỳ thao tác nào mà kết quả của nó chỉ là trạng thái hoàn thành hoặc lỗi.
