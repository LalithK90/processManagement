package lk.custom_process_management.util.service;


import org.springframework.stereotype.Service;

@Service
public class MakeAutoGenerateNumberService {
    private final DateTimeAgeService dateTimeAgeService;

    public MakeAutoGenerateNumberService(DateTimeAgeService dateTimeAgeService) {
        this.dateTimeAgeService = dateTimeAgeService;
    }

    public Integer numberAutoGen(String lastNumber) {
        System.out.println("last number " + lastNumber);
        int newNumber;
        int previousNumber;
        int newNumberFirstTwoCharacters;

        int currentYearLastTwoNumber =
                Integer.parseInt(String.valueOf(dateTimeAgeService.getCurrentDate().getYear()).substring(2, 4));

        if ( lastNumber != null ) {
            previousNumber = Integer.parseInt(lastNumber.substring(0, 6));
            newNumberFirstTwoCharacters = Integer.parseInt(lastNumber.substring(0, 2));

            if ( currentYearLastTwoNumber == newNumberFirstTwoCharacters ) {
                newNumber = previousNumber + 1;
            } else {
                newNumber = previousNumber + 10000;
            }
        } else {
            newNumber = Integer.parseInt(currentYearLastTwoNumber + "0000");
        }
        return newNumber;
    }

    // phone number length validator
    public String phoneNumberLengthValidator(String number) {
        if ( number.length() == 9 ) {
            number = "0".concat(number);
        }
        return number;
    }

    public String makeUniqueNumber(String receivingCode, String lastCode) {
        String receivingLastCode = lastCode.substring(0, 2);

        int newCodeValue = Integer.parseInt(receivingLastCode) + 1;

        String newCode = receivingCode;
        if ( newCodeValue < 10 ) {
            newCode = newCode.concat("0000").concat(String.valueOf(newCodeValue));
        } else if ( newCodeValue < 100 ) {
            newCode = newCode.concat("000").concat(String.valueOf(newCodeValue));
        } else if ( newCodeValue < 1000 ) {
            newCode = newCode.concat("00").concat(String.valueOf(newCodeValue));
        } else if ( newCodeValue < 10000 ) {
            newCode = newCode.concat("0").concat(String.valueOf(newCodeValue));
        } else if ( newCodeValue < 100000 ) {
            newCode = newCode.concat(String.valueOf(newCodeValue));
        }
        return newCode;
    }

}