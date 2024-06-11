package com.tunm17.rxjavademo;

import android.util.Log;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.BackpressureStrategy;
import io.reactivex.rxjava3.core.Flowable;

public class FlowableDemo {
    static void run() {
        Flowable<String> flowable = Flowable.create(emitter -> {
            emitter.onNext("Hello");
            emitter.onNext("World");
            emitter.onComplete();
        }, BackpressureStrategy.BUFFER);

        flowable.subscribe(new Subscriber<String>() {
            @Override
            public void onSubscribe(Subscription s) {
                Log.v("tunm17", "onSubscribe called.");
                s.request(Long.MAX_VALUE);
            }

            @Override
            public void onNext(String s) {
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
        });
    }
}
