package com.n2n.ssnz.util;

import java.util.HashMap;
import java.util.Map;

public class Constants {
    public static Map<Integer,String> PROJECT_STATUS;
    
    static{
        if(ValidatorUtil.isEmpty(PROJECT_STATUS)){
            PROJECT_STATUS = new HashMap<>();
            PROJECT_STATUS.put(1, "Not started");
            PROJECT_STATUS.put(2, "In-progress");
            PROJECT_STATUS.put(3, "On Hold");
            PROJECT_STATUS.put(4, "Completed");
            PROJECT_STATUS.put(5, "Cancelled");
            PROJECT_STATUS.put(6, "Pending Approval");
            PROJECT_STATUS.put(7, "Delayed");
        }
    }
}
