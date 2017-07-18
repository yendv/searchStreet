package com.commonutils;

public class EnumDRIVER {
	public enum EStatusRecord {

		ACTIVE("Đang sử dụng", new Long(1)) , 
		NEWRECORD("Tạo mới", new Long(0));

		private EStatusRecord(String name, Long value) {
			this.name = name;
			this.value = value;
		}

		private String name;
		private Long value;

		public String getName() {
			return name;
		}

		public Long getValue() {
			return value;
		}

	}

	public enum EStatusUser {
		ONLINE("Đang hoạt động", "Online", new Long(1)) ,
		BUSY("Đang di chuyển", "Busy", new Long(1)) ,
		OFFLINE("Tạm nghỉ", "Offline", new Long(1));

		private EStatusUser(String nameVN, String nameEN , Long value) {
			this.nameVN = nameVN;
			this.nameEN = nameEN;
			this.value = value;
		}

		private String nameVN;
		private String nameEN;
		private Long value;

		public String getNameVN() {
			return nameVN;
		}

		public Long getValue() {
			return value;
		}

		public String getNameEN() {
			return nameEN;
		}
	}
}
