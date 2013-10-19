package com.bignerdranch.android.geoquiz;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CheatActivity extends Activity {
	private static final String TAG = "CheatActivity";
	public static final String EXTRA_ANSWER_IS_TRUE = "com.bignerdranch.android.geoquiz.answer_is_true";
	public static final String EXTRA_ANSWER_SHOWN = "com.bignerdranch.android.geoquiz.answer_shown";
	public static final String CHEAT = "com.bignerdranch.android.geoquiz.cheat";
	public static final String SAVE_TEXT = "save_text";
	private int mSaveAnswerText;
	private boolean mAnswerIsTrue;
	private TextView mAnswerTextView;
	private TextView mAPILevelText;
	private Button mShowAnswer;
	private boolean mIsAnswerShown;
	
	private void setAnswerShownResult(boolean isAnswerShown){
		Intent data = new Intent(); //Intent no-arg constructor
		data.putExtra(EXTRA_ANSWER_SHOWN, isAnswerShown); //Intent to transport data back to MainActivity
		setResult(RESULT_OK, data); //Sends the intent back to Main 
		//Activity with an OK response when back button is pressed on Quiz Activity.
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_cheat);
		
		mAnswerIsTrue = getIntent().getBooleanExtra(EXTRA_ANSWER_IS_TRUE, false);
		
		mAnswerTextView = (TextView)findViewById(R.id.answerTextView);
		
		mAPILevelText = (TextView)findViewById(R.id.apiLevelText);
		mAPILevelText.setText("API Level " + Build.VERSION.SDK_INT);
		
		mShowAnswer = (Button)findViewById(R.id.showAnswerButton);
		mShowAnswer.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if(mAnswerIsTrue){
					mAnswerTextView.setText(R.string.true_button);
					mSaveAnswerText = R.string.true_button;
				}
				else{
					mAnswerTextView.setText(R.string.false_button);
					mSaveAnswerText = R.string.false_button;
				}
				
				mIsAnswerShown = true;
				
			}
		});
		
		if(savedInstanceState != null){
			mIsAnswerShown = savedInstanceState.getBoolean(CHEAT, false);

		}
		setAnswerShownResult(mIsAnswerShown);
		
	}
	
	@Override
	public void onSaveInstanceState(Bundle savedInstanceState){
		super.onSaveInstanceState(savedInstanceState);
		savedInstanceState.putBoolean(CHEAT, mIsAnswerShown);
		savedInstanceState.putInt(SAVE_TEXT, mSaveAnswerText);

	}
	
    @Override
    public void onStart(){
    	super.onStart();
    	Log.d(TAG, "onStart() called");
    }
    
    @Override
    public void onPause(){
    	super.onPause();
    	Log.d(TAG, "onPause() called");
    }
    
    @Override
    public void onResume(){
    	super.onResume();
    	Log.d(TAG, "onResume() called");
    }

    @Override
    public void onStop(){
    	super.onStop();
    	Log.d(TAG, "onStop() called");
    }
    
    @Override
    public void onDestroy(){
    	super.onDestroy();
    	Log.d(TAG, "onDestroy called");
    }

}
