package yh.org.rxjavademo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;

public class MainActivity extends AppCompatActivity
{
    private final String TAG = getClass().getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Observable.create((ObservableEmitter<Integer> emitter) ->
        {
            emitter.onNext(1);
            emitter.onNext(2);
            emitter.onNext(3);
            emitter.onComplete();
        }).subscribe(new Observer<Integer>()
        {
            @Override
            public void onSubscribe(@NonNull Disposable d)
            {
                Log.e(TAG, "subscribe");
            }

            @Override
            public void onNext(@NonNull Integer integer)
            {
                Log.e(TAG, "onNext");
            }

            @Override
            public void onError(@NonNull Throwable e)
            {
                Log.e(TAG, "onError");
            }

            @Override
            public void onComplete()
            {
                Log.e(TAG, "onComplete");
            }
        });
    }
}
