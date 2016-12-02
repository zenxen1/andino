package com.sds.server.dto;

public class NickName {
	private int member_sequence;
	private String m_id;
	private String m_name;
	private String m_nickname;

	public int getMember_sequence() {
		return member_sequence;
	}

	public void setMember_sequence(int member_sequence) {
		this.member_sequence = member_sequence;
	}

	public String getM_id() {
		return m_id;
	}

	public void setM_id(String m_id) {
		this.m_id = m_id;
	}

	public String getM_name() {
		return m_name;
	}

	public void setM_name(String m_name) {
		this.m_name = m_name;
	}

	public String getM_nickname() {
		return m_nickname;
	}

	public void setM_nickname(String m_nickname) {
		this.m_nickname = m_nickname;
	}

}
