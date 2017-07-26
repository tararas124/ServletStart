/**
 * Created by taras on 20.06.2017.
 */
function checkPasswords() {
    var v1 = document.getElementById('pass');
    var v2 = document.getElementById('pass2');
    var x = document.getElementsByClassName("change");

    if (x[0].classList.contains('has-success')) x[0].classList.remove('has-success');
    if (x[1].classList.contains('has-success')) x[1].classList.remove('has-success');
    if (x[0].classList.contains('has-error')) x[0].classList.remove('has-error');
    if (x[1].classList.contains('has-error')) x[1].classList.remove('has-error');

    if (v1.value === "" && v2.value === "") {
        return;
    } else if (v1.value === v2.value) {
        x[0].classList.add('has-success');
        x[1].classList.add('has-success');
    } else {
        x[0].classList.add('has-error');
        x[1].classList.add('has-error');
    }
}

function validateMenu() {
    var age = document.forms["menuForm"]["age"].value;

    if (isNaN(age)) {
        alert("Age must be number");
        return false;
    }
}

function validateLogin() {
    var v1 = document.getElementById('pass');
    var v2 = document.getElementById('pass2');

    if (v1.value !== v2.value) {
        alert("Passwords are different!");
        return false;
    }
}

function validateRegist() {
    var age = document.forms["form"]["age"].value;
    var v1 = document.getElementById('pass');
    var v2 = document.getElementById('pass2');

    if (isNaN(age)) {
        alert("Age must be number");
        return false;
    }

    if (v1.value !== v2.value) {
        alert("Passwords are different!")
        return false;
    }
}

function validateItem () {
    var state = document.forms["form"]["state"].value;

    if (isNaN(state)) {
        alert("State must be number");
        return false;
    }
}