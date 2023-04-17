import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class OCRSolution {

	public boolean solution(String S, String T) {

		if (S.length() != T.length()) {
			return false;
		}

		List<String> sList = getStringFormatted(S);
		List<String> tList = getStringFormatted(T);
		// write your code in Java SE 8

		for (int i = 0; i < sList.size(); i++) {
			String caracterS = sList.get(i);
			String caracterT = tList.get(i);
			if (!caracterS.equals(caracterT) && !caracterT.equals("?")  && !caracterS.equals("?")) {
				return false;
			}
		}

		return true;
	}

	private List<String> getStringFormatted(String string) {

		List<String> list = new ArrayList<>();
		for (int i = 0; i < string.length(); i++) {
			String caracter = string.substring(i, i+1);

			if (isNumeric(caracter)) {
				for (int j = 0; j < Long.parseLong(caracter); j++) {
					list.add("?");
				}
			} else {
				list.add(caracter);
			}

		}

		return list;
	}

	private Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");

	public boolean isNumeric(String strNum) {
		if (strNum == null) {
			return false;
		}
		return pattern.matcher(strNum).matches();
	}

	@Test
	public void test() {
		Assertions.assertTrue(solution("A2LE", "2pL1"));
	}


}
