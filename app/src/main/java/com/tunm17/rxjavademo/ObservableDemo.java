package com.tunm17.rxjavademo;

import android.util.Log;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableEmitter;
import io.reactivex.rxjava3.core.ObservableOnSubscribe;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class ObservableDemo {
    static void runHelloWorld() {
        // Step 1. Create observable
        Observable<String> observable = Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<String> emitter) throws Throwable {
                Thread.sleep(1000);
                Log.v("tunm1", "Thread name observable1: " + Thread.currentThread().getName());
                emitter.onNext("Hello");
                emitter.onNext("World");

                emitter.onComplete();
            }
        });

        // Step 1. Create observable
        Observable<String> observable2 = Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<String> emitter) throws Throwable {

                Log.v("tunm1", "Thread name observable2: " + Thread.currentThread().getName());
                emitter.onNext("Hello3");
                emitter.onNext("World3");

                emitter.onComplete();
            }
        });

        // Step 2. Create Observer
        Observer<String> observer = new Observer<String>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {
                Log.v("tunm17", "onSubscribe called.");
            }

            @Override
            public void onNext(@NonNull String s) {
                Log.v("tunm17", "Received: " + s);
            }

            @Override
            public void onError(@NonNull Throwable e) {
                Log.v("tunm17", e.getMessage());
            }

            @Override
            public void onComplete() {
                Log.v("tunm17", "onComplete called!");
            }
        };

        // Step 3: subscribe

        observable2
                .subscribeOn(Schedulers.newThread())
                .subscribe(observer);

        observable
                .subscribeOn(Schedulers.io())
                .subscribe(observer);
    }

    static void runEx1() {
        Observable<Integer> observable = Observable.range(1, 10);
        observable.subscribe(new Observer<Integer>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {
                Log.v("tunm17", "onSubscribe called.");
            }

            @Override
            public void onNext(@NonNull Integer integer) {
                Log.v("tunm17", "Received: " + integer);
            }

            @Override
            public void onError(@NonNull Throwable e) {
                Log.v("tunm17", e.getMessage());
            }

            @Override
            public void onComplete() {
                Log.v("tunm17", "onComplete called!");
            }
        });
    }
}
