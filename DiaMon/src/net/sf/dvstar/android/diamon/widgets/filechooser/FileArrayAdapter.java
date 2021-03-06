package net.sf.dvstar.android.diamon.widgets.filechooser;

import java.util.List;

import net.sf.dvstar.android.diamon.R;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class FileArrayAdapter extends ArrayAdapter<FileChooserElement> {

	private Context c;
	private int id;
	private List<FileChooserElement> items;

	public FileArrayAdapter(Context context, int textViewResourceId,
			List<FileChooserElement> objects) {
		super(context, textViewResourceId, objects);
		c = context;
		id = textViewResourceId;
		items = objects;
	}

	public FileChooserElement getItem(int i) {
		return items.get(i);
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View v = convertView;
		if (v == null) {
			LayoutInflater vi = (LayoutInflater) c
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			v = vi.inflate(id, null);
		}
		final FileChooserElement o = items.get(position);
		if (o != null) {
			TextView t1 = (TextView) v.findViewById(R.id.file_view_item_name);
			TextView t2 = (TextView) v.findViewById(R.id.file_view_item_desc);
			ImageView icon = (ImageView) v
					.findViewById(R.id.file_view_item_icon);

			if (t1 != null)
				t1.setText(o.getName());
			if (t2 != null)
				t2.setText(o.getData());
			if (icon != null) {
				if (o.getIcon() != null) {
					icon.setImageDrawable(o.getIcon());
				}

			}

		}
		return v;
	}

}
