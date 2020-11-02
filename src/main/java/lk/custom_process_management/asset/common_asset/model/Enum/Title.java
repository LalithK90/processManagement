package lk.custom_process_management.asset.common_asset.model.Enum;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Title {
    MR("Mr. "),
    MRS("Mrs. "),
    MISS("Miss. "),
    MS("Ms. "),
    REV("Rev. "),
    DR("Dr. "),
    DRMRS("Dr(Mrs). "),
    PRO("Prof. "),
    SISTER("Sister. ");

    private final String title;
}
