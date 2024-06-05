package com.example.simpledemo;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private static final String COUNT_KEY = "count_key";
    private int iCount = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 获取 TextView 和 Button 的引用
        TextView textView = findViewById(R.id.textView);
        Button button = findViewById(R.id.button);

        // 恢复状态
        if (savedInstanceState != null) {
            iCount = savedInstanceState.getInt(COUNT_KEY, 0);
            textView.setText(String.format("Reserved, iCount = %d", iCount));
            Log.d(TAG, "onCreate: Restored iCount = " + iCount);
        } else {
            Log.d(TAG, "onCreate: No saved instance state");
        }

        // 设置按钮点击事件监听器
        button.setOnClickListener(v -> {
            // 修改 TextView 的文本
            textView.setText(String.format("Hello, Android! iCount = %d", iCount++));
            Log.d(TAG, "onClick: iCount = " + iCount);
        });
    }
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        // 保存当前计数值
        outState.putInt(COUNT_KEY, iCount);
        Log.d(TAG, "onSaveInstanceState: Saving iCount = " + iCount);
    }
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        // 恢复状态
        iCount = savedInstanceState.getInt(COUNT_KEY, 0);
        TextView textView = findViewById(R.id.textView);
        textView.setText(String.format("Hello, Android! iCount = %d", iCount));
        Log.d(TAG, "onRestoreInstanceState: Restored iCount = " + iCount);
    }
}
