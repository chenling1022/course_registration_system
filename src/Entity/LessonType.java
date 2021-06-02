package Entity;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Represents a Lesson which an Index has.
 * 
 * @author chenlingcui
 *
 */
public class LessonType implements Serializable{
	/**
	 * The class type of this Lesson.
	 */
	private String classType;
	/**
	 * The day of this Lesson is held.
	 */
	private String day_of_week;
	/**
	 * The start time of this Lesson.
	 */
	private String start_time;
	/**
	 * The end time of this Lesson.
	 */
	private String end_time;
	
	/**
	 * The week of this Lesson is held. 
	 */
	private String week;
	/**
	 * The venue where this Lesson is held.
	 */
	private String venue;
	
	/**
	 * Creates a LessonType.
	 * 
	 * @param classType
	 * @param day_of_week
	 * @param start_time
	 * @param end_time
	 * @param week
	 * @param venue
	 */
	public LessonType(String classType, String day_of_week, String start_time, String end_time, String week, String venue){
		
		this.classType = classType;
		this.day_of_week = day_of_week;
		this.start_time = start_time;
		this.end_time = end_time;
		this.week = week;
		this.venue = venue;
	}
	
	/**
	 * Gets the class type of this Lesson.
	 * @return classType of this lesson.
	 */
	public String getClassType() {
		return classType;
	}
	/**
	 * Gets the day which this Lesson is held on.
	 * @return day of this lesson.
	 */
	public String getDay() {
		return day_of_week;
	}
	/**
	 * Gets the end time of this Lesson.
	 * @return end time of this lesson.
	 */
	public String getEndtime() {
		return end_time;
	}
	/**
	 * Gets the start time of this Lesson.
	 * @return start time of this lesson.
	 */
	public String getStarttime() {
		return start_time;
	}
	/**
	 * Gets the venue of this Lesson.
	 * @return venue of this lesson.
	 */
	public String getVenue() {
		return venue;
	}
	/**
	 * Gets the week which this Lesson is held in.
	 * @return week of this lesson.
	 */
	public String getWeek() {
		return week;
	}
	
	/**
	 * Changes the class type of this Lesson.
	 * @param classType
	 * this Lesson's new class type.
	 */
	public void setClassType(String classType) {
		this.classType = classType;
	}
	/**
	 * Changes the day which the class is held on.
	 * @param day
	 * this Lesson's new day.
	 */
	public void setDay(String day) {
		this.day_of_week = day;
	}
	/**
	 * Changes the start time of the class.
	 * @param starttime
	 * this Lesson's new day.
	 */
	public void setStarttime(String starttime) {
		this.start_time = starttime;
	}
	/**
	 * Changes the end time of the class.
	 * @param endtime
	 * this Lesson's end time.
	 */
	public void setEndtime(String endtime) {
		this.end_time = endtime;
	}
	
	/**
	 * Changes the venue of the class.
	 * @param venue
	 * this Lesson's venue.
	 */
	public void setVenue(String venue) {
		this.venue = venue;
	}
	/**
	 * Changes the week of the class.
	 * @param week
	 * this Lesson's week.
	 */
	public void setWeek(String week) {
		this.week = week;
	}
	
	/**
	 * Checks against Lesson object array to determine if any time clash. If
	 * there is a time clash return true if not return false.
	 * 
	 * @param newlist
	 *            the Lesson array that want to compare with.
	 * @return true or false.
	 */
		public boolean isTimeClashBLesson(ArrayList<LessonType> newlist) {
		boolean isClash = false;
		try {
			Date thisstarttime = new SimpleDateFormat("HHmm").parse(this.getStarttime());
			Date thisendtime = new SimpleDateFormat("HHmm").parse(this.getEndtime());

			for (int i = 0; i < newlist.size(); i++) {
				if (this.day_of_week.equals(newlist.get(i).getDay())) {
					if ((this.week.equalsIgnoreCase("EVEN") & newlist.get(i).getWeek().equalsIgnoreCase("ODD"))
							| (this.week.equalsIgnoreCase("ODD") & newlist.get(i).getWeek().equalsIgnoreCase("EVEN"))) {
						continue;
					}
					Date newstarttime = new SimpleDateFormat("HHmm").parse(newlist.get(i).getStarttime());
					Date newendtime = new SimpleDateFormat("HHmm").parse(newlist.get(i).getEndtime());

					if (newstarttime.equals(thisstarttime)
							| (newstarttime.before(thisendtime) & newstarttime.after(thisstarttime)))
						isClash = true;
					else if (newendtime.equals(thisendtime)
							| (newendtime.after(thisstarttime) & newendtime.before(thisendtime)))
						isClash = true;
				}
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (isClash)
			return true;
		else
			return false;
	}
	
	

	
		public boolean equals(Object o) {
			if (o instanceof LessonType) {
				LessonType p = (LessonType)o;
				return (getClassType().equalsIgnoreCase(p.getClassType()));
			}
			return false;
		}
	
}