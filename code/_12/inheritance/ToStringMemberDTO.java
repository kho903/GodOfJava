package _12.inheritance;

public class ToStringMemberDTO {
	public static void main(String[] args) {
		ToStringMemberDTO toString = new ToStringMemberDTO();
		toString.noToString();
		toString.toStringOverriding();
	}

	public void noToString() {
		MemberDTO dto = new MemberDTO("jihun", "01012345678", "gmldnr2222@naver.com");
		System.out.println("-----------noToString---------------");
		System.out.println("Name=" + dto.getName() + " Phone=" + dto.phone + " eMail=" + dto.email);
	}

	public void toStringOverriding() {
		MemberDTO dto = new MemberDTO("jihun", "01012345678", "gmldnr2222@naver.com");
		System.out.println("-----------toString---------------");
		System.out.println(dto);
	}
}
