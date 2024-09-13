package dev.coms4156.project.individualproject;

import java.io.Serial;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;


/**
 * Represents a department within an educational institution.
 * This class stores information about the department, including its code,
 * courses offered, department chair, and number of majors.
 */
public class Department implements Serializable {

  /**
   * Constructs a new Department object with the given parameters.
   *
   * @param deptCode         The code of the department.
   * @param courses          A HashMap containing courses offered by the department.
   * @param departmentChair  The name of the department chair.
   * @param numberOfMajors   The number of majors in the department.
   */
  public Department(String deptCode, Map<String, Course> courses, String departmentChair,
      int numberOfMajors) {
    this.deptCode = deptCode;
    this.courses = (courses != null) ? courses : new HashMap<>();
    this.departmentChair = departmentChair;
    this.numberOfMajors = numberOfMajors;
  }

  /**
   * Gets the department code.
   *
   * @return The department code
   */
  public String getDeptCode() {
    return this.deptCode;
  }

  /**
   * Gets the number of majors in the department.
   *
   * @return The number of majors.
   */
  public int getNumberOfMajors() {
    return this.numberOfMajors;
  }

  /**
   * Gets the name of the department chair.
   *
   * @return The name of the department chair.
   */
  public String getDepartmentChair() {
    return this.departmentChair;
  }

  /**
   * Gets the courses offered by the department.
   *
   * @return A HashMap containing courses offered by the department.
   */
  public Map<String, Course> getCourseSelection() {
    return this.courses;
  }

  /**
   * Increases the number of majors in the department by one if original
   * number of majors is non-negative; otherwise throws an IllegalStateException.
   */
  public void addPersonToMajor() {
    if (numberOfMajors < 0) {
      throw new IllegalStateException("Number of majors cannot be negative");
    }
    this.numberOfMajors++;
  }

  /**
   * Decreases the number of majors in the department by one if original
   * number of majors is positive; otherwise throws an IllegalStateException.
   */
  public void dropPersonFromMajor() {
    if (numberOfMajors <= 0) {
      throw new IllegalStateException("Number of majors must be larger than 0 when dropping");
    }
    this.numberOfMajors--;
  }

  /**
   * Adds a new course to the department's course selection.
   *
   * @param courseId The ID of the course to add.
   * @param course   The Course object to add.
   */
  public void addCourse(String courseId, Course course) {
    courses.put(courseId, course);
  }

  /**
   * Creates and adds a new course to the department's course selection.
   *
   * @param courseId           The ID of the new course.
   * @param instructorName     The name of the instructor teaching the course.
   * @param courseLocation     The location where the course is held.
   * @param courseTimeSlot     The time slot of the course.
   * @param capacity           The maximum number of students that can enroll in the course.
   */
  public void createCourse(String courseId, String instructorName, String courseLocation,
      String courseTimeSlot, int capacity) {
    Course newCourse = new Course(instructorName, courseLocation, courseTimeSlot, capacity);

    addCourse(courseId, newCourse);
  }

  /**
   * Returns a string representation of the department, including its code and the courses offered.
   *
   * @return A string representing the department.
   */
  @Override
  public String toString() {
    StringBuilder result = new StringBuilder();
    for (Map.Entry<String, Course> entry : courses.entrySet()) {
      String key = entry.getKey();
      Course value = entry.getValue();
      result.append(deptCode).append(" ").append(key).append(": ").append(value.toString())
          .append("\n");
    }
    return result.toString();
  }

  @Serial
  private static final long serialVersionUID = 234567L;
  private Map<String, Course> courses;
  private String departmentChair;
  private String deptCode;
  private int numberOfMajors;
}