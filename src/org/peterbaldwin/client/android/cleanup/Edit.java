/*-
 *  Copyright (C) 2009 Peter Baldwin   
 *  
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package org.peterbaldwin.client.android.cleanup;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * A class describing a field edit.
 */
class Edit implements Parcelable {
	public long phoneId;
	public String original;
	public String formatted;
	public String displayName;

	public static final Parcelable.Creator<Edit> CREATOR = new Parcelable.Creator<Edit>() {
		public Edit createFromParcel(Parcel in) {
			return new Edit(in);
		}

		public Edit[] newArray(int size) {
			return new Edit[size];
		}
	};

	public Edit() {
	}

	private Edit(Parcel in) {
		phoneId = in.readLong();
		original = in.readString();
		formatted = in.readString();
		displayName = in.readString();
	}

	@Override
	public String toString() {
		return original;
	}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeLong(phoneId);
		dest.writeString(original);
		dest.writeString(formatted);
		dest.writeString(displayName);
	}
}
