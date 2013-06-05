package kebbiter.util;

public class GrandExchange {

	public static class Item {
		private String name;
		private int price;
		private String dayChange;
		private String sDayChange;
		private String mDayChange;
		private String lDayChange;

		public Item(int price) {
			this.price = price;
		}

		public Item() {

		}

		public String getName() {
			return name;
		}

		public int getPrice() {
			return price;
		}

		public String getDayChange() {
			return dayChange;
		}

		public String getsDayChange() {
			return sDayChange;
		}

		public String getmDayChange() {
			return mDayChange;
		}

		public String getlDayChange() {
			return lDayChange;
		}

		public void setName(String name) {
			this.name = name;
		}

		public void setPrice(String price) {
			price = price.replaceAll(",", "");
			this.price = Integer.parseInt(price);
		}

		public void setDayChange(String dayChange) {
			this.dayChange = dayChange;
		}

		public void setsDayChange(String sDayChange) {
			this.sDayChange = sDayChange;
		}

		public void setmDayChange(String mDayChange) {
			this.mDayChange = mDayChange;
		}

		public void setlDayChange(String lDayChange) {
			this.lDayChange = lDayChange;
		}

	}

	public static Item getItem(int itemId) {

		String page = getPageById(itemId);
        return getItem(page);
	}

	private static Item getItem(String pageData) {
		try {
			Item i = new Item();
			TextPowerEdit tpe = new TextPowerEdit(pageData);
			tpe.setMoveWithText(true);

			tpe.setChunk("Current guide price:", "</table>", true);
			i.setPrice(tpe.getChunk("<td>", "</td>", false));
			//i.setDayChange(tpe.getChunk("ive\">", "</td>", false));
			//i.setsDayChange(tpe.getChunk("ive\">", "</td>", false));
			//i.setmDayChange(tpe.getChunk("ive\">", "</td>", false));
			//i.setlDayChange(tpe.getChunk("ive\">", "</td>", false));
			return i;
		} catch (Exception e) {
			return new Item(0);
		}
	}

	private static String getPageById(int id) {
		TcpSocket comm = new TcpSocket();
		return comm.requestData("services.runescape.com",
				"/m=itemdb_rs/viewitem.ws?obj=" + id);
	}
}
