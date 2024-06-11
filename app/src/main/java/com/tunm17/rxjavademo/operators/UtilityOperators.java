package com.tunm17.rxjavademo.operators;

import android.util.Log;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class UtilityOperators {

    // This operator specifies the scheduler on which an observer will observe this Observable.
    public static void runObserveOn() {
        Observable<Integer> observable = Observable.create(emitter -> {
            Log.v("UtilityOperators", "Emitting on thread: " + Thread.currentThread().getName());
            for (int i = 1; i <= 5; i++) {
                emitter.onNext(i);
            }
            emitter.onComplete();
        });


        observable
                .subscribeOn(Schedulers.io())  // Đặt luồng phát dữ liệu là io scheduler
                .observeOn(Schedulers.computation())  // Đặt luồng xử lý dữ liệu là computation scheduler
                .map(item -> {
                    Log.v("UtilityOperators", "Processing on thread: " + Thread.currentThread().getName());
                    return item * item;
                })
                .observeOn(Schedulers.newThread())  // Chuyển sang một luồng mới cho bước tiếp theo
                .subscribe(new Observer<Integer>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Integer integer) {
                        Log.v("UtilityOperators", "flatmap:onNext: 2 * length of string: " + integer + ", Processing on thread: " + Thread.currentThread().getName());
                        System.out.println("2 * length of string: " + integer);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });

        try {
            Thread.sleep(2000);  // Chờ 2 giây
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
