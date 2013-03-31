package com.example.tuts_plus_ascii_art_editor_android;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ColorChooser extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.color_choice);
	}
	
	public void setColors(View view) {
		String tagInfo = (String)view.getTag();
		String[] tagColors = tagInfo.split(" ");
		/* Now we want to pass this data back to the main Activity 
		  so that we can apply the color scheme settings to the 
		  user interface elements there. To do this we use an Intent */
		Intent backIntent = new Intent();
		backIntent.putExtra("textColor", tagColors[0]);
		backIntent.putExtra("backColor", tagColors[1]);
		// set  the return intent result
		setResult(RESULT_OK, backIntent);
		//return to the activity that called this one by finishing:
		finish();
	}

}
