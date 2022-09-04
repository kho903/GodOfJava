package _15.string;

public class StringSample {
	public static void main(String[] args) {
		StringSample sample = new StringSample();
		//sample.convert();
		//sample.convertUTF16();
		sample.convertExample();
	}

	public void convert() {
		try {
			String korean = "한글";

			byte[] array1 = korean.getBytes("EUC-KR");
			for (byte data : array1) {
				System.out.print(data + " ");
			}
			System.out.println();
			String korean2 = new String(array1, "EUC-KR");
			System.out.println(korean2);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public void convertUTF16() {
		try {
			String korean = "한글";

			byte[] array1 = korean.getBytes("UTF-16");
			printByteArray(array1);
			String korean2 = new String(array1, "UTF-16");
			System.out.println(korean2);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public void convertExample() {
		try {
			String korean = "자바의신";
			byte[] euckrArr = korean.getBytes("EUC-KR");
			byte[] utf16Arr = korean.getBytes("UTF-16");
			String koreanEuckr = new String(euckrArr, "EUC-KR");
			String koreanUtf16 = new String(utf16Arr, "UTF-16");
			printByteArray(euckrArr);
			System.out.println("EUC-KR : " + koreanEuckr);
			printByteArray(utf16Arr);
			System.out.println("UTF-16 : " + koreanUtf16);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public void printByteArray(byte[] array) {
		for (byte data : array) {
			System.out.print(data + " ");
		}
		System.out.println();
	}
}
