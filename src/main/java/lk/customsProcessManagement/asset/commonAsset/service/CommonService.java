package lk.customsProcessManagement.asset.commonAsset.service;

import lk.customsProcessManagement.asset.commonAsset.model.Enum.BloodGroup;
import lk.customsProcessManagement.asset.commonAsset.model.Enum.CivilStatus;
import lk.customsProcessManagement.asset.commonAsset.model.Enum.Gender;
import lk.customsProcessManagement.asset.commonAsset.model.Enum.Title;
import lk.customsProcessManagement.asset.employee.controller.EmployeeRestController;
import lk.customsProcessManagement.asset.employee.entity.Enum.Designation;
import lk.customsProcessManagement.asset.employee.entity.Enum.EmployeeStatus;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

@Service
public class CommonService {


    //common things to employee and offender - end
    //common mobile number length employee,offender,guardian, petitioner - start
    // private final mobile length validator
    public String commonMobileNumberLengthValidator(String number) {
        if ( number.length() == 9 ) {
            number = "0".concat(number);
        }
        return number;
    }

}
