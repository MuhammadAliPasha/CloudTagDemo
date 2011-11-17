package com.jonas.cloudtagdemo;

import java.util.Random;

import com.jonas.cloudtagdemo.R;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class TestActivity extends Activity {
	private Button btn;
	private EditText ep;
	private TextView[] textViewG;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		btn = (Button) findViewById(R.id.btnTest);
		ep = (EditText) findViewById(R.id.etInput);
		btn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				createOption();
			}
		});
	}

	private OnClickListener listener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			String text = ((TextView) v).getText().toString();
			Toast.makeText(TestActivity.this, text, Toast.LENGTH_SHORT).show();
		}
	};

	private void createOption() {

		ViewGroup.LayoutParams vl = new ViewGroup.LayoutParams(
				LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
		LinearLayout llVoteOptionGroup = (LinearLayout) this
				.findViewById(R.id.ll);
		llVoteOptionGroup.removeAllViews();
		Animation aa = AnimationUtils.loadAnimation(TestActivity.this,
				R.anim.scale);
		llVoteOptionGroup.setAnimation(aa);
		llVoteOptionGroup.setGravity(Gravity.CENTER);
		textViewG = new TextView[20];

		int color[] = { Color.YELLOW, Color.CYAN, Color.GREEN, Color.RED,
				Color.WHITE};
		for (int i = 0; i < 5; i++) {
			textViewG[i] = new TextView(this);
			textViewG[i].setText("dsdsds" + i);
			textViewG[i].setLayoutParams(vl);
			Random rm = new Random();

			textViewG[i].setTextColor(color[rm.nextInt(4)]);
			textViewG[i].setOnClickListener(listener);
		}

		for (int i = 0; i < 5; i++) {
			LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
					LinearLayout.LayoutParams.WRAP_CONTENT,
					LinearLayout.LayoutParams.WRAP_CONTENT);

			Random rm = new Random();
			int left = rm.nextInt(100);
			int top = rm.nextInt(10);
			int right = rm.nextInt(60);
			int bottom = rm.nextInt(10);
			System.out.println("Left" + left + "\n" + "Top" + top + "\n"
					+ "Right" + right + "\n" + "Bottom" + bottom + "\n");
			lp.setMargins(left, top, right, bottom);
			llVoteOptionGroup.addView(textViewG[i], lp);
		}

	}
}