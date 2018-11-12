package com.zyla.assignment.service;

import com.zyla.assignment.db.ConfigDAO;
import com.zyla.assignment.db.PhoneNumberDAO;
import com.zyla.assignment.model.PhoneNumber;
import org.skife.jdbi.v2.sqlobject.CreateSqlObject;

public abstract class PhoneNumberService {
    @CreateSqlObject
    abstract PhoneNumberDAO phoneNumberDAO();

    @CreateSqlObject
    abstract ConfigDAO configDAO();

    public PhoneNumber generateNumber() {
        long lastAllottedNum = Long.valueOf(configDAO().getLastAllottedNum().getVal());
        try {
            PhoneNumber nextNumber = new PhoneNumber(lastAllottedNum);
            int modifiedRows = 0;
            while (modifiedRows != 1 && lastAllottedNum > 1111111111L) {
                nextNumber.setPhone(--lastAllottedNum);
                modifiedRows = phoneNumberDAO().createNumber(nextNumber);
            }
            if (modifiedRows > 0) {
                configDAO().editLastAllottedNum(lastAllottedNum);
                return nextNumber;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public PhoneNumber generateNumber(PhoneNumber customPhone) {
        if (customPhone != null) {
            try {
                int modifiedRows = phoneNumberDAO().createNumber(customPhone);
                if (modifiedRows > 0) {
                    return customPhone;
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return generateNumber();
    }
}
