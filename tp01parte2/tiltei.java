public static String tiltei(String input){
		input=input.replaceAll("\u00E3","a");
		input=input.replaceAll("\u00E1","a");
		input=input.replaceAll("\u00E3","a");
		input=input.replaceAll("\u00E2","a");
		input=input.replaceAll("\u00E9","e");
		input=input.replaceAll("\u00ED","i");
		input=input.replaceAll("\u00FA","u");
		input=input.replaceAll("\u00E7","c");
		return input;
	}