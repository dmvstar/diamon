package net.sf.dvstar.android.diamon.widgets.filechooser;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import net.sf.dvstar.android.diamon.R;
import android.app.Activity;
import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

/**
 * File chooser class for select file or dir
 * 
 * @author sdv
 * 
 */
public class FileChooser extends ListActivity {

	public static final String PARAMS_FC_WORK_MODE 	= "PARAMS_FC_WORK_MODE"; 
	public static final String PARAMS_FC_WORK_DIR   = "PARAMS_FC_WORK_DIR"; 
	public static final String PARAMS_FC_ROOT_DIR 	= "PARAMS_FC_ROOT_DIR"; 
	
	public static final String RESULT_KEY_SELECTED_DIR  = "RESULT_KEY_SELECTED_DIR"; 
	public static final String RESULT_KEY_SELECTED_ITEM = "RESULT_KEY_SELECTED_ITEM"; 
	
	public static final int SELECT_MODE_DIR  = 0;
	public static final int SELECT_MODE_ITEM = 1;
	
	private static final int BTN_SET = 0;
	private static final int BTN_GET = 1;

	private File currentDir;
	private File rootDir;
	private FileArrayAdapter adapter;
	private int HEADER_ITEMS_COUNT = 1;

	private Button buttonSet;
	private Button buttonGet;
	private FileChooserElement selectedItem = null;
	private int fileChooserWorkMode = SELECT_MODE_DIR;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Bundle extras = getIntent().getExtras();

		currentDir = new File("/sdcard/");

		if (extras != null) {
			String dirStr = extras.getString(PARAMS_FC_WORK_DIR);
			if (dirStr != null) {
				currentDir = new File(dirStr);
				rootDir = new File(dirStr);
			}
			dirStr = extras.getString(PARAMS_FC_ROOT_DIR);
			if (dirStr != null) {
				rootDir = new File(dirStr);
			}
			fileChooserWorkMode = extras.getInt(PARAMS_FC_WORK_MODE);
		}

		ListView list = getListView();
		View header = getLayoutInflater().inflate(R.layout.file_view_header,
				null, false);

		buttonSet = (Button) header.findViewById(R.id.buttonSetPathFileView);
		buttonGet = (Button) header.findViewById(R.id.buttonGetPathFileView);

		buttonSet.setOnClickListener(new ButtonsOnClickListener(this, BTN_SET,
				buttonSet.getId()));
		buttonGet.setOnClickListener(new ButtonsOnClickListener(this, BTN_GET,
				buttonGet.getId()));

		// View footer = getLayoutInflater().inflate(R.layout.listfooter, null,
		// false);
		// ImageView image = (ImageView) header1.findViewById(R.id.image);
		if (list != null && header != null) {
			list.addHeaderView(header, null, false);
			// list.addFooterView(footer, null, false);
			// list.setAdapter(new MenuAdapter());
		}
		//rootDir = currentDir;
		fillDirStructure(currentDir, rootDir);
	}

	/**
	 * Filler directory structure
	 * 
	 * @param currentDir
	 *            - current dir for fill data
	 */
	private void fillDirStructure(File currentDir, File rootDir) {
		Drawable icon;
		File[] dirs = currentDir.listFiles();
		selectedItem = null;
		this.setTitle("Current Dir: " + currentDir.getName());
		List<FileChooserElement> dir = new ArrayList<FileChooserElement>();
		List<FileChooserElement> fls = new ArrayList<FileChooserElement>();
		try {
			for (File ff : dirs) {
				if (ff.isDirectory()) {
					icon = getResources().getDrawable(
							R.drawable.ic_launcher_folder);
					dir.add(new FileChooserElement(ff.getName(), "Folder", ff
							.getAbsolutePath(), icon));
				} else {
					icon = getResources().getDrawable(
							R.drawable.ic_launcher_file);
					fls.add(new FileChooserElement(ff.getName(), "File Size: "
							+ ff.length(), ff.getAbsolutePath(), icon));
				}
			}
		} catch (Exception e) {

		}
		Collections.sort(dir);
		Collections.sort(fls);
		dir.addAll(fls);
		
		if(fls.size()>0) { selectedItem = fls.get(0);}
		else 
		if(dir.size()>0) { selectedItem = dir.get(0);}
			
		
		if (!currentDir.getName().equalsIgnoreCase(rootDir.getName())) // "sdcard"))
			dir.add(0, new FileChooserElement("..", "Parent Directory",
					currentDir.getParent()));
		adapter = new FileArrayAdapter(FileChooser.this, R.layout.file_view,
				dir);

		this.setListAdapter(adapter);

		EditText edit = (EditText) findViewById(R.id.editTextPathFileView);
		if (edit != null) {
			edit.setText(currentDir.getPath());
		}

	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		super.onListItemClick(l, v, position, id);
		FileChooserElement o = adapter.getItem(position - HEADER_ITEMS_COUNT);
		if (o.getData().equalsIgnoreCase("folder")
				|| o.getData().equalsIgnoreCase("parent directory")) {
			currentDir = new File(o.getPath());
			fillDirStructure(currentDir, rootDir);
		} else {
			onFileClick(o);
		}
	}

	/**
	 * 
	 * @param fce
	 */
	private void onFileClick(FileChooserElement fce) {
		selectedItem = fce;
		Toast.makeText(this, "File Clicked: " + fce.getName(),
				Toast.LENGTH_SHORT).show();
		if(fileChooserWorkMode == SELECT_MODE_ITEM) {
			finish();
		}
	}

	private class ButtonsOnClickListener implements OnClickListener {

		int btnID, selID;
		Activity context;

		public ButtonsOnClickListener(Activity context, int selID, int btnID) {
			this.btnID = btnID;
			this.selID = selID;
			this.context = context;
		}

		public void onClick(View v) {
			Toast.makeText(
					context,
					"File Clicked: [" + v.getId() + "][" + selID + "][" + btnID
							+ "]" + currentDir.getPath(), Toast.LENGTH_SHORT)
					.show();

			switch (selID) {
			case BTN_SET: {
				EditText edit = (EditText) context
						.findViewById(R.id.editTextPathFileView);
				if (edit != null) {

					File goToDir = new File(edit.getText().toString());
					if (goToDir.exists()) {
						Toast.makeText(
								context,
								"File Clicked: " + v.getId() + " "
										+ edit.getText(), Toast.LENGTH_SHORT)
								.show();
						
						fillDirStructure(goToDir, rootDir);
					}
				}
			}
				break;
			case BTN_GET: {
				finish();
			}
				break;

			default:
				break;
			}
		}

	}
	
	@Override
	public void finish() {
		Intent data = new Intent();
		data.putExtra(RESULT_KEY_SELECTED_DIR,  currentDir.getPath());
		if(selectedItem!=null) {
			data.putExtra(RESULT_KEY_SELECTED_ITEM, selectedItem.getName() );
		} else {
			data.putExtra(RESULT_KEY_SELECTED_ITEM, currentDir.getPath());
		}	
		setResult(RESULT_OK, data);
		super.finish();
	}
	

}