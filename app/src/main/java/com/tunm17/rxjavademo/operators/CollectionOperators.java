package com.tunm17.rxjavademo.operators;

import android.util.Log;

import java.util.concurrent.TimeUnit;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;

public class CollectionOperators {

    // This operator shifts the emissions from an Observable forward in time by a particular amount
    public static void runDelay() {
        Observable.just("A", "B", "C", "D", "E", "F")
                .delay(5, TimeUnit.SECONDS)
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(String s) {
                        Log.v("CollectionOperators", "delay:onNext: " + s);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });


        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
