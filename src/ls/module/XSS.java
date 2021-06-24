package ls.module;

public class XSS {

	 public static String escape(String val) {
		 if (val == null) return null;
		 val = val.replaceAll("&", "& amp;");
		 val = val.replaceAll("<", "& lt;");
		 val = val.replaceAll(">", "& gt;");
		 val = val.replaceAll("\"", "&quot;");
		 val = val.replaceAll("'", "&apos;");
		 return val;
	 }

}
