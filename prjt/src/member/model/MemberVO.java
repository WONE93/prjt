package member.model;

public class MemberVO {

	String id;
	String pwd;
	String name;
	String hobby;
	String gender;
	String religion;
	String introduction;
	String regdt; //가입일자 
	//lombok이라고 자동으로 게터엔세터 추가해주는 기능이 있음 필드만 선언하면 알아서
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getReligion() {
		return religion;
	}

	public void setReligion(String religion) {
		this.religion = religion;
	}

	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	public String getRegdt() {
		return regdt;
	}

	public void setRegdt(String regdt) {
		this.regdt = regdt;
	}

	@Override
	public String toString() {
		return "MemberVO [id=" + id + ", pwd=" + pwd + ", name=" + name + ", hobby=" + hobby + ", gender=" + gender
				+ ", religion=" + religion + ", introduction=" + introduction + ", regdt=" + regdt + "]";
	}

}
