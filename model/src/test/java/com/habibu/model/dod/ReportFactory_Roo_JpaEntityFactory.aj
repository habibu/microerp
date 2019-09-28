// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.habibu.model.dod;

import com.habibu.model.Report;
import com.habibu.model.dod.ReportFactory;

privileged aspect ReportFactory_Roo_JpaEntityFactory {
    
    /**
     * Creates a new {@link Report} with the given index.
     * 
     * @param index position of the Report
     * @return a new transient Report
     */
    public Report ReportFactory.create(int index) {
        Report obj = new Report();
        setType(obj, index);
        return obj;
    }
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param obj
     * @param index
     */
    public void ReportFactory.setType(Report obj, int index) {
        String type = "type_" + index;
        obj.setType(type);
    }
    
}