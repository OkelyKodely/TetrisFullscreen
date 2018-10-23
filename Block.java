class Block {
	private int y;
	private int x;
	private String pointing;
	private String type;
	public String getInfo(String kind) {
		return "pointing".equals(kind) ? this.pointing : ("type".equals(kind) ? this.type : null);
	}
	public int set(String position, int val) {
		return "x".equals(position) ? this.x = val : ("y".equals(position) ? this.y = val : val);
	}
	public int get(String position) {
		return "x".equals(position) ? this.x : ("y".equals(position) ? this.y : -1);
	}
	public void setInfo(String kind, String val) {
		if("pointing".equals(kind)) {
			this.pointing = val;
		} else {
			if("type".equals(kind)) {
				this.type = val;
			} else {
				this.pointing = this.pointing;
			}
		}
	}
}