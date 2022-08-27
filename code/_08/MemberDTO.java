public class MemberDTO {
	private String name;
	public String phone;
	public String email;

	public MemberDTO() {
		// 아무 정보도 모를 때
	}

	public MemberDTO(String name) {
		// 이름만 알 때;
		this.name = name;
	}

	public MemberDTO(String name, String phone) {
		// 이름, 전화번호만 알 떄
		this.name = name;
		this.phone = phone;
	}

	public MemberDTO(String name, String phone, String email) {
		// 모든 정보를 알고 있을 때
		this.name = name;
		this.phone = phone;
		this.email = email;
	}

	public String getName() { // 조회용
		return name;
	}
}
