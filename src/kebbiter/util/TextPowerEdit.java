package kebbiter.util;

class TextPowerEdit {
	private String current;
	private boolean mwt;
	private int mwtCount;

	public TextPowerEdit(String text) {
		current = text;
	}

	public String getDate() {

		String input = current;
		for (int i = 0; i < input.length(); i++) {
			if (input.length() >= i + 4) {
				String tmp = input.substring(i, i + 4);
				if (checkDate(tmp)) {
					return tmp;
				}
			}

		}
		return "";
	}

	private boolean checkDate(String input) {
		try {
			Integer.parseInt(input);
            return input.length() >= 4;

		} catch (Exception e) {
			return false;
		}
	}

	public String getCurrent() {
		return current;
	}

	public void setMoveWithText(boolean value) {
		mwt = value;
		if (!value) {
			mwtCount = 0;
		}
	}

	public int getMoveWithTextPosition() {
		return mwtCount;
	}

	public void setMoveWithTextPosition(int value) {
		if (value < current.length() && value > -1 && mwt) {
			mwtCount = value;
		}
	}

	public String getChunk(String from, String to, boolean inclusive) {
		int curLoc = current.indexOf(from, mwtCount);
		String tmp = current.substring(curLoc);
		int curLoc2;
		if (!inclusive) {
			tmp = tmp.substring(from.length());
			curLoc2 = tmp.indexOf(to);
			tmp = tmp.substring(0, curLoc2);
		} else {
			curLoc2 = tmp.indexOf(to);
			tmp = tmp.substring(0, curLoc2 + to.length());
		}
		if (mwt) {
			mwtCount = curLoc + curLoc2 + 1;
		}
		return tmp.trim();
	}

	public void setChunk(String from, String to, boolean inclusive) {
		String tmp = current.substring(current.indexOf(from));
		if (!inclusive) {
			tmp = tmp.substring(from.length());
			tmp = tmp.substring(0, tmp.indexOf(to));
		} else {
			tmp = tmp.substring(0, tmp.indexOf(to) + to.length());
		}
		current = tmp;
	}
}