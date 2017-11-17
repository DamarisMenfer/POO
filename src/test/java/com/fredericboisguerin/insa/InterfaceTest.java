package com.fredericboisguerin.insa;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class InterfaceTest {
    private static final String SOME_NAME = "Nicole Ferroni";
    private static final String SOME_EMAIL = "contact@nicoleferroni.fr";
    private static final String SOME_PHONE_NUMBER = "0651387945";
    public static final String LINE_SEPARATOR = System.lineSeparator();

    @Test
    public void shouldAddContactToContactManagerWhenUserEnterNameEmailAndPhoneNumber() throws Exception {
        ContactsManager contactsManager = mock(ContactsManager.class);
        CommandLineInterface commandLineInterface = new CommandLineInterface();
        System.setIn(concatenateLines(SOME_NAME, SOME_EMAIL, SOME_PHONE_NUMBER));

        commandLineInterface.creerContact(contactsManager);

        verify(contactsManager).addContact(SOME_NAME, SOME_EMAIL, SOME_PHONE_NUMBER);
    }

    private InputStream concatenateLines(String ... lines) {
        StringBuilder concatenation = new StringBuilder();
        for (String line : lines) {
            concatenation.append(line);
            concatenation.append(LINE_SEPARATOR);
        }
        return new ByteArrayInputStream(concatenation.toString().getBytes());
    }
}
