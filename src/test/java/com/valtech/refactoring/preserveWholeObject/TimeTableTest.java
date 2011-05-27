package com.valtech.refactoring.preserveWholeObject;


import java.util.List;

import junit.framework.Assert;

import org.junit.Test;


public class TimeTableTest {

	@Test
    public void createTimeTable()
    {
         Schedule schedule1 = new Schedule("01/01/2007", "31/12/2008", "Photography");
         Schedule schedule2 = new Schedule("01/03/2007", "01/04/2007", "Flower Arranging");

         TimeTable timeTable = new TimeTable(schedule1, schedule2);
         List<String> formattedTable = timeTable.createTimeTable();

         Assert.assertEquals(2, formattedTable.size());
         Assert.assertEquals("Photography: 01/01/2007 - 31/12/2008", formattedTable.get(0));
         Assert.assertEquals("Flower Arranging: 01/03/2007 - 01/04/2007", formattedTable.get(1));
     }

}
