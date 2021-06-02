package Entity;


import java.util.*;
import java.io.*;
//import java.sql.Time;
/**
 * Represents the access period of StarPlanner. An accessperiod is tied to a school
 * as the access period for each school is different.
 * 
 * @author 
 * 
 * 
 */
public class accessperiod implements Serializable{
	/**
	 * The start date and time of this accessperiod.
	 */

    private Date startDate;
    /**
	 * The end date and time of this accessperiod.
	 */
    private Date endDate; 
    
    /**
     * Creates an accessperiod
     * @param startDate
     * @param endDate
     */

    public accessperiod(Date startDate, Date endDate){
        this.startDate = startDate;
        this.endDate = endDate;
    }
    /**
     * Gets the start date and time of this accessperiod.
     * @return this accessperiod's start date and time.
     */

    public Date getstartDate(){
        return startDate;
    }
    
    /**
     * Gets the end date and time of this accessperiod.
     * @return this accessperiod's end date and time.
     */


    public Date getendDate(){
        return endDate;
    }
    
    /**Changes the start date and time of this accessperiod .
     * 
     * @param startDate
     * 				this accessperiod's new start date and time.
     */

    public void setstartDate(Date startDate){
        this.startDate = startDate;
    }
    
    /**Changes the end date and time of this accessperiod.
     * 
     * @param endDate
     * this accessperiod's new end date and time.
     */

    public void setendDate(Date endDate){
        this.endDate = endDate;
    }
    
    public boolean equals(Object o) {
		if (o instanceof accessperiod) {
			accessperiod p = (accessperiod)o;
			return (getstartDate().equals(p.getstartDate()) && getendDate().equals(p.getendDate()));
		}
		return false;
	}
}