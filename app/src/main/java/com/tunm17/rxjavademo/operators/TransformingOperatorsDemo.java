package com.tunm17.rxjavademo.operators;

import android.util.Log;

import java.util.Arrays;
import java.util.List;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableEmitter;
import io.reactivex.rxjava3.core.ObservableOnSubscribe;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class TransformingOperatorsDemo {


    // Allows for us to modify the emitted item from the Observable and then emits the modified item.
    public static void runMap() {
        getOriginalObservable().map(value -> value * 2)
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<Integer>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull Integer integer) {
                        Log.v("TransformingOperatorsDemo", "map:onNext: " + integer);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    static Observable<Integer> getOriginalObservable() {
        final List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5, 6);

        return Observable
                .create(new ObservableOnSubscribe<Integer>() {
                    @Override
                    public void subscribe(ObservableEmitter<Integer> emitter) {
                        for(Integer integer : integers) {

                            if (!emitter.isDisposed()) {
                                emitter.onNext(integer);
                            }
                        }

                        if(!emitter.isDisposed()) {
                            emitter.onComplete();
                        }
                    }

                });
    }

    private static Observable<Integer> getModifiedObservable(final Integer integer) {
        return Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> emitter) throws InterruptedException {
                emitter.onNext((integer * 2));
                emitter.onComplete();
            }
        }).subscribeOn(Schedulers.io());
    }

    // This operator transforms each item emitted by an Observable but instead of returning the modified item,
    // it returns the Observable itself which can emit data again.
    public static void runFlatMap() {
        getOriginalObservable()
                .flatMap(new Function<Integer, ObservableSource<Integer>>() {
                    @Override
                    public ObservableSource<Integer> apply(Integer integer) throws Throwable {
                        return getModifiedObservable(integer);
                    }
                })
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<Integer>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Integer integer) {
                        Log.v("TransformingOperatorsDemo", "flatmap:onNext: " + integer);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
