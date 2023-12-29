package com.covidvaccination.distributionsystem.Covid.Vaccination.Distribution.System.Exceptions;

public class WrongEmailException extends RuntimeException {
    public WrongEmailException() {
        super("Invalid or wrong email format.");
    }

    public WrongEmailException(String message) {
        super(message);
    }
}

