package net.sf.dvstar.android.diamon.journal;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;

public abstract class JournalCommonActivity extends Activity {

	protected String NAME = "Report name";
	protected String DESC = "Report description";
	protected Bitmap ICON = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}
}
