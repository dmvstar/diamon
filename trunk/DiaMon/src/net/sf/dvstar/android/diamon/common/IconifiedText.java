/* 
 * Copyright 2007 Steven Osborn
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      <!-- m --><a class="postlink" href="http://www.apache.org/licenses/LICENSE-2.0">http://www.apache.org/licenses/LICENSE-2.0</a><!-- m -->
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package net.sf.dvstar.android.diamon.common;

import android.graphics.drawable.Drawable;

/** @author Steven Osborn - <!-- m --><a class="postlink" href="http://steven.bitsetters.com">http://steven.bitsetters.com</a><!-- m --> */
public class IconifiedText implements Comparable<IconifiedText>{
    
	private String mText = "";
	private Drawable mIcon;
	private boolean mSelectable = true;

	public IconifiedText(String text, Drawable bullet) {
		mIcon = bullet;
		mText = text;
	}
	
	public boolean isSelectable() {
		return mSelectable;
	}
	
	public void setSelectable(boolean selectable) {
		mSelectable = selectable;
	}
	
	public String getText() {
		return mText;
	}
	
	public void setText(String text) {
		mText = text;
	}
	
	public void setIcon(Drawable icon) {
		mIcon = icon;
	}
	
	public Drawable getIcon() {
		return mIcon;
	}

	public int compareTo(IconifiedText another) {
		if(this.mText != null)
			return this.mText.compareTo(another.getText()); 
		else 
			throw new IllegalArgumentException();
	}

	/** Make IconifiedText comparable by its name */
	
}
