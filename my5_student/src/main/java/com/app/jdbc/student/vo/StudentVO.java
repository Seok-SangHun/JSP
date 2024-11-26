package com.app.jdbc.student.vo;

import java.util.Objects;

public class StudentVO {
	private Long id;
	private String studentName;
	private int studentScore;
	
	public StudentVO() {;}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public int getStudentScore() {
		return studentScore;
	}

	public void setStudentScore(int studentScore) {
		this.studentScore = studentScore;
	}

	@Override
	public String toString() {
		return "StudentVO [id=" + id + ", studentName=" + studentName + ", studentScore=" + studentScore + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StudentVO other = (StudentVO) obj;
		return Objects.equals(id, other.id);
	}
	
	
}
