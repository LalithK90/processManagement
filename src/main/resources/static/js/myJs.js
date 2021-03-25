$(document).ready(function () {
    // set current year to the footer
    document.getElementById("currentYear").innerHTML = new Date().getFullYear();

    /*//Nav bar properties - start//*/
    /*//Nav bar properties - start//*/
    $('ul.navbar-nav li.dropdown').hover(function () {
        $(this).find('.dropdown-menu').stop(true, true).delay(200).fadeIn(10);
    }, function () {
        $(this).find('.dropdown-menu').stop(true, true).delay(200).fadeOut(10);
    });
    /*//Nav bar properties - end//*/
    /*//Nav bar properties - end//*/


    /*//--------------- data table short using - data table plugin ------- start //*/


    if ($("#myTable").length !== 0) {
        $("#myTable").DataTable({
            "lengthMenu": [[5, 10, 15, 20, -1], [5, 10, 15, 20, "All"]],
            "ordering": false,
            stateSave: true,
        });
    }
    if ($("#allItemTable").length !== 0) {
        $("#allItemTable").DataTable({
            "lengthMenu": [[5, 10, 15, 20, -1], [5, 10, 15, 20, "All"]],
            "ordering": false,
            stateSave: true,
        });
    }
    if ($("#bitItemTable").length !== 0) {
        $("#bitItemTable").DataTable({
            "lengthMenu": [[5, 10, 15, 20, -1], [5, 10, 15, 20, "All"]],
            "ordering": false,
            stateSave: true,
        });
    }

    /*//--------------- data table short using - data table plugin ------- start //*/

    /*When edit employee if there is a nic number need to select relevant gender*/
    if ($("#nic").val().length !==0) {
        $("input:radio[name=gender]").filter(`[value=${calculateGender($("#nic").val())}]`).prop('checked', true);
    }

    /* Patient and employee Nic Validation - start*/
    $("#nic").bind('keyup', function () {
        let nic = $(this).val();
        $("#dateOfBirth").val(calculateDateOfBirth(nic));
//access our front-end gender*/
        $("input:radio[name=gender]").filter(`[value=${calculateGender(nic)}]`).prop('checked', true);

    });

});


// regex
let nicRegex = /^([0-9]{9}[vV|xX])|^([0-9]{12})$/;
let mobileRegex = /^([0][7][\d]{8}$)|^([7][\d]{8})$/;
let landRegex = /^0((11)|(2(1|[3-7]))|(3[1-8])|(4(1|5|7))|(5(1|2|4|5|7))|(6(3|[5-7]))|([8-9]1))([2-4]|5|7|9)[0-9]{6}$/;
let nameRegex = /^[a-zA-Z .-]{5}[ a-zA-Z.-]+$/;
let numberRegex = /^([eE][hH][sS][\d]+)$/;
let invoiceNumberRegex = /^[0-9]{10}$/;


//Nic - data of birth - start
let dateLengthValidate = function (day) {
    if (day.toLocaleString().length === 1) {
        return day = '0' + day;
    }
    return day;
};

let calculateDateOfBirth = function (nic) {
    let dateOfBirth = null;
    let day = null;
    let month;
    if (nic.length === 10) {
        day = +nic.substr(2, 3);
        dateOfBirth = '19' + nic.substr(0, 2) + '-';
        if (day > 500) day = day - 500;

        //<editor-fold desc="if else block">
        if (day > 335) {
            day = day - 335;
            day = dateLengthValidate(day);
            month = 12;
        } else if (day > 305) {
            day = day - 305;
            day = dateLengthValidate(day);
            month = 11;
        } else if (day > 274) {
            day = day - 274;
            day = dateLengthValidate(day);
            month = 10;
        } else if (day > 244) {
            day = day - 244;
            day = dateLengthValidate(day);
            month = 9;
        } else if (day > 213) {
            day = day - 213;
            day = dateLengthValidate(day);
            month = 8;
        } else if (day > 182) {
            day = day - 182;
            day = dateLengthValidate(day);
            month = 7;
        } else if (day > 152) {
            day = day - 152;
            day = dateLengthValidate(day);
            month = 6;
        } else if (day > 121) {
            day = day - 121;
            day = dateLengthValidate(day);
            month = 5;
        } else if (day > 91) {
            day = day - 91;
            day = dateLengthValidate(day);
            month = 4;
        } else if (day > 60) {
            day = day - 60;
            day = dateLengthValidate(day);
            month = 3;
        } else if (day < 32) {
            day = day;
            day = dateLengthValidate(day);
            month = 1;
        } else if (day > 31) {
            day = day - 31;
            day = dateLengthValidate(day);
            month = 2;
        }
        //</editor-fold>
        if (month.toLocaleString().length === 2) {

            dateOfBirth = dateOfBirth + month + '-' + day;
        } else {

            dateOfBirth = dateOfBirth + '0' + month + '-' + day;
        }


    } else if (nic.length === 12) {
        dateOfBirth = nic.substr(0, 4) + '-';
        day = +nic.substr(4, 3);
        if (day > 500) day = day - 500;
        //<editor-fold desc="if else block">
        if (day > 335) {
            day = day - 335;
            day = dateLengthValidate(day);
            month = 12;
        } else if (day > 305) {
            day = day - 305;
            day = dateLengthValidate(day);
            month = 11;
        } else if (day > 274) {
            day = day - 274;
            day = dateLengthValidate(day);
            month = 10;
        } else if (day > 244) {
            day = day - 244;
            day = dateLengthValidate(day);
            month = 9;
        } else if (day > 213) {
            day = day - 213;
            day = dateLengthValidate(day);
            month = 8;
        } else if (day > 182) {
            day = day - 182;
            day = dateLengthValidate(day);
            month = 7;
        } else if (day > 152) {
            day = day - 152;
            day = dateLengthValidate(day);
            month = 6;
        } else if (day > 121) {
            day = day - 121;
            day = dateLengthValidate(day);
            month = 5;
        } else if (day > 91) {
            day = day - 91;
            day = dateLengthValidate(day);
            month = 4;
        } else if (day > 60) {
            day = day - 60;
            day = dateLengthValidate(day);
            month = 3;
        } else if (day < 32) {
            day = day;
            day = dateLengthValidate(day);
            month = 1;
        } else if (day > 31) {
            day = day - 31;
            day = dateLengthValidate(day);
            month = 2;
        }
        //</editor-fold>
        if (month.toLocaleString().length === 2) {
            dateOfBirth = dateOfBirth + month + '-' + day;
        } else {
            dateOfBirth = dateOfBirth + '0' + month + '-' + day;
        }
    }
    return dateOfBirth;
};

//Nic - data of birth - end

//Nic - gender - start
let calculateGender = function (nic) {
    let genders = null;
    if (nic.length === 10 && nic[9] === "V" || nic[9] === "v" || nic[9] === "x" || nic[9] === "X") {
        if (nic[9] === "v" || nic[9] === "x") {
            let message = `Please change "v" or "x" to "V" or "X" `;
            swal({
                title: "Could you please check NIC",
                icon: "warning",
                text: message,
            });
        }
        if (+nic.substr(2, 3) < 500) genders = 'MALE';
        else genders = 'FEMALE';

    } else if (nic.length === 12) {
        if (+nic.substr(4, 3) < 500) genders = 'MALE';
        else genders = 'FEMALE';
    }
    return genders;
};

//Nic - gender - end

//mobile number and land number validation
$(".mobile").bind("keyup", function () {
    mobileValidate($(this));
});

$(".land").bind("keyup", function () {
    landValidate($(this));
});

$(".fax").bind("keyup", function () {
    landValidate($(this));
});

let mobileValidate = function (val) {
    let mobile = $(val).val();
    if (mobileRegex.test(mobile)) {
        backgroundColourChangeGood(val);
    } else if (mobile.length === 0) {
        backgroundColourChangeNothingToChange(val);
    } else {
        backgroundColourChangeBad(val);
    }
};

let landValidate = function (val) {
    let land = $(val).val();
    if (landRegex.test(land)) {
        backgroundColourChangeGood(val);
    } else if (land.length === 0) {
        backgroundColourChangeNothingToChange(val);
    } else {
        backgroundColourChangeBad(val);
    }
};

//NIC colour change
$("#nic").bind("keyup", function () {
    let nic = $(this).val();
    if (nicRegex.test(nic)) {
        backgroundColourChangeGood($(this));
    } else if (nic.length === 0) {
        backgroundColourChangeNothingToChange($(this));
    } else {
        backgroundColourChangeBad($(this));
    }
});


//Name validation
$("#name").bind("keyup", function () {
    console.log("sfsdfsd")
    let name = $(this).val();
    if (nameRegex.test(name)) {
        backgroundColourChangeGood($(this));
    } else if (name.length === 0) {
        backgroundColourChangeNothingToChange($(this));
    } else {
        backgroundColourChangeBad($(this));
    }
});
//calling Name validation
$("#callingName").bind("keyup", function () {
    let name = $(this).val();
    if (nameRegex.test(name)) {
        backgroundColourChangeGood($(this));
    } else if (name.length === 0) {
        backgroundColourChangeNothingToChange($(this));
    } else {
        backgroundColourChangeBad($(this));
    }
});
//invoiceNumber validation
$("#invoiceNumber").bind("keyup", function () {
    let invoiceNumber = $(this).val();
    if (invoiceNumberRegex.test(invoiceNumber)) {
        backgroundColourChangeGood($(this));
    } else {
        backgroundColourChangeBad($(this));
    }
});

//colour change function --start
let backgroundColourChangeGood = function (id) {
    $(id).css('background-color', '#00FFFF');
};

let backgroundColourChangeBad = function (id) {
    $(id).css('background-color', '#FF00AA');
};

let backgroundColourChangeNothingToChange = function (id) {
    $(id).css('background-color', '#ffffff');
};

//colour change function -- end


// start date and end date validation
$("#startDate, #endDate").bind('change',
    function () {
        console.log("sdsadasda")
        let manufactureDate = $(`#startDate`).val();
        let expiredDate = $(`#endDate`).val();

        if (manufactureDate.length !==0 && expiredDate.length !==0) {
            if (Date.parse(manufactureDate) > Date.parse(expiredDate)) {
                swal({
                    title: "Could you accept those days.. !",
                    icon: "warning",
                    text: "Please check your date \n Expire Date can not be less than Manufacture Date",
                })
                $(`#endDate`).val($(`#startDate`).val());
            }
        }
    });

/* some content need to print use this method */

// el (id of content)is variable that need to give when function call
let printContent = function (el) {
    // restorepage = current document
    let restorepage = document.body.innerHTML;
    // printcontent = need to print area that area must enclosed with div
    document.body.innerHTML = document.getElementById(el).innerHTML;
    //called javascript print function
    window.print();
    //after print set current web page
    document.body.innerHTML = restorepage;
};

//AJAX FUNCTION CALL
async function getData(url) {
    try {
        const result = await fetch(url);
        return await result.json();
    } catch (e) {
        console.log("Error : " + e);
        conformationAndLoginWindow();

    }
}

// conformation message and to login page
let conformationAndLoginWindow = function () {
    let message = "Please give me a movement to refresh.";
    swal({
        title: "Attention !",
        icon: "warning",
        text: message,
        buttons: {
            cancel: true,
            confirm: true,
        },
    }).then(value => {
        if (value) {
            location.reload();
        }
    });
};


//custom invoice search page validation - end


//Search form date validation — end

//Customer employee Search filed - start any way in project




//password validator user add
$('#password').keyup(function () {
    $(this).attr('min', 6);
    $('#result').html(checkStrength($(this).val(), $('#result')));
});
//new password validator
$('#npsw').keyup(function () {
    $(this).attr('min', 6);
    $('#resultOne').html(checkStrength($(this).val(), $('#resultOne')));
});
//new re enter password validator
$('#nrepsw').keyup(function () {
    $(this).attr('min', 6);
    $('#resultTwo').html(checkStrength($(this).val(), $('#resultTwo')));
});
//password match
$('#nrepsw, #npsw').keyup(function () {
    let newPassword = $('#npsw').val();
    let newPasswordReEnter = $('#nrepsw').val();
    let matchPassword = $('#passwordMatch');
    if (newPassword === newPasswordReEnter && newPassword.length !== 0 && newPasswordReEnter.length !== 0) {
        matchPassword.removeClass();
        matchPassword.addClass('badge badge-pill badge-success');
        matchPassword.html('Congratulations .! &nbsp;&nbsp;&nbsp; your passwords are matched');
    } else {
        matchPassword.removeClass();
        matchPassword.addClass('badge badge-pill badge-info');
        matchPassword.html('Password is not match value');
    }
});

//filed validator
let checkStrength = function (password, filedId) {
    let strength = 0;
    if (password.length < 6) {
        filedId.removeClass();
        filedId.addClass('badge badge-pill badge-dark ');
        return `Too short  , Password length : ${password.length}`;
    }
    if (password.length > 7) strength += 1
// If password contains both lower and uppercase characters, increase strength value.
    if (password.match(/([a-z].*[A-Z])|([A-Z].*[a-z])/)) strength += 1
// If it has numbers and characters, increase strength value.
    if (password.match(/([a-zA-Z])/) && password.match(/([0-9])/)) strength += 1
// If it has one special character, increase strength value.
    if (password.match(/([!,%,&,@,#,$,^,*,?,_,~])/)) strength += 1
// If it has two special characters, increase strength value.
    if (password.match(/(.*[!,%,&,@,#,$,^,*,?,_,~].*[!,%,&,@,#,$,^,*,?,_,~])/)) strength += 1
// Calculated strength value, we can return messages
// If value is less than 2
    if (strength < 2) {
        filedId.removeClass();
        filedId.addClass('badge badge-pill badge-warning');
        return ` Weak , Password length : ${password.length}`;
    } else if (strength === 2) {
        filedId.removeClass();
        filedId.addClass('badge badge-pill badge-primary');
        return ` Good , Password length : ${password.length}`;
    } else {
        filedId.removeClass();
        filedId.addClass('badge badge-pill badge-success');
        return ` Strong , Password length : ${password.length}`;
    }
};

//password show hide button

$(".reveal").on('click', function () {
    let $pwd = $(".pwd");
    if ($pwd.attr('type') === 'password') {
        $pwd.attr('type', 'text');

    } else {
        $pwd.attr('type', 'password');
    }
});

