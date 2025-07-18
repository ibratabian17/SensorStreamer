package cz.honzamrazek.sensorstreamer;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import com.google.android.material.color.DynamicColors;

public class StreamingErrorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        DynamicColors.applyToActivityIfAvailable(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_streaming_error);

        setTitle(getIntent().getStringExtra("title"));
        TextView message = (TextView) findViewById(R.id.message);
        message.setText(getIntent().getStringExtra("message"), TextView.BufferType.NORMAL);
    }

    public void onDismiss(View v) {
        finish();
    }
}
