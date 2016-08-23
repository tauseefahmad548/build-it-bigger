package pk.smallapps.displayjokes;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class DisplayContentActivity extends AppCompatActivity {
    public static final String EXTRA_CONTENT = "display_content";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView contentTextView = (TextView) findViewById(R.id.content_text_view);
        if (savedInstanceState == null && getIntent() != null) {
            contentTextView.setText(getIntent().getStringExtra(EXTRA_CONTENT));
        }
    }
}
