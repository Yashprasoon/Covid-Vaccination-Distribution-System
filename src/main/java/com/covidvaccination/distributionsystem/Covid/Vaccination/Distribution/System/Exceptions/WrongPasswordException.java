package com.covidvaccination.distributionsystem.Covid.Vaccination.Distribution.System.Exceptions;

public class WrongPasswordException extends RuntimeException {
    public WrongPasswordException() {
        super("Invalid or wrong password.");
    }

    public WrongPasswordException(String message) {
        super(message);
    }
}

