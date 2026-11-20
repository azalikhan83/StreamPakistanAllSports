
package com.streampakistan.allsports;

import android.app.Activity;
import android.os.Bundle;
import android.graphics.Color;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Button;
import android.content.Intent;
import android.net.Uri;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.setGravity(Gravity.CENTER);
        layout.setPadding(32, 32, 32, 32);
        layout.setBackgroundColor(Color.rgb(8, 16, 35));

        TextView title = new TextView(this);
        title.setText("STREAM PAKISTAN\nALL SPORTS");
        title.setTextSize(28);
        title.setTextColor(Color.WHITE);
        title.setGravity(Gravity.CENTER);
        layout.addView(title);

        TextView subtitle = new TextView(this);
        subtitle.setText("\nYour Sports. Your Passion.\n");
        subtitle.setTextSize(16);
        subtitle.setTextColor(Color.LTGRAY);
        subtitle.setGravity(Gravity.CENTER);
        layout.addView(subtitle);

        Button channels = new Button(this);
        channels.setText("VIEW LIVE CHANNELS");
        layout.addView(channels);

        channels.setOnClickListener(v -> {
            Intent intent = new Intent(
                Intent.ACTION_VIEW,
                Uri.parse(
                    "https://stream-pakistan-api.azalikhan83.workers.dev/api/channels"
                )
            );
            startActivity(intent);
        });

        setContentView(layout);
    }
}
