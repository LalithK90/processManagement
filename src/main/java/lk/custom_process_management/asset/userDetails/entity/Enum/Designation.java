package lk.custom_process_management.asset.userDetails.entity.Enum;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Designation {
    //All station can check
    SC("Superintendent"),
    ASC("Assistance Superintendent"),
    //Below guy has check station belong to him
    IC("Inspector"),
    CG("Customs Guard");

    private final String designation;
}
