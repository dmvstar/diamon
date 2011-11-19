package com.h3r3t1c.filechooser;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import net.sf.dvstar.android.diamon.R;
import android.app.ListActivity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class FileChooser extends ListActivity {
	
    private File currentDir;
    private FileArrayAdapter adapter;
	private int HEADER_ITEMS_COUNT=1;
        
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        currentDir = new File("/sdcard/");
        ListView list = getListView();
		View header =  getLayoutInflater().inflate(R.layout.file_view_header, null, false);
//		 View footer = getLayoutInflater().inflate(R.layout.listfooter, null, false);
//		 ImageView image = (ImageView) header1.findViewById(R.id.image);
		if(list!=null && header != null){
			 list.addHeaderView(header, null, false);
//			 list.addFooterView(footer, null, false);
//			 list.setAdapter(new MenuAdapter());
		}
        fill(currentDir);
    }
    
    private void fill(File f)
    {
    	Drawable icon;
    	File[]dirs = f.listFiles();
		 this.setTitle("Current Dir: "+f.getName());
		 List<Option>dir = new ArrayList<Option>();
		 List<Option>fls = new ArrayList<Option>();
		 try{
			 for(File ff: dirs)
			 {
				if(ff.isDirectory()) {
					icon = getResources().getDrawable(
							R.drawable.ic_launcher_folder);
					dir.add(new Option(ff.getName(),"Folder",ff.getAbsolutePath(),icon));
				}	
				else
				{
					icon = getResources().getDrawable(
							R.drawable.ic_launcher_file);
					fls.add(new Option(ff.getName(),"File Size: "+ff.length(),ff.getAbsolutePath(),icon));
				}
			 }
		 }catch(Exception e)
		 {
			 
		 }
		 Collections.sort(dir);
		 Collections.sort(fls);
		 dir.addAll(fls);
		 if(!f.getName().equalsIgnoreCase("sdcard"))
			 dir.add(0,new Option("..","Parent Directory",f.getParent()));
		 adapter = new FileArrayAdapter(FileChooser.this,R.layout.file_view,dir);
 		 
		 
		 this.setListAdapter(adapter);
		 
         EditText edit = (EditText) findViewById(R.id.editTextPathFileView);
         if(edit != null) {
        	edit.setText(f.getPath()); 
         }
		 
    }

    
    
    @Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		super.onListItemClick(l, v, position, id);
		Option o = adapter.getItem(position-HEADER_ITEMS_COUNT);
		if(o.getData().equalsIgnoreCase("folder")||o.getData().equalsIgnoreCase("parent directory")){
				currentDir = new File(o.getPath());
				fill(currentDir);
		}
		else
		{
			onFileClick(o);
		}
	}
    
    private void onFileClick(Option o)
    {
    	Toast.makeText(this, "File Clicked: "+o.getName(), Toast.LENGTH_SHORT).show();
    }
}