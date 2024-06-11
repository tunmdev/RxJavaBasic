package com.tunm17.rxjavademo.operators;

import android.util.Log;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.BiPredicate;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.functions.Predicate;

public class FilterOperatorsDemo {

    // This operator suppresses duplicate items emitted by an Observable
    public static void runDistinct() {
        Observable.just(10, 20, 20, 10, 30, 40, 70, 60, 70)
                .distinct()
                .subscribe(new Observer<Integer>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Integer integer) {
                        Log.v("FilterOperatorsDemo", "distinct:onNext: " + integer);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    // This operator emits only those items from an Observable that pass a predicate test.
    public static void runFilter() {
        Observable.just(1, 2, 3, 4, 5, 6, 1, 4)
//                .filter(value -> value % 2 == 0)
//                .filter(new Predicate<Integer>() {
//                    @Override
//                    public boolean test(Integer integer) throws Throwable {
//                        return integer % 2 == 0;
//                    }
//                })
                .subscribe(new Observer<Integer>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull Integer integer) {
                        Log.v("FilterOperatorsDemo", "filter: onNext: " + integer);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    //  It emit only the first n items emitted by an Observable.
    static void runTake() {
        Observable.just("A", "B", "C", "D", "E", "F", "G", "H", "I", "J")
                .take(4)
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(String s) {
                        Log.v("FilterOperatorsDemo", "take: onNext: " + s);
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
