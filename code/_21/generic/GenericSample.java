package _21.generic;

public class GenericSample {
	public static void main(String[] args) {
		GenericSample sample = new GenericSample();
		// sample.checkCastingDTO();
		sample.checkGenericDTO();
	}

	public void checkCastingDTO() {
		CastingDTO dto1 = new CastingDTO();
		dto1.setObject(new String());

		CastingDTO dto2 = new CastingDTO();
		dto2.setObject(new StringBuffer());

		CastingDTO dto3 = new CastingDTO();
		dto3.setObject(new StringBuilder());

		String temp1 = (String)dto1.getObject();
		StringBuffer temp2 = (StringBuffer)dto2.getObject();
		StringBuilder temp3 = (StringBuilder)dto3.getObject();

		checkDTO(dto2);
		checkDTO(dto3);
	}

	public void checkDTO(CastingDTO dto) {
		Object tempObject = dto.getObject();
		if (tempObject instanceof StringBuilder) {
			System.out.println("StringBuilder");
		} else if (tempObject instanceof StringBuffer) {
			System.out.println("StringBuffer");
		}
	}

	public void checkGenericDTO() {
		CastingGenericDTO<String> dto1 = new CastingGenericDTO<String>();
		dto1.setObject(new String());
		
		CastingGenericDTO<StringBuffer> dto2 = new CastingGenericDTO<StringBuffer>();
		dto2.setObject(new StringBuffer());
		
		CastingGenericDTO<StringBuilder> dto3 = new CastingGenericDTO<StringBuilder>();
		dto3.setObject(new StringBuilder());

		String temp1 = dto1.getObject();
		StringBuffer temp2 = dto2.getObject();
		StringBuilder temp3 = dto3.getObject();
	}
}
